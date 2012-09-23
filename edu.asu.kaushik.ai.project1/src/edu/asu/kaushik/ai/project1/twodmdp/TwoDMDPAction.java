package edu.asu.kaushik.ai.project1.twodmdp;

import edu.asu.kaushik.ai.project1.mdp.Action;

public class TwoDMDPAction implements Action {
	private String actionName;
	private double[] probs;
	private int[] nextStates;

	@Override
	public double[] getProbs() {
		return probs;
	}

	@Override
	public int[] getNextStateIds() {
		return nextStates;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
