package DP;

import Bit.SingleNumberII;

public class GasStation {
	public int canCompleteCircuitFast(int[] gas, int[] cost) {
		int sum = 0;
		int curSum = 0;
        int beforeStart = -1;
        for(int i = 0; i < gas.length; i++){
        	curSum += gas[i] - cost[i];
        	sum += gas[i] - cost[i];
        	if(curSum < 0){
        		beforeStart = i;
        		curSum = 0;
        	}
        }
        return  (sum >= 0 ? beforeStart + 1 : -1);
    }
	/*
	 * O(n^2) 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		for(int i = 0; i < gas.length; i++){
            for(int j = 0; j < gas.length; j++ ){
                int cur = (i + j) % gas.length;
                if(gas[cur] - cost[cur] < 0){
                    break;
                }else if(j == gas.length-1){
                    return i;
                }    
            }
        }
        return  -1;
    }
	public static void main(String[] args) {
		GasStation gasStn = new GasStation();
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int startIndex = gasStn.canCompleteCircuitFast(gas, cost);
		System.out.println(startIndex);
	}
	
}
