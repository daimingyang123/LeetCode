package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/8/14
 */
public class WaterandJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
		if (z > x+y) return false;
		
		return measure(x,y,z) || measure(y,x,z);
	}
	
	private boolean measure(int x, int y, int target) {
		while (x-y <= target) {
			if (x == target || x-y == target) return true;
			x += x;
		}
		return false;
	}
	
	public static void main(String[] args) {
		WaterandJugProblem problem = new WaterandJugProblem();
		int x = 3;
		int y = 5;
		int z = 4;
		boolean res = problem.canMeasureWater(x, y, z);
		System.out.println(res);
	}
}
