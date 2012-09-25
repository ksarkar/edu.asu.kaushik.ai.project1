package edu.asu.kaushik.ai.project1.test;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.policyiteration.ModifiedPolicyIteration;
import edu.asu.kaushik.ai.project1.policyiteration.PolicyIteration;
import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;
import edu.asu.kaushik.ai.project1.valueiteration.ValueIteration;

/**
 * Test case for determining relative run times of the three algorithms. Large MDPs are solved
 * by the algorithms to see which one runs fastest.
 * 
 * @author Kaushik
 *
 */
public class SpeedTest {

		public static void TestValueIterationSpeed() {
			System.out.println("Testing spped of value iteration on big 20 X 20 MDP");
			
			// breadth of the world 
			int breadth = 20;
			
			// height of the world
			int height = 20;
			
			// Forbidden states
			Pair[] forbidden = {new Pair(2,2)};
			
			// Goal states
			Pair[] goals = {new Pair(100,100), new Pair(100,99)};
			
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
			
			System.out.println("Starting greedy policy evaluation...");
			startTime = System.currentTimeMillis();
			Action[] policy = valIter.greedyPolicy(mdp, values);
			System.out.println("Greedy policy evaluation Finished in "+
	                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
			
			//mdp.prettyPrint(values, policy, isGoalTerminatingState);
			
			System.out.println();
			
		}
		
		public static void TestPolicyIterationSpeed() {
			System.out.println("Testing spped of policy iteration on big 20 X 20 MDP");
			
			// breadth of the world 
			int breadth = 20;
			
			// height of the world
			int height = 20;
			
			// Forbidden states
			Pair[] forbidden = {new Pair(2,2)};
			
			// Goal states
			Pair[] goals = {new Pair(100,100), new Pair(100,99)};
			
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
			
			PolicyIteration policyIter = new PolicyIteration();
			
			double discountFactor = 0.9999;
			
			System.out.println("Starting policy iteration...");
			long startTime = System.currentTimeMillis();
			Action[] policy = policyIter.policyIteration(mdp, discountFactor);
			System.out.println("Policy Iteration Finished in "+
	                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
			
			//mdp.prettyPrint(null, policy, isGoalTerminatingState);
			
			System.out.println();
			
		}
		
		public static void TestModifiedPolicyIterationSpeed() {
			System.out.println("Testing spped of modified policy iteration on big 20 X 20 MDP");
			
			// breadth of the world 
			int breadth = 20;
			
			// height of the world
			int height = 20;
			
			// Forbidden states
			Pair[] forbidden = {new Pair(2,2)};
			
			// Goal states
			Pair[] goals = {new Pair(100,100), new Pair(100,99)};
			
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
			
			System.out.println("Starting modified policy iteration...");
			long startTime = System.currentTimeMillis();
			Action[] policy = policyIter.policyIteration(mdp, discountFactor);
			System.out.println("Policy Iteration Finished in "+
	                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
			
			//mdp.prettyPrint(null, policy, isGoalTerminatingState);
			
			System.out.println();
			
		}
		
	public static void main(String[] args) {
		TestValueIterationSpeed();
		TestModifiedPolicyIterationSpeed();
		TestPolicyIterationSpeed();

	}

}
