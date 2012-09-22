package edu.asu.kaushik.ai.project1.mdp;

public interface Action {
	public double[] getProbs();
	public int[] getNextStateIds();

}
