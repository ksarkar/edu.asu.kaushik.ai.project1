package edu.asu.kaushik.ai.project1.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;
import edu.asu.kaushik.ai.project1.valueiteration.ValueIteration;

/**
 * Experiment to find out how value of a state evolve during the execution of the 
 * value iteration algorithm, and does the maximum allowable error limit has any 
 * impact on this evolution.
 * 
 * @author Kaushik
 *
 */
public class StateValueChangeMonitor {

	public static void MonitorStateValueChange(int stateId, double maxErr, String filename) throws FileNotFoundException {
		System.out.println("Monitoring the change of value of the state " + stateId );
		
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
		
		double discountFactor = 0.9999;
		
		System.out.println("Starting value iteration...");
		long startTime = System.currentTimeMillis();
		Double[] stateValues = valIter.valueIterationExp(mdp, maxErr, discountFactor, stateId);
		System.out.println("Value Iteration Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(filename);
			boolean first = true;
			for (int i = 0; i < stateValues.length; i++) {
				if (!first) {
					out.println(",");
				}
				out.print(stateValues[i]);
				first = false;
			}
			
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		String dir = "./data/";
		
		// for the state (1,1)
		MonitorStateValueChange(0, 0.01, dir + "valueChange_1_1_0.01.csv");
		MonitorStateValueChange(0, 0.001, dir + "valueChange_1_1_0.001.csv");
		MonitorStateValueChange(0, 0.0001, dir + "valueChange_1_1_0.0001.csv");
		
		// for the state (3,1)
		MonitorStateValueChange(5, 0.1, dir + "valueChange_3_1_0.1.csv");
		MonitorStateValueChange(5, 0.001, dir + "valueChange_3_1_0.001.csv");
		MonitorStateValueChange(5, 0.0001, dir + "valueChange_3_1_0.0001.csv");
		

	}

}
