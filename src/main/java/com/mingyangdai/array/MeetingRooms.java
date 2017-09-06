package com.mingyangdai.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingyang.dai
 * @since 2017/8/30
 */
public class MeetingRooms {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
 
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length < 2) return true;
        
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        Interval pre = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start < pre.end) return false;
            pre = cur;
        }
        return true;
    }
}
