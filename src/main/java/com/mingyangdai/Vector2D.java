package com.mingyangdai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/6/20
 */
public class Vector2D implements Iterator<Integer> {
	
	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;
	
	public Vector2D(List<List<Integer>> vec2d) {
		i = vec2d.iterator();
	}
	
	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		
		List<Integer> list1 = new ArrayList<Integer>();
//		list1.add(1);
//		list1.add(2);
		
		List<Integer> list2 = new ArrayList<Integer>();
//		list2.add(3);
		
		List<Integer> list3 = new ArrayList<Integer>();
//		list3.add(4);
//		list3.add(5);
//		list3.add(6);
		
		vec2d.add(list1);
		vec2d.add(list2);
		vec2d.add(list3);
		
		Vector2D i = new Vector2D(vec2d);
		while (i.hasNext()) {
			Integer result = i.next();
			System.out.println(result);
		}
	}
	
	public Integer next() {
		hasNext();
		return j.next();
	}
	
	public boolean hasNext() {
		while ((j == null || !j.hasNext()) && i.hasNext())
			j = i.next().iterator();
		return j != null && j.hasNext();
	}
}
