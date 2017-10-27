package com.mingyangdai.stack;

import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/10/27
 */
public class TrappingRainWater {
    
    public static int trap(int[] height) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<height.length; i++) {
            if (!stack.isEmpty() && height[i]>height[stack.peek()]) {
                int right = i;
                while (stack.size() > 1) {
                    int b = height[stack.pop()];
                    while (!stack.isEmpty() && height[stack.peek()]==b) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[right]) - b;
                        if (h > 0) {
                            count += (right-left-1) * h;
                        }
                    }
                }
            }
            stack.push(i);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] height = {5,2,1,2,1,5};
        int count = trap(height);
        System.out.println(count);
    }
}
