package com.mingyangdai;

import java.util.HashMap;

public class Person {
	String name;
	
	public Person(String personName) {
		name = personName;
	}
	
	public static void main(String[] args) {
		Person person = new Person("hehe");
		int[] nums = {1, 2, 3, 4, 5, 6, 1};
		int k = 5;
		boolean result = person.containsNearbyDuplicate(nums, k);
		System.out.println(result);
	}
	
	public String greet(String yourName) {
		return String.format("Hi %s, my name is %s", name, yourName);
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) < k) {
				return true;
			}
			map.put(nums[i], i);
		}
		
		return false;
	}
}
