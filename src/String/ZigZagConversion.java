package String;

import java.util.ArrayList;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        ArrayList<StringBuffer> rez = new ArrayList<StringBuffer>();
        for(int i = 0; i < nRows; i++){
        	rez.add(new StringBuffer());
        }
        int i = 0;
        int len = s.length();
        while(i < len){
            for(int r = 0; r < nRows && i < len; r++){
                rez.get(r).append(s.charAt(i));
                i++;
            }
            for(int r = nRows-2; r > 0 && i < len; r--){
                rez.get(r).append(s.charAt(i));
                i++;
            }
        }
        StringBuffer str = new StringBuffer();
        for(StringBuffer row : rez){
            str.append(row);
        } 
        return str.toString();
	}
	 public static void main(String[] args) {
		 ZigZagConversion obj = new ZigZagConversion();
		 System.out.println(obj.convert("PAYPALISHIRING", 3));
	 }
}