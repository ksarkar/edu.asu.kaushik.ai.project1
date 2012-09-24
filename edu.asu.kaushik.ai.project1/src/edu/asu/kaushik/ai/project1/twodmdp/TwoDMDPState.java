package edu.asu.kaushik.ai.project1.twodmdp;

import edu.asu.kaushik.ai.project1.mdp.Action;
import edu.asu.kaushik.ai.project1.mdp.State;

/**
 * Implementation of the generic MDP state for supporting two dimensional spatical MDPs of Russel, Norvig Book.
 * @author Kaushik
 *
 */
public class TwoDMDPState implements State {

	private Pair position;
	private double reward;
	private TwoDMDPAction[] actions;
	
	public TwoDMDPState() {
		super();
	}

	public TwoDMDPState(Pair position, double reward) {
		super();
		this.position = position;
		this.reward = reward;
	}

	public void setActions(TwoDMDPAction[] actions) {
		this.actions = actions;
	}

	public Pair getPosition() {
		return position;
	}

	public void setPosition(Pair position) {
		this.position = position;
	}

	@Override
	public double getReward() {
		return this.reward;
	}

	@Override
	public Action[] getActions() {
		return actions;
	}

}
