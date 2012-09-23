package edu.asu.kaushik.ai.project1.twodmdp;

import edu.asu.kaushik.ai.project1.mdp.Action;

/**
 * Implementation of the generic action interface for supporting worlds of Russel Norvig book.
 * 
 * @author Kaushik
 *
 */

public class TwoDMDPAction implements Action {
	private String actionName;
	private double[] probs;
	private int[] nextStates;

	public TwoDMDPAction(String actionName, double[] probs, int[] nextStates) {
		super();
		this.actionName = actionName;
		this.probs = probs;
		this.nextStates = nextStates;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

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
