package edu.asu.kaushik.ai.project1.mdp;

/**
 * Generic interface for representing actions. All the core algorithms like value iteration and
 * policy iteration uses this class. Application specific action classes should implement this
 * interface.
 * 
 * @author Kaushik
 *
 */
public interface Action {
	public String getActionName();
	public double[] getProbs();
	public int[] getNextStateIds();

}
