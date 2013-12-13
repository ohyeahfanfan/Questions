package Math;
/*
 * Integer to Roman Total 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntToRoman {
	public String intToRoman(int num) {
        char[] numbers = {'M','D','C','L','X', 'V', 'I'};
        //1000, 500, 100, 50, 10, 5, 1
        int scale = 1000;
        StringBuffer roman = new StringBuffer();
        int i = 0;
        while(num > 0){
            int digit = num / scale;
            num = num % scale;
            if(digit == 0){
            	////do nothing
            }else if(digit <= 3){
                while(digit > 0){
                    roman.append(numbers[i]);
                    digit--;
                }
            }else if(digit == 4){
                // -1
                roman.append(numbers[i]);
                // +5
                roman.append(numbers[i-1]);
            }else if(digit == 5){
                roman.append(numbers[i-1]);
            }else if(digit <= 8){
                // +5
                roman.append(numbers[i-1]);
                // +1
                digit -= 5;
                while(digit > 0){
                    roman.append(numbers[i]);
                    digit--;
                }
               
            }else if(digit == 9){
                // -1
                roman.append(numbers[i]);
                // +5
                roman.append(numbers[i-2]);
            }
            scale /= 10;
            i = i + 2;
            
        }
        return roman.toString();
    }
	 public static void main(String args[] ) {
	    	IntToRoman obj = new IntToRoman();
	    	System.out.println(obj.intToRoman(3042));
	 }
}
