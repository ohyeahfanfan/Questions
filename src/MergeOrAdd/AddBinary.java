package MergeOrAdd;

/* Same Type of Problems
* Add Binary (OR is better) since request add carry
* Add Two Number (OR is better) since request add carry
* Merge Two Sorted List (OR and AND both are OK, since after merge it doesn't require do anything)
*/
public class AddBinary {
	public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int carry = 0;
        StringBuffer rez = new StringBuffer();
        
        for(int i = a.length()-1 , j = b.length() -1; i >= 0 || j >= 0; i--, j--){
            char c1 = i >= 0 ? a.charAt(i) : '0';
            char c2 = j >= 0 ? b.charAt(j) : '0';
            int num = c1 - '0' + c2 - '0' + carry;
            carry = num / 2;
            num = num % 2;
            /*
             * int a = 1;
             * char b = (char) a;
             * System.out.println(b);
             * will print out the char with ascii value 1 (start-of-heading char, which isn't printable).
             */
            char c = (char) ('0'+ num);
            rez.insert(0, c);
        }
        if(carry > 0) rez.insert(0, '1');
        return rez.toString();
    }
	public static void main(String args[] ) {
    	AddBinary obj = new AddBinary();
    	System.out.println(obj.addBinary("110", "11"));
    }
}
