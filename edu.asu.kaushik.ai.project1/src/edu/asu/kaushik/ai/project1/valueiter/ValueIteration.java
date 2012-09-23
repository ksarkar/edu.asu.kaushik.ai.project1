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
	public double[] valueIteration(MDP mdp, double maxErr, double discountFactor) {
		this.discountFactor = discountFactor;
		
		int numStates = mdp.getNumStates();
		
		// local variables
		double[] oldVal = new double[numStates];
		double[] val = new double[numStates];
		
		for (int i = 0; i < val.length; i++) {
			val[i] = 0.0d;
		}
		
		State[] states = mdp.getStates();
		double delta = 0;
		
		do {
			System.arraycopy(val, 0, oldVal, 0, val.length);
			delta = 0;
			for (int i = 0; i < numStates; i++) {
				Action actions[] = states[i].getActions();
				double max = Double.NEGATIVE_INFINITY;
				for (int j = 0; j < actions.length; j++) {
					double sum = 0.0d;
					double[] probs = actions[j].getProbs();
					int[] nextStateIds = actions[j].getNextStateIds();
					for (int k = 0; k < probs.length; k++) {
						sum = sum + (probs[k] * val[nextStateIds[k]]);
					}
					if (sum > max) {
						max = sum;
					}
				}
				max = Double.isInfinite(max)? 0 : max;
				val[i] = states[i].getReward() + this.discountFactor * max;
				
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
	
	public Action[] greedyPolicy(MDP mdp, double[] values) {
		State[] states = mdp.getStates();
		Action[] policy = new Action[states.length];
		
		for (int i = 0; i < states.length; i++) {
			Action actions[] = states[i].getActions();
			double max = Double.NEGATIVE_INFINITY;
			policy[i] = null;
			for (int j = 0; j < actions.length; j++) {
				double sum = 0.0d;
				double[] probs = actions[j].getProbs();
				int[] nextStateIds = actions[j].getNextStateIds();
				for (int k = 0; k < probs.length; k++) {
					sum = sum + (probs[k] * values[nextStateIds[k]]);
				}
				if (sum > max) {
					max = sum;
					policy[i] = actions[j];
				}
			}
		}
		return policy;
	}
	
	public static void main(String[] args) {
		
	}
}
