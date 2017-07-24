package com.mingyangdai;

import java.util.List;

/**
 * @author mingyang.dai
 * @since 17/3/20
 */
public class InsertInterval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		
		boolean find = false;
		int index = 0;
		//index=1
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).start > newInterval.start) {
				index = i - 1;
				find = true;
				break;
			}
		}
		
		if (!find) {
			intervals.add(newInterval);
			return intervals;
		}
		//[3,5]->[3,9]
		Interval interval;
		while (index < intervals.size()) {
			interval = intervals.get(index);
			if (newInterval.start < interval.end) {
				if (newInterval.end > interval.start) interval.end = newInterval.end;
				return intervals;
			}
		}
		//[3,9],[6,10]
		while (index < intervals.size()) {
			interval = intervals.get(index);
			if (intervals.get(index).end <= newInterval.end) {
				intervals.remove(index);
			}
		}
		
		return intervals;
	}

//    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

//    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

//    [[1,3],[6,9]]
//            [5,7]
	
	public class Interval {
		int start;
		int end;
		
		Interval() {
			start = 0;
			end = 0;
		}
		
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	
}
