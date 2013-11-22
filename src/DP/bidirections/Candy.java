package DP.bidirections;

public class Candy {
	
    //坑底是1，坡是点到坑底的距离，封顶是max(left,right)+1
	/*
	 * @ Question
	 * Candy
	 * There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?
	 * 
	 * 
	 */
    public int candy(int[] ratings) {
        int minCandy = ratings.length;
        int[] mins = new int[ratings.length];
        int curCandy = 0;
        mins[0] = 0;
        //left to right; make sure if rating[left] < rating[right], curCandy[left] < curCandy[right]
        for(int i = 1; i <  ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                curCandy++;
            }else{
                curCandy = 0;
            }
            mins[i] = curCandy;
        }
        //right to left; if rating[right] < rating[left], curCandy[right] > curCandy[left] 
        curCandy = 0;
        minCandy += mins[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                curCandy ++;
            }else{
                curCandy = 0;
            }
            minCandy += Math.max(curCandy, mins[i]);
        }
        return minCandy;
        
    }
}
