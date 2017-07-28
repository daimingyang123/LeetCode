package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/7/26
 */
public class CountPrimes {
	public int countPrimes(int n) {
		byte[] array = new byte[n];
		
		for (int i=2; i<=n/2; i++) {
			if (array[0] == 1) continue;
			int tmp = i;
			while (i*tmp > 0 && i*tmp < n) {
				array[i*tmp] = 1;
				tmp++;
			}
		}
		
		int count = 0;
		for (int i=2; i<n; i++) {
			if (array[i] == 0) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		CountPrimes primes = new CountPrimes();
		int n = 5;
		int res = primes.countPrimes(n);
		System.out.println(res);
	}
}
