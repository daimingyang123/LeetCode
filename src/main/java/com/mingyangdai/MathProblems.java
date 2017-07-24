package com.mingyangdai;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 17/4/14
 */
public class MathProblems {
	
	public static void main(String[] args) {
		MathProblems problems = new MathProblems();
		int dividend = 15;
		int divisor = 1;
		int result = problems.divide(dividend, divisor);
		System.out.println(result);
	}
	
	public boolean isPerfectSquare(int num) {
		if (num <= 0) return false;
		if (num == 1) return true;
		long start = 0, end = num / 2, mid, square;
		while (start <= end) {
			mid = (start + end) / 2;
			square = mid * mid;
			if (square == num) {
				return true;
			} else if (square > num) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

//    public int getSum(int a, int b) {
//        String first = getBinaryString(a);
//        String second = getBinaryString(b);
//        StringBuilder builder = new StringBuilder();
//        boolean flag = false;
//
//        for (int i=31;i>=0;i--){
//            if (first.charAt(i) == '0' && second.charAt(i) == '0'){
//                if (flag){
//                    builder.insert(0, 1);
//                    flag = false;
//                } else{
//                    builder.insert(0, "0");
//                }
//            }else if (first.charAt(i) == '1' && second.charAt(i) == '1'){
//                if (flag){
//                    builder.insert(0, "1");
//                }else {
//                    builder.insert(0, "0");
//                    flag = true;
//                }
//            }else {
//                if (flag) builder.insert(0, "0");
//                else builder.insert(0, "1");
//            }
//        }
//
//        if (builder.toString().charAt(0) == '1'){
//            return -getPositive(builder.toString());
//        }
//        return Integer.parseInt(builder.toString(), 2);
//    }
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] small, big;
		if (nums1.length > nums2.length) {
			big = nums1;
			small = nums2;
		} else {
			big = nums2;
			small = nums1;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int start = 0, end = big.length - 1, mid;
		Integer pre = null;
		for (int n : small) {
			if (pre != null && pre.equals(n)) continue;
			pre = n;
			while (start <= end) {
				mid = (start + end) / 2;
				if (big[mid] == n) {
					while (mid < big.length) {
						if (big[mid++] == n) {
							list.add(n);
						} else {
							start = mid;
							break;
						}
					}
					break;
				} else if (big[mid] > n) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return result;
	}
	
	private String getBinaryString(int num) {
		StringBuilder result = new StringBuilder(Integer.toBinaryString(num));
		while (result.length() < 32) {
			result.insert(0, "0");
		}
		return result.toString();
	}
	
	private int getPositive(String negative) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < negative.length(); i++) {
			if (negative.charAt(i) == '0') result.append("1");
			else result.append("0");
		}
		return Integer.parseInt(result.toString(), 2) + 1;
	}
	
	public int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
	
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;
		
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
		
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
	public List<String> readBinaryWatch(int num) {
		int[] hours = {1, 2, 4, 8};
		int[] mins = {1, 2, 4, 8, 16, 32};
		List<String> result = new ArrayList<String>();
		for (int i = 0; i <= num; i++) {
			List<String> hourStrs = new ArrayList<String>();
			selectNum(i, hours, 0, 0, hourStrs);
			List<String> minStrs = new ArrayList<String>();
			selectNum(num - i, mins, 0, 0, minStrs);
			combineStrs(hourStrs, minStrs, result);
		}
		return result;
	}
	
	private void combineStrs(List<String> hours, List<String> mins, List<String> result) {
		for (String hour : hours) {
			for (String min : mins) {
				result.add(hour + ":" + min);
			}
		}
	}
	
	private void selectNum(int num, int[] nums, int index, Integer cur, List<String> result) {
		if (num == 0) {
			String temp = cur.toString();
			if (nums.length == 6 && cur < 10) temp = "0" + temp;
			result.add(temp);
			return;
		}
		if (index == nums.length) return;
		selectNum(num - 1, nums, index + 1, cur + nums[index], result);
		selectNum(num, nums, index + 1, cur, result);
	}
	
	public int numberOfBoomerangs(int[][] points) {
		//key:index value:dis,count
		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
		for (int i = 0; i < points.length; i++) {
			map.put(i, new HashMap<Integer, Integer>());
		}
		int count = 0;
		
		Map<Integer, Integer> countMap;
		int distance;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				distance = getDistance(points[i], points[j]);
				countMap = map.get(i);
				countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
				map.put(i, countMap);
				
				countMap = map.get(j);
				countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
				map.put(j, countMap);
			}
			
			for (Map.Entry<Integer, Integer> entry : map.get(i).entrySet()) {
				if (entry.getValue() >= 2) count += count(entry.getValue());
			}
			map.remove(i);
		}
		
		return count;
	}
	
	private int getDistance(int[] first, int[] second) {
		int x = first[0] - second[0];
		int y = first[1] - second[1];
		return x * x + y * y;
	}
	
	private int count(int n) {
		return n * (n - 1);
	}
	
	public int findContentChildren(int[] g, int[] s) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : s) {
			max = Math.max(max, n);
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int count = 0;
		for (int n : g) {
			if (n > max) continue;
			while (n <= max) {
				if (map.containsKey(n)) {
					if (map.get(n) == 1) map.remove(n);
					else map.put(n, map.get(n) - 1);
					count++;
					break;
				} else {
					n++;
				}
			}
		}
		
		return count;
	}
	
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		if (heaters.length == 1) return Math.max(heaters[0] - houses[0], heaters[0] - houses[houses.length - 1]);
		
		int max = 0, index, min;
		for (int n : houses) {
			index = binary(heaters, n);
			if (index == heaters.length - 1) min = n - heaters[index];
			else min = Math.min(Math.abs(n - heaters[index]), heaters[index + 1] - n);
			max = Math.max(max, min);
		}
		return max;
	}
	
	private int binary(int[] nums, int target) {
		int start = 0, end = nums.length - 1, mid;
		while (start <= end) {
			mid = (start + end) >> 1;
			if (nums[mid] == target) return mid;
			else if (nums[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return start == 0 ? start : start - 1;
	}
	
	public int[] constructRectangle(int area) {
		int[] result = new int[2];
		int start = (int) Math.sqrt(area);
		while (start > 0) {
			if (area % start == 0) {
				result[1] = start;
				result[1] = area / start;
				return result;
			}
			start--;
		}
		return result;
	}
	
	public int findPairs(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			set.add(n);
		}
		
		HashSet<Integer> result = new HashSet<Integer>();
		for (int n : nums) {
			if (set.contains(n + k)) {
				set.add(n + n + k);
			}
			if (set.contains(n - k)) {
				set.add(n + n - k);
			}
		}
		
		return result.size();
	}
	
	public int divide(int dividend, int divisor) {
		//Reduce the problem to positive long integer to make it easier.
		//Use long to avoid integer overflow cases.
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		
		//Take care the edge cases.
		if (ldivisor == 0) return Integer.MAX_VALUE;
		if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
		
		long lans = ldivide(ldividend, ldivisor);
		
		int ans;
		if (lans > Integer.MAX_VALUE) { //Handle overflow.
			ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			ans = (int) (sign * lans);
		}
		return ans;
	}
	
	private long ldivide(long ldividend, long ldivisor) {
		// Recursion exit condition
		if (ldividend < ldivisor) return 0;
		
		//  Find the largest multiple so that (divisor * multiple <= dividend),
		//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
		//  Think this as a binary search.
		long sum = ldivisor;
		long multiple = 1;
		while ((sum + sum) <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
		return multiple + ldivide(ldividend - sum, ldivisor);
	}
}
