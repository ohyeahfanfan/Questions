package Math;

public class Sqrt {
	/*
	  public int sqrt(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        long end = 1;
	        while(end * end <= x){
	            end <<= 1; 
	        }
	        int start = 0;
	        //binary search the square root
	        while(start+1 < end){
	            long mid = start + (end - start)/2;
	            if(mid * mid == x){
	                return (int)mid;
	            }else if(mid * mid < x){
	                start = (int)mid;
	            }else{
	                end = mid - 1;
	                //end most b
	            }
	        }
	        return start;
	    }*/
	public int sqrt(int x){
		int start = 0;
		int end = x;
		while(start <= end){
			long mid = start + (end - start)/2;
			long sq =  mid * mid;
			if(sq == x){
				return (int)mid;
			}else if(sq > x){
				end = (int) mid -1;
			}else{
				start = (int) mid + 1;
			}
					
		}
		return end;
	}
		 public static void main(String[] args) {
			 Sqrt sqrt = new Sqrt();
			 //sqrt.sqrt(2);
		 }
}
