package edu.asu.kaushik.ai.project1.test;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.policyiteration.ModifiedPolicyIteration;
import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;

public class TestModifiedPolicyIteration {

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
		
		ModifiedPolicyIteration policyIter = new ModifiedPolicyIteration();
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting policy iteration...");
		long startTime = System.currentTimeMillis();
		Action[] policy = policyIter.policyIteration(mdp, discountFactor);
		System.out.println("Policy Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		mdp.prettyPrint(null, policy, isGoalTerminatingState);
		
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
		
		ModifiedPolicyIteration policyIter = new ModifiedPolicyIteration();
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting policy iteration...");
		long startTime = System.currentTimeMillis();
		Action[] policy = policyIter.policyIteration(mdp, discountFactor);
		System.out.println("Policy Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		mdp.prettyPrint(null, policy, isGoalTerminatingState);
		
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
		
		ModifiedPolicyIteration policyIter = new ModifiedPolicyIteration();
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting policy iteration...");
		long startTime = System.currentTimeMillis();
		Action[] policy = policyIter.policyIteration(mdp, discountFactor);
		System.out.println("Policy Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		mdp.prettyPrint(null, policy, isGoalTerminatingState);
		
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
		
		ModifiedPolicyIteration policyIter = new ModifiedPolicyIteration();
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting policy iteration...");
		long startTime = System.currentTimeMillis();
		Action[] policy = policyIter.policyIteration(mdp, discountFactor);
		System.out.println("Policy Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		mdp.prettyPrint(null, policy, isGoalTerminatingState);
		
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
		
		ModifiedPolicyIteration policyIter = new ModifiedPolicyIteration();
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting policy iteration...");
		long startTime = System.currentTimeMillis();
		Action[] policy = policyIter.policyIteration(mdp, discountFactor);
		System.out.println("Policy Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		mdp.prettyPrint(null, policy, isGoalTerminatingState);
		
		System.out.println();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestModifiedPolicyIteration.TestFig17_1();
		
		TestModifiedPolicyIteration.TestFig17_2b_left_upper();
		TestModifiedPolicyIteration.TestFig17_2b_right_upper();
		TestModifiedPolicyIteration.TestFig17_2b_left_lower();
		TestModifiedPolicyIteration.TestFig17_2b_right_lower();

	}

}
