package CombinationWithDup;
import java.util.Arrays;


public class ThreeSumClosest {
	/*** 
     *@Problem 
     *3Sum Closest 
     *Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution. 
     *For example, given array S = {-1 2 1 -4}, and target = 1. 
     *The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).  
     *@idea 
     * 
     * 
     */
    public int threeSumClosest(int[] num, int target) { 
        int closestSum = 0; 
        Arrays.sort(num); 
        int preDiff = Integer.MAX_VALUE; 
        for(int i = 0; i < num.length-2; i++){ 
            if(i>0&&num[i]==num[i-1])continue; //same number first position only appear once
            int start = i+1;  
            int end = num.length-1; 
            //find the 2nd (start points to), the 3rd (end points to) from the right side of the 1st (num[i])
            while(start < end){ 
                int sum = num[i] + num[start] + num[end]; 
                if(Math.abs(sum-target) < preDiff){ 
                    closestSum = sum; 
                    preDiff = Math.abs(sum - target); 
                }
                //Math.abs(sum-target) > preDiff we should continue 
                if(sum == target){ 
                    return target; 
                }else if(sum < target){ 
                    start ++; 
                }else{ 
                    end--; 
                } 
            } 
        }
        return closestSum;
     }
    public static void main(String[] args) {
    	ThreeSumClosest obj = new ThreeSumClosest();
    	int[] num = {56,57,-47,-14,23,31,20,39,-51,7,-4,43,-53,32,24,56,-28,90,-75,-6,21,-100,41,-84,95,95,44,84,70,-22,-86,-6,90,-87,65,-28,-29,-94,98,-28,-100,23,-25,6,-56,-54,-5,53,-88,-25,-31,-71,-13,-62,73,-35,-78,16,99,97,84,-27,-43,-50,18,-16,-61,7,-17,16,-92,28,43,-38,-33,-27,84,-72,-100,-91,-97,-99,59,-63,73,99,98,-100,-37,-80,3,18,93,-81,12,-75,-43,99,10,10,-6,13,0,76,-82,-5,27,-38,-81,77,-55,-100,90,-32,-25,-15,-16,68,-6,87,65,-38,82,78,-61,87,-72,46,50,-60,86,39,69,85,-49,28};
    	obj.threeSumClosest(num, -289);
    }
}
