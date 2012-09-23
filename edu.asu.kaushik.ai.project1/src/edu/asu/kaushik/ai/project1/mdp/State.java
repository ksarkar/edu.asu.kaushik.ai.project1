package edu.asu.kaushik.ai.project1.mdp;

/**
 * Generic interface for representing states. All the core algorithms like value iteration and
 * policy iteration uses this class. Application specific state classes should implement this
 * interface.
 * 
 * @author Kaushik
 *
 */
public interface State {
	public double getReward();
	public Action[] getActions();

}
