package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2018/5/20
 */
public class Task2 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("start");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
