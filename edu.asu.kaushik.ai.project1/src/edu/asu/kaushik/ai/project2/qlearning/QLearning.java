package edu.asu.kaushik.ai.project2.qlearning;

import java.util.HashMap;
import java.util.Random;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

public class QLearning {
	MDP world;
	int numStates;     // number of states in the world 
	int numActions;   // number of actions available to each state
	
	String[] actionNames;
	
	double Q[][];	  // Q value table
	int N[][];		  // frequency table 
	
	double delta = 0.0d;	// for keeping track of convergence
	double discFac;
	
	// reverse maps for easy indexing into N and Q
	HashMap<String, Integer> actioNameToIndex;
	HashMap<State, Integer> stateToIndex;
	
	// used by the agent function
	int prevStateId = -1;
	int prevActionId = -1;
	double prevReward = 0.0d;
	
	Random random;
	
	
	public QLearning(MDP world, String[] actionNames, double discountFactor, long randSeed) {
		super();
		this.random = new Random(randSeed);
		
		this.world = world;
		this.discFac = discountFactor;
		this.numStates = world.getNumStates();
		this.numActions = actionNames.length;
		
		this.actionNames = actionNames;
		
		// Since the world has to have a terminating state "None" action will always be there
		this.Q = new double[this.numStates][numActions + 1];
		this.N = new int[this.numStates][this.numActions];
		
		// set up the actioNameToIndex map
		this.actioNameToIndex = new HashMap<String, Integer>();
		for (int i = 0; i < this.numActions; i++) {
			this.actioNameToIndex.put(actionNames[i], i);
		}
		this.actioNameToIndex.put("None", this.numActions);
		
		// set up the stateToIndex map
		this.stateToIndex = new HashMap<State, Integer>();
		State[] states = this.world.getStates();
		for (int i = 0; i < this.numStates; i++) {
			this.stateToIndex.put(states[i], i);
		}
	}
	
	public void run(int numTrials) throws Exception {
		// this loop runs the trials
		for (int i = 0; i < numTrials; i++) {
			State s = world.getStartState();
			// this loop runs each step of the trial
			while(true) {
				Action a = this.QLearningAgent(s, s.getReward());
				if (a == null) {
					break;      // break only when the state s is terminal
				} 
				else {
					s = this.generateNextState(a);
				}
			}
		}
		
	}

	private State generateNextState(Action a) {
		State[] states = this.world.getStates();
		int[] stateIds = a.getNextStateIds();
		double[] probs = a.getProbs();
		
		double outcome = this.random.nextDouble();
		double action = 0.0d;
		for (int i = 0; i < stateIds.length; i++){
			action = action + probs[i];
			if (outcome <= action) {
				return states[stateIds[i]];
			}
		}
		
		return states[stateIds[stateIds.length - 1]];
	}

	private Action QLearningAgent(State currentState, double reward) throws Exception {
		int currentStateId = this.stateToIndex.get(currentState);
		boolean isTerminalState = world.isTerminalState(currentState);
		if (isTerminalState) {
			this.Q[currentStateId][this.actioNameToIndex.get("None")] = reward;
		}
		if (this.prevStateId != -1) {			
			this.N[prevStateId][prevActionId]++;
			
			this.Q[prevStateId][prevActionId] = this.Q[prevStateId][prevActionId] +
					this.alpha(this.N[prevStateId][prevActionId]) * (this.prevReward + 
							this.discFac * this.maxQValue(currentStateId) - this.Q[prevStateId][prevActionId]);
		}
		
		this.prevStateId = currentStateId;
		this.prevReward = reward;
		
		if (isTerminalState) {
			this.prevActionId = this.numActions;
			return null;			
		}
		else {
			// uses exploration function to find out the next action
			int actionId = this.nextActionId(currentStateId);
			this.prevActionId = actionId; 
			
			Action action = currentState.getActions()[actionId];
			if (this.actionNames[actionId].compareTo(action.getActionName()) == 0) {
				return action;
			}
			else {
				throw new Exception("Error: Action names were not given in the correct sequence.");
			}
		}
	}

	/**
	 * Uses exploration function to find next action
	 * @param currentStateId
	 * @return index of the next action
	 */
	private int nextActionId(int currentStateId) {
		int actionId = 0;
		double max = this.explorationFunction(currentStateId, 0);
		double val;
		for (int i = 1; i < this.numActions; i++) {
			val = this.explorationFunction(currentStateId, i); 
			if (val > max) {
				max = val;
				actionId = i;
			}
		}
		return actionId;
	}

	private double explorationFunction(int currentStateId, int actionId) {
		return functionFromBook(this.Q[currentStateId][actionId], this.N[currentStateId][actionId]);
	}

	private double functionFromBook(double u, int n) {
		double Rplus = 2.00d;
		int Ne = 5;

		return (n < Ne)? Rplus : u;
	}

	// look up the Q table to find out the actionId with maximum Q value for this state
	private double maxQValue(int currentStateId) {
		if (this.world.isTerminalState(this.world.getStates()[currentStateId])) {
			return this.Q[currentStateId][this.numActions];
		}
		else {
			double max = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < this.numActions; i++) {
				if (this.Q[currentStateId][i] > max) {
					max = this.Q[currentStateId][i];
				}
			}
			return max;
		}
	}

	private double alpha(int n) {
		return ((double)60) / (59 + n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
