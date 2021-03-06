package edu.asu.kaushik.ai.project1.test;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;
import edu.asu.kaushik.ai.project1.valueiteration.ValueIteration;

/**
 * Tests the value iteration algorithm. All the five environments of figure 17.2 of Russel, Norvig book
 * is tested with identical results.
 * 
 * @author Kaushik
 *
 */
public class TestValueIteration {

	public static void TestFig17_1() {
		System.out.println("Figure 17.1 (a)");
		
		// breadth of the world 
		int breadth = 4;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = {new Pair(2,2)};
		
		// Goal states
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		
		// Rewards at the goal states
		double[] goalRewards = {1.0, -1.0};
		
		// Rewards at all other states
		double rewards = -0.04;
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.0001;
		double discountFactor = 0.9999;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void TestFig17_2b_left_upper() {
		System.out.println("Figure 17.2 (b) - left upper");
		
		// breadth of the world 
		int breadth = 4;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = {new Pair(2,2)};
		
		// Goal states
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		
		// Rewards at the goal states
		double[] goalRewards = {1.0, -1.0};
		
		// Rewards at all other states
		double rewards = -1.7;
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.0001;
		double discountFactor = 0.9999;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void TestFig17_2b_right_upper() {
		System.out.println("Figure 17.2(b) Right Upper");
		
		// breadth of the world 
		int breadth = 4;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = {new Pair(2,2)};
		
		// Goal states
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		
		// Rewards at the goal states
		double[] goalRewards = {1.0, -1.0};
		
		// Rewards at all other states
		double rewards = -0.3;
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.0001;
		double discountFactor = 0.9999;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void TestFig17_2b_left_lower() {
		System.out.println("Figure 17.2(b) Left Lower");
		
		// breadth of the world 
		int breadth = 4;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = {new Pair(2,2)};
		
		// Goal states
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		
		// Rewards at the goal states
		double[] goalRewards = {1.0, -1.0};
		
		// Rewards at all other states
		double rewards = -0.01;
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.0001;
		double discountFactor = 0.9999;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		double[] values = valIter.valueIteration(mdp, maxErr, discountFactor);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		Action[] policy = valIter.greedyPolicy(mdp, values);
		
		mdp.prettyPrint(values, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}
	
	public static void TestFig17_2b_right_lower() {
		System.out.println("Figure 17.2(b) Right Lower");
		
		// breadth of the world 
		int breadth = 4;
		
		// height of the world
		int height = 3;
		
		// Forbidden states
		Pair[] forbidden = {new Pair(2,2)};
		
		// Goal states
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		
		// Rewards at the goal states
		double[] goalRewards = {1.0, -1.0};
		
		// Rewards at all other states
		double rewards = 0.1;
		
		boolean isGoalTerminatingState = true;
		
		TwoDMDP mdp = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		ValueIteration valIter = new ValueIteration();
		
		double maxErr = 0.0001;
		double discountFactor = 0.9999;
		
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
		TestValueIteration.TestFig17_1();
		
		TestValueIteration.TestFig17_2b_left_upper();
		TestValueIteration.TestFig17_2b_right_upper();
		TestValueIteration.TestFig17_2b_left_lower();
		TestValueIteration.TestFig17_2b_right_lower();
	}

}
