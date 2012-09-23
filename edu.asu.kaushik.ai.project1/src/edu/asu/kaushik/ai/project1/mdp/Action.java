package edu.asu.kaushik.ai.project1.mdp;

public interface Action {
	public String getActionName();
	public double[] getProbs();
	public int[] getNextStateIds();

}
