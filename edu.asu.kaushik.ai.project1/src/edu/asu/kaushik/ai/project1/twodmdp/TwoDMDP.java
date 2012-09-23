package edu.asu.kaushik.ai.project1.twodmdp;

import java.util.HashMap;

import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

public class TwoDMDP implements MDP {
	/**
	 * One dimensional array for storing the states
	 */
	private TwoDMDPState[] states;
	
	/**
	 * Boundary of the 2 dimensional environment
	 */
	private int xLength;
	private int yHeight;
	
	/**
	 * data structure for mapping state positions back to 
	 * its index in the 'states' array
	 */
	private HashMap<Pair, Integer> map;
	
	double[] probs = {0.8, 0.1, 0.1};
	
	public TwoDMDP(int xLength, 
				   int yHeight, 
				   Pair[] forbiddenPositions,
				   Pair[] goalPositions,
				   double[] goalRewards,
				   double normalReward,
				   boolean isGoalTerminatingState) {
		
		this.states = new TwoDMDPState[(xLength * yHeight) - forbiddenPositions.length];
		this.map = new HashMap<Pair, Integer>();
		
		this.xLength = xLength;
		this.yHeight = yHeight;
		
		int k = 0; // index into the states array
		
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yHeight; j++) {
				Pair position = new Pair(i+1, j+1);
				if (notForbidden(position, forbiddenPositions)){
					int pos = isGoalState(position, goalPositions);
					double reward = (pos >= 0) ? goalRewards[pos] : normalReward;
					this.states[k] = new TwoDMDPState(position, reward);
					k++;
					this.map.put(position, k);
				}
			}
		}
		
		this.setActions(forbiddenPositions, goalPositions, isGoalTerminatingState);
		
	}

	private void setActions(Pair[] forbiddenPositions, 
							Pair[] goalPositions, 
							boolean isGoalTerminatingState) {
		if (isGoalTerminatingState) {
			for (TwoDMDPState state : this.states) {
				if (isGoalState(state.getPosition(), goalPositions) >= 0) {
					state.setActions(new TwoDMDPAction[0]);
				} else {
					this.setActions(state, forbiddenPositions);
				}
			}
		} else {
			for (TwoDMDPState state : this.states) {
				this.setActions(state, forbiddenPositions);
			}
		}
		
	}

	private void setActions(TwoDMDPState state, Pair[] forbiddenPositions) {
		this.setUpAction(state, forbiddenPositions);
		this.setDownAction(state, forbiddenPositions);
		this.setRightAction(state, forbiddenPositions);
		this.setLeftAction(state, forbiddenPositions);		
	}

	private void setUpAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		int[] nextStateIds = new int[3];
		Pair pos = state.getPosition();
		
		nextStateIds[0] = getUpStateId(pos, forbiddenPositions);
		
		
	}

	private void setDownAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		// TODO Auto-generated method stub
		
	}

	private void setRightAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		// TODO Auto-generated method stub
		
	}

	private void setLeftAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		// TODO Auto-generated method stub
		
	}

	private int isGoalState(Pair position, Pair[] goalPositions) {
		for (int i = 0; i < goalPositions.length; i++) {
			if (goalPositions[i].equals(position)) {
				return i;
			}
		}
		return -1;
	}

	private boolean notForbidden(Pair position, Pair[] forbiddenPositions) {
		for (Pair forbidden : forbiddenPositions) {
			if (forbidden.equals(position)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int getNumStates() {
		return states.length;
	}

	@Override
	public State[] getStates() {
		return states;
	}


	public static void main(String[] args) {
		
	}

}
