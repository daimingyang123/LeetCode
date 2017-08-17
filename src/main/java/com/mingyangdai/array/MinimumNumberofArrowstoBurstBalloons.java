package com.mingyangdai.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingyang.dai
 * @since 2017/8/17
 */
public class MinimumNumberofArrowstoBurstBalloons {
    
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        
        int count = 0;
        for (int i=1; i<points.length; i++) {
            if (points[i][0] < points[i-1][1]) {
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            } else {
                count++;
                if (i == points.length-1) count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons balloons = new MinimumNumberofArrowstoBurstBalloons();
        int[][] points = {{10,16}, {3,8}, {1,2}, {7,12}};
        int res = balloons.findMinArrowShots(points);
        System.out.println(res);
    }
}
