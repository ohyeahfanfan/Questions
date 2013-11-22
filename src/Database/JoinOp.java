package Database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
/*
 * An implementation of Join Operation Node 
 * 
 *   \(leftIn) /(rightIn)
 *      JoinOp
 *   	  |(out)
 *   
 *   1. wait until the last elements from leftIn 
 *   2. sort all the elements of leftIn => leftq
 *   3. wait until the last elements from rightIn
 *   4. sort all the elements of rightIn => rightq
 *   5. find the matchings
 *   6. put into out 
 */
public class JoinOp extends OpNode implements Runnable {
	private final BlockingQueue<Record> out;
	private final BlockingQueue<Record> leftIn;
	private final BlockingQueue<Record> rightIn;
	private final PriorityQueue<Record> leftq;
	private final PriorityQueue<Record> rightq;
	private String leftKeyName = "";
	private String rightKeyName = "";
	JoinOp(BlockingQueue<Record> out
			, BlockingQueue<Record> leftIn
			, BlockingQueue<Record> rightIn
			, String leftKey
			, String rightKey
			, OpNode leftChild
			, OpNode rightChild){
		this.out = out;
		this.leftIn = leftIn;
		this.rightIn = rightIn;
		this.leftKeyName = leftKey;
		this.rightKeyName = rightKey;
		this.left = leftChild;
		this.right = rightChild;
		//comparator for leftq priority queue
		Comparator<Record> leftComparator = 
				new Comparator<Record>(){
			public int compare(Record r1, Record r2){
				String v1 = r1.getTuple().get(leftKeyName);
				int v1Int = Integer.parseInt(v1);
				String v2 = r2.getTuple().get(leftKeyName);
				int v2Int = Integer.parseInt(v2);
				if(v1Int == v2Int) return 0;
				else if(v1Int > v2Int) return 1;
				else return -1;
				
			}
		};
		leftq = new PriorityQueue<Record>(10,leftComparator);
		//comparator for right priority queue
		Comparator<Record> rightComparator = 
				new Comparator<Record>(){
			public int compare(Record r1, Record r2){
				String v1 = r1.getTuple().get(rightKeyName);
				int v1Int = Integer.parseInt(v1);
				String v2 = r2.getTuple().get(rightKeyName);
				int v2Int = Integer.parseInt(v2);
				if(v1Int == v2Int) return 0;
				else if(v1Int > v2Int) return 1;
				else return -1;
			}
		};
		rightq = new PriorityQueue<Record>(10,rightComparator);
	}
	public void run(){
		try {
			Record left = leftIn.take();
			//wait until the last elements from leftIn 
			//sort all the elements of leftIn => leftq
			while(left.type != RECORD_TYPE.POISON){
				leftq.offer(left);
				left = leftIn.take();
			}
			Record right = rightIn.take();
			//wait until the last elements from rightIn
			//sort all the elements of rightIn => rightq
			while(right.type != RECORD_TYPE.POISON){
				rightq.offer(right);
				right = rightIn.take();
			}
			//find the matchings
			// put into out 
			while(!leftq.isEmpty() && !rightq.isEmpty()){
				left = leftq.peek();
				right = rightq.peek();
				String leftVal = left.getTuple().get(this.leftKeyName);
				String rightVal = right.getTuple().get(this.rightKeyName);
				int leftValInt = Integer.parseInt(leftVal);
			    int rightValInt = Integer.parseInt(rightVal);
				if(leftValInt == rightValInt){
					//!!!!!!!duplicate matching field!!!!!!!!!!!!!
					ArrayList<Record> leftBunch = new ArrayList<Record>();
					ArrayList<Record> rightBunch = new ArrayList<Record>();
					while(!leftq.isEmpty() && leftq.peek().getTuple().get(leftKeyName).equals(leftVal)){
						leftBunch.add(leftq.poll());
					}
					while(!rightq.isEmpty() && rightq.peek().getTuple().get(rightKeyName).equals(rightVal)){
						rightBunch.add(rightq.poll());
					}
					for(Record leftRecord : leftBunch){
						for(Record rightRecord: rightBunch){
							Record merged = Record.createRecordByMerge(leftRecord, rightRecord);
							out.put(merged);
						}
					}
				}else if(leftValInt < rightValInt){
					leftq.poll();
				}else{
					rightq.poll();
				}
				
			}
			//tell consumer, this is the end of stream
			out.put(new Record(RECORD_TYPE.POISON));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
