package com.mingyangdai;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public void test() {
	
	}
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[]{228,189,160,229,165,189,13,10};
		for (int i : array) {
			System.out.println(Integer.toBinaryString(i));
		}
	}
}
