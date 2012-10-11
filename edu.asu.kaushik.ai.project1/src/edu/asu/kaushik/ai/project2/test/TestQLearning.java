package edu.asu.kaushik.ai.project2.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.twodmdp.Pair;
import edu.asu.kaushik.ai.project1.twodmdp.TwoDMDP;
import edu.asu.kaushik.ai.project2.qlearning.QLearning;

public class TestQLearning {

	public static void main(String[] args) throws Exception {
		// prepare the world
		int breadth = 4;
		int height = 3;
		Pair[] forbidden = {new Pair(2,2)};
		Pair[] goals = {new Pair(4,3), new Pair(4,2)};
		double[] goalRewards = {1.0, -1.0};
		double rewards = -0.04;
		boolean isGoalTerminatingState = true;
		
		TwoDMDP world = new TwoDMDP(breadth, // breadth of the world
							      height, // height of the world
							      forbidden, // forbidden states
							      goals, // goal states
							      goalRewards, // rewards at the goal states
							      rewards, // rewards at all other states
							      isGoalTerminatingState); // goal states are terminating states
		
		String[] actionNames = {"Up", "Down", "Right", "Left"};
		double discFac = 0.9999;
		long randSeed = 1234L;
		int numTrials = 10;
		
		QLearning q = new QLearning(world, actionNames, discFac, randSeed);
		
		long startTime = System.currentTimeMillis();
		q.run(numTrials);
		System.out.println("Q Learning Finished in "+
                (System.currentTimeMillis() - startTime)/1000.0 + " seconds");
		
		double[] values = q.getValues();
		Action[] policy = q.getPolicy();
		
		world.prettyPrint(values, policy, isGoalTerminatingState);
		
		double data[][] = q.getData();
		
		//outputData("./data/qlearning/5000_new_fun_runs.csv", data, numTrials, world.getNumStates());

	}

	private static void outputData(String filename, double[][] data, int numTrials, int numStates) throws FileNotFoundException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(filename);
			for (int i = 0; i < numTrials; i++) {
				for (int j = 0; j < numStates; j++){
					out.print(data[i][j] + ",");
				}
				out.println();
			}
			
		} finally {
			if (out != null) {
				out.close();
			}
		}
		
	}

}
