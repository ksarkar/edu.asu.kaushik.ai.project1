package edu.asu.kaushik.ai.project1.mdp;

/**
 * Generic interface for representing MDPs. All the core algorithms like value iteration and
 * policy iteration uses this class. Application specific MDP classes should implement this
 * interface.
 * 
 * @author Kaushik
 *
 */
public interface MDP {
	public int getNumStates();
	public State[] getStates();
	public State getStartState();
	public boolean isTerminalState(State s);
}
