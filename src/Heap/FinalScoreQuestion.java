package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import Heap.OriginQuestion.Point;

/*
Given a list of test results (each with a test date, Student ID, and the student¡¯s Score), return the Final Score for each student. A student¡¯s Final Score is calculated as the average of his/her 5 highest test scores. You can assume each student has at least 5 test scores.
You may use the JDK or the standard template library. The solution will be evaluated on correctness, runtime complexity (big-O), and adherence to coding best practices. A complete answer will include the following:
Document your assumptions
Explain your approach and how you intend to solve the problem
Provide code comments where applicable
Explain the big-O run time complexity of your solution. Justify your answer.
Identify any additional data structures you used and justify why you used them.
Only provide your best answer to each part of the question.class TestResult
Use one of the following skeletons for your solutions.
Java:*/
class TestResult {
      int studentId;
      String testDate;
      int testScore;
      public TestResult(int studentId,String testDate,int testScore){
    	  this.studentId = studentId;
    	  this.testDate = testDate;
    	  this.testScore = testScore;
      }
   }
 
public class FinalScoreQuestion {
	//if we want to calculate top 6 or other numbers instead of top 5, we can change TOP_N here.
	private static final int TOP_N = 5;
	public static class MinHeapComparator implements Comparator<Integer>{
			public int compare(Integer a, Integer b){
				double diff = a - b;
				if(diff  > 0) return 1;
				else if(diff < 0) return -1;
				else return 0;
			}
	  }
   Map <Integer, Double> calculateFinalScores (List<TestResult> results) {
	   Map <Integer, Double> finalScores = new HashMap <Integer, Double>();
	   //heapMap: The key is the studentId and value is a heap which keep the max TOP_N scores.
	   Map <Integer, PriorityQueue<Integer>> heapMap = new HashMap <Integer, PriorityQueue<Integer>>();
	   //Get top 5 (TOP_N) scores for each student
	   for(TestResult result : results){
		   int studentId = result.studentId;
		   PriorityQueue<Integer> minHeap = null;
		   if(heapMap.containsKey(studentId)){
			   minHeap = heapMap.get(studentId);
			   minHeap.offer(result.testScore);
			   //always keep the top TOP_N (5) in the heap
			   if(minHeap.size() > TOP_N){
				  minHeap.poll();
			   }
		   }else{
			   minHeap = new PriorityQueue<Integer>(TOP_N, new MinHeapComparator());
			   minHeap.offer(result.testScore);
			}
		   heapMap.put(studentId, minHeap);
	   }
	   //Calculate the final score for each student
	   Iterator<Entry<Integer, PriorityQueue<Integer>>> it = heapMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer, PriorityQueue<Integer>> pairs = it.next();
	        int studentId = pairs.getKey();
	        PriorityQueue<Integer> scores = pairs.getValue();
	        double avg = 0;
	        for(Integer score : scores){
	        	avg += score; 
	        }
	        //although we make assumption each student has at least 5 scores, defensive coding, 
	        //if there are less than 5 scores, we get the average value of scores. 
	        avg /= scores.size();
	        finalScores.put(studentId, avg);
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	   return finalScores;
   }
   
   public static void main(String args[] ) {
	   List<TestResult> result = new LinkedList<TestResult>();
	   result.add(new TestResult(1, "", 12));
	   result.add(new TestResult(1, "", 12));
	   result.add(new TestResult(1, "", 12));
	   result.add(new TestResult(1, "", 12));
	   result.add(new TestResult(1, "", 12));
	   result.add(new TestResult(1, "", 16));
	   //result.add(new TestResult(2, "", 12));
	   //result.add(new TestResult(2, "", 12));
	   result.add(new TestResult(2, "", 12));
	   result.add(new TestResult(2, "", 12));
	   result.add(new TestResult(2, "", 12));
	   result.add(new TestResult(2, "", 17));
	   
	   FinalScoreQuestion fsq = new FinalScoreQuestion();
	   Map <Integer, Double> finalScores = fsq.calculateFinalScores(result);
	   Iterator<Entry<Integer, Double>> it = finalScores.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Integer, Double> pairs = it.next();
	        int studentId = pairs.getKey();
	        double score = pairs.getValue();
	        System.out.println("studentId: "+ studentId + " score:" + score);
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	  	
   }
   }
 