package edu.asu.kaushik.ai.project1.twodmdp;

import java.util.HashMap;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

/**
 * Implementation of the generic MDP interface for Fig 17.1 of R&N book type of worlds.
 * 
 * @author Kaushik
 *
 */
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
	 * Forbidden positions
	 */
	Pair[] forbiddenPositions;
	
	/**
	 * goal positions
	 */
	Pair[] goalPositions;
	
	/**
	 * data structure for mapping state positions back to 
	 * its index in the 'states' array
	 */
	private HashMap<Pair, Integer> map;
	
	private double[] probs = {0.8, 0.1, 0.1};
	
	
	/**
	 * The main constructor for creating two dimensional spatial MDPs. Every state has four fixed 
	 * actions available to it - Up, Down, Right, Left. For each action, with 0.8 prob the agent 
	 * goes in the desired direction, and with prob 0.1, goes in either of the perpendicular directions
	 * of of the desired direction.
	 * 
	 * @param xLength The breadth of the two dimensional world
	 * @param yHeight The height of the two dimensional world
	 * @param forbiddenPositions The array of forbidden positions
	 * @param goalPositions The array of goal positions
	 * @param goalRewards The reward of the goal position; should be in the same order as goalPositions
	 * @param normalReward The reward for all other positions
	 * @param isGoalTerminatingState If set true then the goal positions are the terminating positions, otherwise
	 * the goal positions also have all the four actions available to them
	 */
	public TwoDMDP(int xLength, 
				   int yHeight, 
				   Pair[] forbiddenPositions,
				   Pair[] goalPositions,
				   double[] goalRewards,
				   double normalReward,
				   boolean isGoalTerminatingState) {
		
		
		this.states = new TwoDMDPState[(xLength * yHeight) 
		                               - ((forbiddenPositions == null) ? 
		                            		   0 : forbiddenPositions.length)];
		this.map = new HashMap<Pair, Integer>();
		
		this.xLength = xLength;
		this.yHeight = yHeight;
		this.forbiddenPositions = forbiddenPositions;
		this.goalPositions = goalPositions;
		
		int k = 0; // index into the states array
		
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yHeight; j++) {
				Pair position = new Pair(i+1, j+1);
				if (notForbidden(position, forbiddenPositions)){
					int pos = isGoalState(position, goalPositions);
					double reward = (pos >= 0) ? goalRewards[pos] : normalReward;
					this.states[k] = new TwoDMDPState(position, reward);
					this.map.put(position, k);
					k++;
				}
			}
		}
		
		this.setActions(forbiddenPositions, goalPositions, isGoalTerminatingState);
		
	}
	
	/**
	 * Little bit more general constructor than the previous one. It allows one to set the rewards
	 * of few special states different from the normal reward. Can handle the MDPs of problem
	 * 17.8 of R&N book.
	 * 
	 * @param xLength The breadth of the two dimensional world
	 * @param yHeight The height of the two dimensional world
	 * @param forbiddenPositions The array of forbidden positions
	 * @param goalPositions The array of goal positions
	 * @param goalRewards The reward of the goal position; should be in the same order as goalPositions
	 * @param normalReward The reward for all other positions
	 * @param specialStates The states with special reward
	 * @param specialRewards The special rewards; should be in the same order as the special states
	 * @param isGoalTerminatingState If set true then the goal positions are the terminating positions, otherwise
	 * the goal positions also have all the four actions available to them
	 */
	public TwoDMDP(int xLength, 
			   int yHeight, 
			   Pair[] forbiddenPositions,
			   Pair[] goalPositions,
			   double[] goalRewards,
			   double normalReward,
			   Pair[] specialStates,
			   double[] specialRewards,
			   boolean isGoalTerminatingState) {
	
		// Call the normal constructor for setting other parameters.
		this(xLength, 
			 yHeight, 
			 forbiddenPositions, 
			 goalPositions, 
			 goalRewards, 
			 normalReward, 
			 isGoalTerminatingState);
		
		for (int i = 0; i < specialStates.length; i++) {
			states[this.map.get(specialStates[i])].setReward(specialRewards[i]);
		}

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
		TwoDMDPAction[] actions = new TwoDMDPAction[4];
		
		actions[0] = this.setUpAction(state, forbiddenPositions);
		actions[1] = this.setDownAction(state, forbiddenPositions);
		actions[2] = this.setRightAction(state, forbiddenPositions);
		actions[3] = this.setLeftAction(state, forbiddenPositions);		
		
		state.setActions(actions);
	}

	private TwoDMDPAction setUpAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		int[] nextStateIds = new int[3];
		Pair pos = state.getPosition();
		
		nextStateIds[0] = getUpStateId(pos, forbiddenPositions);
		nextStateIds[1]	= getRightStateId(pos, forbiddenPositions);
		nextStateIds[2]	= getLeftStateId(pos, forbiddenPositions);
		
		return new TwoDMDPAction("Up", this.probs, nextStateIds);
	}

	private TwoDMDPAction setDownAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		int[] nextStateIds = new int[3];
		Pair pos = state.getPosition();
		
		nextStateIds[0] = getDownStateId(pos, forbiddenPositions);
		nextStateIds[1]	= getRightStateId(pos, forbiddenPositions);
		nextStateIds[2]	= getLeftStateId(pos, forbiddenPositions);
		
		return new TwoDMDPAction("Down", this.probs, nextStateIds);
	}

	private TwoDMDPAction setRightAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		int[] nextStateIds = new int[3];
		Pair pos = state.getPosition();
		
		nextStateIds[0] = getRightStateId(pos, forbiddenPositions);
		nextStateIds[1]	= getUpStateId(pos, forbiddenPositions);
		nextStateIds[2]	= getDownStateId(pos, forbiddenPositions);
		
		return new TwoDMDPAction("Right", this.probs, nextStateIds);
	}

	private TwoDMDPAction setLeftAction(TwoDMDPState state, Pair[] forbiddenPositions) {
		int[] nextStateIds = new int[3];
		Pair pos = state.getPosition();
		
		nextStateIds[0] = getLeftStateId(pos, forbiddenPositions);
		nextStateIds[1]	= getUpStateId(pos, forbiddenPositions);
		nextStateIds[2]	= getDownStateId(pos, forbiddenPositions);
		
		return new TwoDMDPAction("Left", this.probs, nextStateIds);
	}


	private int getUpStateId(Pair pos, Pair[] forbiddenPositions) {
		int x = pos.getX();
		int y = pos.getY() + 1;
		
		Pair newPos = new Pair(x, y);
		Pair nextPos = (notForbidden(newPos, forbiddenPositions) && (y <= this.yHeight)) ? newPos : pos;
		
		return this.map.get(nextPos);
	}

	private int getDownStateId(Pair pos, Pair[] forbiddenPositions) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		
		Pair newPos = new Pair(x, y);
		Pair nextPos = (notForbidden(newPos, forbiddenPositions) && (y >= 1)) ? newPos : pos;
		
		return this.map.get(nextPos);
	}

	private int getRightStateId(Pair pos, Pair[] forbiddenPositions) {
		int x = pos.getX() + 1;
		int y = pos.getY();
		
		Pair newPos = new Pair(x, y);
		Pair nextPos = (notForbidden(newPos, forbiddenPositions) && (x <= this.xLength)) ? newPos : pos;
		
		return this.map.get(nextPos);
	}

	private int getLeftStateId(Pair pos, Pair[] forbiddenPositions) {
		int x = pos.getX() - 1;
		int y = pos.getY();
		
		Pair newPos = new Pair(x, y);
		Pair nextPos = (notForbidden(newPos, forbiddenPositions) && (x >= 1)) ? newPos : pos;
		
		return this.map.get(nextPos);
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
		if (forbiddenPositions == null) {
			return true;
		}
		for (Pair forbidden : forbiddenPositions) {
			if (forbidden.equals(position)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Utility method for pretty printing the output of the value iteration algorithm
	 * 
	 * @param values Values of each position of the two dimensional world; obtained form value iteration algorithm
	 * @param policy Optimum policy by running greedy policy on the values obtained by value iteration
	 * @param isGoalTerminatingState Whether goal states are terminating or not
	 */
	public void prettyPrint(double[] values, Action[] policy, boolean isGoalTerminatingState) {
		System.out.println("Pretty printing the policy...");
		
		if (isGoalTerminatingState) {
			for (int j = this.yHeight; j >= 1; j--) {
				for (int i = 1; i <= this.xLength; i++) {
					Pair position = new Pair(i,j);
					if (!notForbidden(position, forbiddenPositions)) {
						// for better alignment :-)
						if (values == null)
							System.out.print("illegal\t");
						else
							System.out.print("forbidden\t");
					}
					else {
						int index = this.map.get(position);
						if (values != null) {
							System.out.print(String.format("%.3f", values[index]) + ",");
						}
						if (this.isGoalState(position, goalPositions) >= 0) {
							System.out.print("goal\t");
						} else {
							System.out.print(policy[index].getActionName() + "\t");
						}
					}
				}
				System.out.println();
			}
			
		} else {
			for (int j = this.yHeight; j >= 1; j--) {
				for (int i = 1; i <= this.xLength; i++) {
					Pair position = new Pair(i,j);
					if (!notForbidden(position, forbiddenPositions)) {
						// for better alignment :-)
						if (values == null)
							System.out.print("illegal\t");
						else
							System.out.print("forbidden\t");
					}
					else {
						int index = this.map.get(position);
						if (values != null) {
							System.out.print(String.format("%.3f", values[index]) + ",");
						}
						System.out.print(policy[index].getActionName() + "\t");
					}
				}
				System.out.println();
			}
			
		}
	}

	@Override
	public int getNumStates() {
		return states.length;
	}

	@Override
	public State[] getStates() {
		return states;
	}

}
