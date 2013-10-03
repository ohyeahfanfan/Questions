package Heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import LinkedList.MergeListProblem;


public class OriginQuestion {

  public static class Point {
	public double x;
    public double y;
    Point(double x, double y){
    	this.x = x;
    	this.y = y;
    }
  }
  public static class MaxHeapComparator implements Comparator<Point>{
		public int compare(Point a, Point b){
			double diff = b.x * b.x + b.y * b.y - (a.x * a.x + a.y * a.y);
			if(diff  > 0) return 1;
			else if(diff < 0) return -1;
			else return 0;
		}
  }
  public static Point[] closestk( Point myList[], int k ) {
	  if(myList == null) return null;
	  if(k <= 0) return null; 
	  PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new MaxHeapComparator());
	  for(Point point: myList){
		  maxHeap.offer(point);
		  if(maxHeap.size() > k){
			  maxHeap.poll();
		  }
	  }
	  Point[] closestK = new Point[k];
	  int i = 0;
	  Iterator<Point> myItr = maxHeap.iterator();  
      while (myItr.hasNext()){  
            closestK[i] = myItr.next();
            i++;
      }
	  return closestK;
  }
  
  public static void main(String args[] ) {
  	Point[] points = {new Point(0,0), new Point(1.5 ,1), new Point(-0.5,1)};
  	Point[] closests = OriginQuestion.closestk(points,2);
  	System.out.print("");
  	
  }

}

