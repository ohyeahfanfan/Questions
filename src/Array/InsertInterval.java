package Array;

import java.util.ArrayList;
import java.util.Comparator;

import Array.MergeInterval.Interval;
/*
 * One more step from Merge Sort  
 * 
 * 1.Insert to right position
 * 2. Merge 
 * 
 */
public class InsertInterval {
	class IntervalComparator implements Comparator<Interval>{ 
	    public int compare(Interval a, Interval b){ 
	        if(a.start < b.start)return -1; 
	        else if(a.start==b.start)return 0; 
	        else return 1; 
	    } 
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int insertPosition = searchInsert(intervals, newInterval.start);
        intervals.add(insertPosition, newInterval);
        int i = 0;
        while(i < intervals.size()-1){ 
            Interval a = intervals.get(i); 
            Interval b = intervals.get(i+1); 
            if(isOverLapped(a, b)){ 
                mergeTwoIntervals(a, b); 
                intervals.remove(i+1); 
            }else{ 
                i++; 
            } 
        } 
        return intervals; 

    }
    //Since intervals has been sorted, then a.start <= b.start 
    public boolean isOverLapped(Interval a, Interval b){ 
        if(a.end < b.start) return false; 
        else return  true; 
    } 
    //Since intervals has been sorted, then a.start <= b.start 
    public void mergeTwoIntervals(Interval a, Interval b){ 
        if(b.end > a.end) a.end = b.end; 
    }
    public int searchInsert(ArrayList<Interval> intervals, int target) { 
        int left = 0; 
        int right = intervals.size()-1; 
        while(left <= right){ 
            int mid = left + (right-left)/2; 
            if(intervals.get(mid).start < target){ 
                left = mid + 1; 
            }else{ 
                right = mid - 1; 
            } 
        } 
        return left;  
        //!!!! left不可能小于0，因为left一直是不断增减的, 
        //尽管left是随mid变化的， mid可能增大也可能减小，但是left始终是mid的下界限，所以始终left是增加的 
    }
    public static void main(String[] args) {
		
	}
}
