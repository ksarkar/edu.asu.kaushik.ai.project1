package edu.asu.kaushik.ai.project1.policyiteration;

import Jama.Matrix;
import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.MDP;
import edu.asu.kaushik.ai.project1.mdp.State;

public class PolicyIteration {

	public Action[] policyIteration(MDP mdp, double discountFactor) {
		
		int numStates = mdp.getNumStates();
		
		double[] val = new double[numStates];
		for (int i = 0; i < val.length; i++) {
			val[i] = 0.0d;
		}
		
		State[] states = mdp.getStates();
		
		Action[] policy = setRandomPolicy(states);
		
		boolean isUnchanged = true;
		do  {
			val = policyEvaluation(policy, states, discountFactor);
			
			isUnchanged = true;
			for (int i = 0; i < numStates; i++){
				Action optAction = optimumAction(states[i], val);
				double max = valueOfAction(optAction, val);
				double currentPolicyVal = valueOfAction(policy[i], val);
				if (max > currentPolicyVal) {
					policy[i] = optAction;
					isUnchanged = false;
				}				
			}		
		}while(!isUnchanged);
		
		return policy;
	}
	
	private Action[] setRandomPolicy(State[] states) {
		int numStates = states.length;
		Action[] policy = new Action[numStates];
		for (int i = 0; i < numStates; i++) {
			Action[] actions = states[i].getActions();
			if (actions.length == 0) { // terminating goal states
				policy[i] = null;
			} else {
				policy[i] = states[i].getActions()[0];
			}
		}
		return policy;
	}

	private double valueOfAction(Action action, double[] val) {
		double value = 0.0000d;
		if (action == null) {
			return value;
		} else {
			double[] probs = action.getProbs();
			int[] nextStateIds = action.getNextStateIds();
			for (int i = 0; i < probs.length; i++) {
				value = value + (probs[i] * val[nextStateIds[i]]);
			}
			return value;
		}
	}

	
	private Action optimumAction(State state, double[] val) {
		Action actions[] = state.getActions();
		double max = Double.NEGATIVE_INFINITY;
		Action optAction = null;
		for (int j = 0; j < actions.length; j++) {
			double actionValue = valueOfAction(actions[j], val);
			if (actionValue > max) {
				max = actionValue;
				optAction = actions[j];
			}
		}
		return Double.isInfinite(max)? null : optAction;
	}

	protected double[] policyEvaluation(Action[] policy, State[] states, double discountFactor) {
		int numStates = policy.length;
		double coeffs[][] = initCoeffMatrix(numStates);
		
		/**
		 * The equations are of the form:
		 * V_i = R_i + \gamma \times \sum_j P(j|s,\pi_i) \times V_j 
		 * or
		 * V_i - \gamma \times \sum_j P(j|s,\pi_i) \times V_j = R_i
		 */
		 
		// prepare the coefficient matrix of the above set of equations
		for (int i = 0; i < numStates; i++) {
			// first term
			coeffs[i][i] = coeffs[i][i] + 1.0000d;
			
			// other terms
			if (policy[i] != null) {
				double[] probs = policy[i].getProbs();
				int[] nextStates = policy[i].getNextStateIds();
				for (int j = 0; j < probs.length; j++) {
					coeffs[i][nextStates[j]] = coeffs[i][nextStates[j]] - (discountFactor * probs[j]);
				}
			}
		}
		
		// prepare the vector of constants
		double[] r = new double[numStates];
		for (int i = 0; i < numStates; i++){
			r[i] = states[i].getReward();
		}
		
		// solve the set of linear equations using the JAMA package
		Matrix A = new Matrix(coeffs);
		Matrix R = new Matrix(r, numStates);
		Matrix X = A.solve(R);
		
		double[][] x = X.getArray();
		double[] val = new double[numStates];
		
		for (int i = 0; i < numStates; i++){
			val[i] = x[i][0];
		}
		
		return val;
	}

	private double[][] initCoeffMatrix(int numStates) {
		double coeffs[][] = new double[numStates][numStates];
		for (int i = 0; i < numStates; i++){
			for (int j = 0; j < numStates; j++){
				coeffs[i][j] = 0.0000d;
			}
		}
		return coeffs;
	}

	public static void main(String[] args) {

	}

}
