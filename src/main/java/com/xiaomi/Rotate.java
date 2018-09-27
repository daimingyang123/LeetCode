package com.xiaomi;

/**
 * @author daimingyang
 * @since 2018/7/23
 */
public class Rotate {
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        char[] nums = array[0].replace(",", "").toCharArray();
        char target = array[1].toCharArray()[0];
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) return Integer.toString(mid);
            if (nums[start] < nums[end]) {
                if (target > nums[mid]) start = mid + 1;
                else end = mid - 1;
                continue;
            }
            
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > nums[mid] && target < nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        // 返回处理后的结果
        return "-1";
    }
    
    public static void main(String[] args) {
        String line = "4,5,6,7,0,1,2 6";
        String res = solution(line);
        System.out.println(res);
    }
}
