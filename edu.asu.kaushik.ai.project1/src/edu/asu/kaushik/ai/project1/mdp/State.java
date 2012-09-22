package edu.asu.kaushik.ai.project1.mdp;

public interface State {
	public double getReward();
	public Action[] getActions();

}
