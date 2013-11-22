package Sorting;
import java.util.HashSet;


public class LongestConsecutive {
	 /*
	  *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	  *For example,
	  *Given [100, 4, 200, 1, 3, 2],
	  *The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	  *Your algorithm should run in O(n) complexity. 
	  * 
	  * 
	  */
	 public static int longestConsecutiveFast(int[] nums) {//!!!!!!!!!!!!!!!!!!!
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        HashSet<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++){ //ȥ�أ��������
	            set.add(nums[i]);
	        }
	        int maxLength = 0;
	        for(int num : nums){//!!!��set��ʧ��
	            if(set.contains(num)){ //�����
	                int less = 0;
	                int cur = num;
	                while(set.contains(cur)){
	                    less ++;
	                    set.remove(cur);
	                    cur --;
	                }
	                int more = 0;
	                cur = num + 1;
	                while(set.contains(cur)){ //�ұ����
	                    more ++;
	                    set.remove(cur);
	                    cur ++;
	                }
	                maxLength = Math.max(maxLength, less + more);
	            }    
	        }
	        
	        return maxLength;
	    }
	 
	 public int longestConsecutive(int[] num) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        HashSet<Integer> set = new HashSet<Integer>();
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0; i < num.length; i++){
	            set.add(num[i]);
	            min = Math.min(min, num[i]);
	            max = Math.max(max, num[i]);
	        }
	        int maxLength = 0;
	        int start = min;
	        int end = start;
	        while(end <= max + 1){
	            if(set.contains(end)){
	                end ++;
	            }else if(!set.contains(end)){
	                if(start != end){
	                    maxLength = Math.max(maxLength, end - start);
	                    end ++;
	                    start = end;
	                }else{
	                    start ++;
	                    end ++;
	                }
	            }
	        }
	        return maxLength;
	    }
	 public static void main(String[] args) {
		    int[] nums = {0, -1};
			LongestConsecutive.longestConsecutiveFast(nums);
		}
}
