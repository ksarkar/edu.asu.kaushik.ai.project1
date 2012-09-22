package edu.asu.kaushik.ai.project1.valueiter;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

public class ValueIteration {
	/**
	 * Discount factor
	 */
	private double discountFactor;
	

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
				double sum = 0.0d;
				for (int j = 0; j < actions.length; j++) {
					sum = 0.0d;
					double[] probs = actions[i].getProbs();
					int[] newStateIds = actions[i].getNextStateIds();
					for (int k = 0; k < probs.length; k++) {
						
					}
				}
			}
		} while(false);
		
		return val;
	}
	private void initValue(double[] val) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		System.out.println("This is the class for value iteration.");
		int[] a = {1,2,3,4,5};
		int[] b = new int[5];
		System.arraycopy(a, 0, b, 0, a.length);
		
		b[4] = 0;
		for (int i : a) {
			System.out.println(i + "\t");
		}
		
		System.out.println();
		for (int i : b) {
			System.out.println(i + "\t");
		}

	}

}
