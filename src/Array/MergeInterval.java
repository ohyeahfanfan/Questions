package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import LinkedList.ListNode;
import LinkedList.RotateList;

public class MergeInterval {
	/*
	 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * } 
	 */
	class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	class IntervalComparator implements Comparator<Interval>{ 
	    public int compare(Interval a, Interval b){ 
	        if(a.start < b.start)return -1; 
	        else if(a.start==b.start)return 0; 
	        else return 1; 
	    } 
	}   
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) { 
        //1. sort arraylist 
       Collections.sort(intervals, new IntervalComparator()); 
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
	public static void main(String[] args) {
		
	}
	
}
