package edu.asu.kaushik.ai.project1.valueiter;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

public class ValueIteration {
	/**
	 * Discount factor
	 */
	private double discountFactor;
	

	/**
	 * Implementation of main value iteration algorithm
	 * 
	 * @param mdp The MDP
	 * @param maxErr The maximum allowable error in the estimation of the state value
	 * @return The vector containing the calculated state values
	 */
	public double[] valueIteration(MDP mdp, double maxErr) {
		int numStates = mdp.getNumStates();
		
		// local variables
		double[] oldVal = new double[numStates];
		double[] val = new double[numStates];
		
		this.initValue(val);
		
		State[] states = mdp.getStates();
		double delta = 0;
		
		do {
			System.arraycopy(val, 0, oldVal, 0, val.length);
			delta = 0;
			for (int i = 0; i < numStates; i++) {
				val[i] = states[i].getReward();
				Action actions[] = states[i].getActions();
				double max = 0.0d;
				for (int j = 0; j < actions.length; j++) {
					double sum = 0.0d;
					double[] probs = actions[i].getProbs();
					int[] nextStateIds = actions[i].getNextStateIds();
					for (int k = 0; k < probs.length; k++) {
						sum = sum + (probs[k] * val[nextStateIds[k]]);
					}
					if (sum > max) {
						max = sum;
					}
				}
				val[i] = val[i] + this.discountFactor * max;
				
				double diff = Math.abs(val[i] - oldVal[i]);
				if ( diff > delta) {
					delta = diff;
				}
			}
		} while(delta >= this.getMaxError(maxErr));
		
		return val;
	}
	
	private double getMaxError(double maxErr) {
		return maxErr * (1 - this.discountFactor) / this.discountFactor;
	}
	
	private void initValue(double[] val) {
		for (int i = 0; i < val.length; i++) {
			val[i]	= 0.0d;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
