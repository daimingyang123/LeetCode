package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 17/4/2
 */
public class Chrimas {
	
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		Chrimas chrimas = new Chrimas();
	}

	

}
