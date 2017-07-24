package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/6/24
 */
public class MiniParser {
	
	public static void main(String[] args) {
		MiniParser parser = new MiniParser();
//		String s = "[123,[456,[789]]]";
//		char c = '1';
//		NestedInteger result = parser.deserialize(s);
//		System.out.println(result);
		int start = 0;
		while (++start < 3) {
			System.out.println(start);
		}
	}
	
	public NestedInteger deserialize(String s) {
		NestedInteger result = new NestedInteger();
		NestedInteger cur = result;
		
		int start = 0, end;
		while (start < s.length()) {
			if (s.charAt(start) == '[') {
				NestedInteger temp = new NestedInteger();
				end = start + 1;
				
				while (end < s.length()) {
					if (s.charAt(end) == '[') {
						start = end;
						break;
					}
					
					if (s.charAt(end) == ',' || s.charAt(end) == ']') {
						if (end == start + 1) break;
						
						NestedInteger toAdd = new NestedInteger();
						toAdd.setInteger(getInt(s, start + 1, end));
						temp.add(toAdd);
						start = end + 1;
						if (start < s.length() && s.charAt(start) == ']') break;
					}
					
					end++;
				}
				
				cur.add(temp);
				cur = temp;
			}
			
			start++;
		}
		
		return result.getList().get(0);
	}
	
	private Integer getInt(String s, int start, int end) {
		return Integer.parseInt(s.substring(start, end));
	}
}
