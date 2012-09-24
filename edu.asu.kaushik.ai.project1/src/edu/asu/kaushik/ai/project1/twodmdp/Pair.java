package edu.asu.kaushik.ai.project1.twodmdp;

/**
 * Data structure for holding position coordinates of the states of the MDP.
 * 
 * @author Kaushik
 *
 */
public class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) {
			return false;
		}
		
		Pair other = (Pair)o;
		
		return this.x == other.x && this.y == other.y;
	}
	
	@Override
	public int hashCode() {
		return new Double(this.x).hashCode() ^ new Double(this.y).hashCode();
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
