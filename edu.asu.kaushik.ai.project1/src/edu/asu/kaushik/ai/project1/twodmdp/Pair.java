package edu.asu.kaushik.ai.project1.twodmdp;

import java.util.HashMap;

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
		Pair[] pairs = new Pair[4];
		pairs[0] = new Pair(1,1);
		pairs[1] = new Pair(1,2);
		pairs[2] = new Pair(2,1);
		pairs[3] = new Pair(1,1);
		
		System.out.println("(1,2) == (2,1)? " + pairs[1].equals(pairs[2]));
		
		System.out.println("(1,1) == (1,1)? " + pairs[0].equals(pairs[3]));
		
		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
		
		for (int i = 0; i < 3; i++) {
			map.put(pairs[i], i);
		}
		
		System.out.println("Id of the pair (1,2) is " + map.get(new Pair(1,2)));

	}

}
