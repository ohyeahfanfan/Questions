package CombinationWithDup;
import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum {

	  
    /*** 
     * @Problem: 
     * 3Sum 
     *  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
         Note: 
         Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ???? b ???? c) 
         The solution set must not contain duplicate triplets. 
       @idea 
     * Sort given array 
     * traverse the array from left to right 
     * for each element in the array 
     * find the two elements from right side of array  
     * the sum of them equals to given sum minus num 
     *  
     *  
     * @learn 
     * How to avoid duplicate element 
     * skips the numbers has the same value 
     * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]   [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]] 
     * In the triplet 
     * Avoid first and second elements are duplicate 
     * The triplet will be unique. 
     */
     public ArrayList<ArrayList<Integer>> threeSum(int[] num) { 
         Arrays.sort(num); 
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
         for(int i = 0; i<num.length-2; i++){//!!!!end at length-2 
             if(i>0&&num[i]==num[i-1]){//!!!avoid duplicate don't use same number twice as the first num of triplet 
                 continue; 
             } 
             int start = i+1; 
             int end = num.length-1;//end is num.length-1 
             int target = 0-num[i]; 
             int pre = Integer.MAX_VALUE; 
             while(start<end){ 
                 int sum = num[start]+num[end]; 
                 if(sum < target){ 
                     start++; 
                 }else if(sum > target){ 
                     end--;//!!!!end-- 
                 }else{ 
                     if(num[start]!=pre){///!!!!avoid duplicate, don't use the numbers have same value twice as 2nd number in triplet 
                         ArrayList<Integer> triplet = new ArrayList<Integer>(); 
                         triplet.add(num[i]); 
                         triplet.add(num[start]); 
                         triplet.add(num[end]); 
                         result.add(triplet); 
                         pre = num[start]; 
                     } 
                     end--; 
                     start++; 
                 } 
             } 
         } 
         return result; 
     } 
}
