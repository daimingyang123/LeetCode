package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/5/6
 */
public class BitProblems {
	
	public static void main(String[] args) {
		BitProblems problems = new BitProblems();
		int num = 1;
		int result = problems.reverseBits2(num);
		System.out.println(result);
	}
	
	public int findComplement(int num) {
		int first = Integer.highestOneBit(num);
		String binary = Integer.toBinaryString(first - 1);
		return num ^ (first - 1);
	}
	
	public int reverseBits(int n) {
		String binary = Integer.toBinaryString(n);
		String reverse = reverse(binary);
		Double result = 0D;
		for (int i = reverse.length() - 1; i >= 0; i--) {
			if (reverse.charAt(i) == '1') {
				result += Math.pow(2, 31 - i);
			}
		}
		return result.intValue();
	}
	
	private String reverse(String binary) {
		StringBuilder builder = new StringBuilder(binary);
		while (builder.length() < 32) {
			builder.insert(0, "0");
		}
		return builder.reverse().toString();
	}
	
	public int reverseBits2(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1;   // CATCH: must do unsigned shift
			if (i < 31) // CATCH: for last digit, don't shift!
				result <<= 1;
		}
		return result;
	}
}
