package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/8/30
 */
public class MeetingRooms {
    public static class Interval {
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
    
//    Given [[0, 30],[5, 10],[15, 20]],
    
    public int minMeetingRooms(Interval[] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) return res;
    
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        List<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            Interval pre = searchPre(list, interval.start);
            if (pre == null) list.add(interval);
            else pre.end = interval.end;
        }
        
        return list.size();
    }
    
    private Interval searchPre(List<Interval> list, int start) {
        Interval pre = null;
        for (Interval interval : list) {
            if (interval.end <= start) {
                if (pre == null) pre = interval;
                else if (interval.end > pre.end) pre = interval;
            }
        }
        return pre;
    }
    
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(1, 5),
                new Interval(8, 9),
                new Interval(8, 9)
        };
        int res = new MeetingRooms().minMeetingRooms(intervals);
        System.out.println(res);
    }
}
