package Recursive;


import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<String>();
        if(digits == null) return combinations;
        StringBuffer combination = new StringBuffer();
        generateCombinationsByDigit(digits, 0, combination, combinations);
        return combinations;
    }
    public void generateCombinationsByDigit(String digits, int index, StringBuffer combination, ArrayList<String> combinations){
        if(index == digits.length()){
              combinations.add(combination.toString());
              return;
        }
        String letters = getMappingLetters(digits.charAt(index) - '0');
        for(int i = 0; i < letters.length(); i++){
            combination.append(letters.charAt(i));
            generateCombinationsByDigit(digits, index + 1, combination, combinations);
            combination.deleteCharAt(combination.length()-1);
        }
        return;
    }
    public String getMappingLetters(int num){
        if(num == 2){
            return "abc";
        }else if(num == 3){
            return "def";
        }else if(num == 4){
            return "ghi";
        }else if(num == 5){
            return "jkl";
        }else if(num == 6){
            return "mno";
        }else if(num == 7){
            return "pqrs";
        }else if(num == 8){
            return "tuv";
        }else if(num == 9){
            return "wxyz";
        }else{
            return "error";
        }
    }
    public static void main(String[] args) {
    	LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
    	ArrayList<String> rez = obj.letterCombinations("23");
    	System.out.println(rez.size());
    }
    	
}
