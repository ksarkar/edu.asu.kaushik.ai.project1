package edu.asu.kaushik.ai.project1.policyiteration;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.State;

/**
 * Core implementation of modified policy iteration. 
 * Uses abstract interfaces for MDP, states and actions
 * 
 * @author Kaushik
 *
 */
public class ModifiedPolicyIteration extends PolicyIteration {

	@Override
	protected double[] policyEvaluation(Action[] policy, State[] states, double[] oldVal, double discountFactor) {
		int numStates = policy.length;
		double[] val = new double[numStates];
		
		double delta = 0.0000d;
		do {
			System.arraycopy(val, 0, oldVal, 0, val.length);
			delta = 0.000d;
			for (int i = 0; i < numStates; i++) {
				val[i] = states[i].getReward() + discountFactor * super.valueOfAction(policy[i], oldVal);
				
				double diff = Math.abs(val[i] - oldVal[i]);
				if ( diff > delta) {
					delta = diff;
				}
			}
		} while (delta > 0.001d);
		
		return val;
	}
	
}
