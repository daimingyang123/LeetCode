package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/3/4
 */
public class RectangleArea {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total = (C-A) * (D-B) + (G-E) * (H-F);
		
		long left = Math.max(A, E);
		long right = Math.min(C, G);
		long length = right - left;
		if (length < 0L) return total;
		
		long high = Math.min(D, H);
		long low = Math.max(B, F);
		long width = high - low;
		if (width < 0) return total;
		
		int repeat = (int) (length * width);
		return total - repeat;
	}
	
	public static void main(String[] args) {
		int res = new RectangleArea().computeArea
				(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
		System.out.println(res);
	}
}
