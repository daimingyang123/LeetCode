package com.mingyangdai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
//	public static String solution(String S) {
//		int[] occurrences = new int[26];
//		for (char ch : S.toCharArray()) {
//			occurrences[ch - 'a']++;
//		}
//
//		char best_char = 'a';
//		int  best_res  = occurrences[0];
//
//		for (int i = 0; i < 26; i++) {
//			if (occurrences[i] > best_res) {
//				best_char = (char)((int)'a' + i);
//				best_res  = occurrences[i];
//			}
//		}
//
//		return Character.toString(best_char);
//	}
	
//	public int solution(String S) {
//		char[] chars = S.toCharArray();
//		int i = 0,j = chars.length - 1;
//		for (; i < chars.length && i <= j;) {
//			if (chars[i] == '(' && chars[j] == ')') {
//				i ++;
//				j --;
//			}else if(chars[i] == '(' && chars[j] != ')') {
//				j --;
//			}else if(chars[i] != '(' && chars[j] == ')'){
//				i ++;
//			}else {
//				i++;
//				j--;
//			}
//		}
//		return i;
//	}

	public String fuck(int N, String S, String T) {
		char[][] array = new char[N][N];
		for (String t : T.split(" ")) {
			int x = t.charAt(0) - '0';
			int y = t.charAt(1) - 'A';
			array[x][y] = 'X';
		}
		
		int hit = 0, sunk = 0;
		for (String ship : S.split(",")) {
			Boolean isSunk = isSunk(array, ship);
			if (isSunk == null) continue;
			if (isSunk) sunk++;
			else hit++;
		}
		return sunk + "," + hit;
	}
	
	private Boolean isSunk(char[][] array, String ship) {
		String[] pos = ship.split(" ");
		int rowStart = pos[0].charAt(0)-'1';
		int colStart = pos[0].charAt(1)-'A';
		int rowEnd = pos[1].charAt(0)-'1';
		int colEnd = pos[1].charAt(1)-'A';
		
		int count = 0;
		for (int i=rowStart; i<=rowEnd; i++) {
			for (int j=colStart; j<=colEnd; j++) {
				if (array[i][j] == 'X') count++;
			}
		}
		if (count == 0) return null;
		return count == (rowEnd-rowStart)*(colEnd-colStart);
	}
	
	
	public String solution(int N, String S, String T) {
		
		int sunk = 0;
		int live = 0;
		
		List<Set<String>> ships = new ArrayList<Set<String>>();
		for (String ship : S.split(",")) {
			String[] corners = ship.split(" ");
			String left = corners[0];
			String right = corners[1];
			char minCol = left.charAt(left.length()-1);
			char maxCol = right.charAt(right.length()-1);
			int minRow = Integer.parseInt(left.substring(0, left.length()-1));
			int maxRow = Integer.parseInt(right.substring(0, right.length()-1));
			Set<String> aShip = new HashSet<String>();
			for (int i = minRow; i <= maxRow; i++) {
				for (char j = minCol; j <= maxCol; j++) {
					aShip.add(i+""+((char)j+""));
				}
			}
			ships.add(aShip);
		}
		
		String[] bombs = T.split(" ");
		for (Set<String> ship : ships) {
			int originSize = ship.size();
			for (int i = 0; i < bombs.length; i++) {
				ship.remove(bombs[i]);
			}
			if (ship.size() == 0) {
				sunk ++;
			}else if(ship.size() != originSize){
				live ++;
			}
		}
		return sunk+","+live;
	}
	
	public int[] solution(int[] A) {
		// to base 10
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i]*Math.pow(-2, i);
		}
		// get ceiling half
		int half = (sum+1)/2;
		// resolve absolute
		int abs = Math.abs(half);
		List<Pair> factors = new ArrayList<Pair>();
		while(abs > 1) {
			int maxPow = 0;
			for (; abs > Math.pow(2, maxPow); maxPow++);
			int factor = (int)Math.pow(2, maxPow);
			factor = factor == abs ? factor : factor/2;
			factors.add(new Pair(half < 0 ? -factor : factor, maxPow + (factor == abs ? 0 : -1)));
			abs = abs - factor;
		}
		if(abs == 1) factors.add(new Pair(half < 0 ? -abs : abs, 0));
		int size = factors.size();
		for (int i = size -1; i >= 0; i--) {
			Pair pair = factors.get(i);
			// adjust
			if ((pair.pow % 2 == 0 && pair.value < 0) || (pair.pow % 2 == 1 && pair.value > 0)) {
				factors.remove(i);
				factors.add(i,new Pair((int)Math.pow(-2, pair.pow+1), pair.pow+1));
				factors.add(i+1,new Pair((int)Math.pow(-2, pair.pow), pair.pow));
				i++;
			}
			// merge
			if(i > 0 && pair.value == factors.get(i-1).value) {
				factors.remove(i);
				factors.set(i-1, new Pair(pair.value *2, pair.pow + 1));
			}
		}
		// to -2 base
		List<Integer> result = new ArrayList<Integer>();
		int length = factors.get(0).pow + 1;
		for (int i = 0,pointer = factors.size()-1; i < length; i++) {
			if(factors.get(pointer).value == Math.pow(-2, i)) {
				result.add(1);
				pointer --;
			}else {
				result.add(0);
			}
		}
		int[] array = new int[result.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = result.get(i);
		}
		return array;
	}
}

class Pair {
	public int value;
	public int pow;
	public Pair(int v, int p) {
		value = v;
		pow = p;
	}

	
	
	public static void main(String[] args) {
		int N = 4;
		String S = "";
		String T = "";
		
		String res = new AppTest().solution(4, S, T);
		System.out.println(res);
	}
}
