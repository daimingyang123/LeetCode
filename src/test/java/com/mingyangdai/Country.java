package com.mingyangdai;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author mingyang.dai
 * @since 2017/11/16
 */
public class Country implements Iterable<Country> {
	
	private int count;
	private String name;
	
	@Override
	public Iterator<Country> iterator() {
		return null;
	}
	
	@Override
	public void forEach(Consumer<? super Country> action) {
	
	}
	
	@Override
	public Spliterator<Country> spliterator() {
		return null;
	}
	
	public class Citizen{
		private int count;
		private String name;
		
		public void output(int count){
			count++;
			this.count++;
			Country.this.count++;
			System.out.println("output()方法中局部变量count为：" + count);
			System.out.println("内部类的成员变量count为：" + this.count);
			System.out.println("外部类的成员变量count为：" + Country.this.count);
		}
	}
	
	Citizen citizen = new Citizen();
	
	public void increase(int s){
		citizen.output(s);
	}
	
	
	public static void main(String[] args) {
		Country country = new Country();
		country.count = 5;
		country.increase(1);
		HashMap map = new HashMap();
		
	}
}



