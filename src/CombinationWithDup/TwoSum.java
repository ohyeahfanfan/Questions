package CombinationWithDup;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

import Array.SpiralMatrix;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        int[] rez = new int[2];
        //fill in the hashtable
        Hashtable<Integer, LinkedList<Integer>> table = new Hashtable<Integer, LinkedList<Integer>>();
        for(int i = 0; i < numbers.length; i++){
            if(table.containsKey(numbers[i])){
                LinkedList<Integer> indices = table.get(numbers[i]);
                indices.add(i);
            }else{
                LinkedList<Integer> indices = new LinkedList<Integer>();
                indices.add(i);
                table.put(numbers[i], indices);
            }
        }
        for(int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            if(diff == numbers[i]){
                LinkedList<Integer> indices = table.get(diff);    
                if(indices.size() >= 2){
                    rez[0] = indices.get(0);
                    rez[1] = indices.get(1);
                    break;
                }
            }else if(table.containsKey(diff)){
                rez[0] = table.get(numbers[i]).get(0);
                rez[1] = table.get(diff).get(0);
                break;
            }
        }
        rez[0] += 1;
        rez[1] += 1;
        return rez;
    }
	public static void main(String[] args) {
    	TwoSum obj = new TwoSum();
    	int[] numbers = {2, 7, 11, 15};
    	int[] rez = obj.twoSum(numbers, 9);
    	System.out.println(rez[0] +" "+ rez[1]);
	}
}
