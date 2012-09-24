package edu.asu.kaushik.ai.project1.test;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;
import edu.asu.kaushik.ai.project1.valueiteration.ValueIteration;

/**
 * Implementatin for solving the problem 17.8 of the R&N book.
 * @author Kaushik
 *
 */
public class Problem_17_8 {

	public static void problem_17_8_a() {
		System.out.println("Problem 17.8 (a): r = 100");
		double r = 100.00;
		
		// breadth of the world 
		int breadth = 3;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = null;
		
		// Goal states
		Pair[] goals = {new Pair(3,3)};
		
		// Rewards at the goal states
		double[] goalRewards = {10.00};
		
		// Rewards at all other states
		double rewards = -1.00;
		
		Pair[] specialStates = {new Pair(1,3)};
		double specialRewards[] = {r};
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      specialStates,
							      specialRewards,
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.001;
		double discountFactor = 0.99;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void problem_17_8_b() {
		System.out.println("Problem 17.8 (b): r = -3");
		double r = -3.00;
		
		// breadth of the world 
		int breadth = 3;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = null;
		
		// Goal states
		Pair[] goals = {new Pair(3,3)};
		
		// Rewards at the goal states
		double[] goalRewards = {10.00};
		
		// Rewards at all other states
		double rewards = -1.00;
		
		Pair[] specialStates = {new Pair(1,3)};
		double specialRewards[] = {r};
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      specialStates,
							      specialRewards,
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.001;
		double discountFactor = 0.99;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void problem_17_8_c() {
		System.out.println("Problem 17.8 (c): r = 0");
		double r = 0.00;
		
		// breadth of the world 
		int breadth = 3;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = null;
		
		// Goal states
		Pair[] goals = {new Pair(3,3)};
		
		// Rewards at the goal states
		double[] goalRewards = {10.00};
		
		// Rewards at all other states
		double rewards = -1.00;
		
		Pair[] specialStates = {new Pair(1,3)};
		double specialRewards[] = {r};
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      specialStates,
							      specialRewards,
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.001;
		double discountFactor = 0.99;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void problem_17_8_d() {
		System.out.println("Problem 17.8 (d): r = 3.00");
		double r = 3.00;
		
		// breadth of the world 
		int breadth = 3;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = null;
		
		// Goal states
		Pair[] goals = {new Pair(3,3)};
		
		// Rewards at the goal states
		double[] goalRewards = {10.00};
		
		// Rewards at all other states
		double rewards = -1.00;
		
		Pair[] specialStates = {new Pair(1,3)};
		double specialRewards[] = {r};
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      specialStates,
							      specialRewards,
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.001;
		double discountFactor = 0.99;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		problem_17_8_a();
		problem_17_8_b();
		problem_17_8_c();
		problem_17_8_d();

	}

}
