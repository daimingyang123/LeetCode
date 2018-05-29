package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2018/5/20
 */
public class Task implements Runnable {
	
	@Override
	public void run() {
		Country country = new Country();
		System.out.println(country);
	}
}
