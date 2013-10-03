package CardGame;

public enum Suit {
	CLUB(0), DIAMOND(1), HEARD(2), SPADE(3);
	private int value;
	//The constructor for an enum type must be package-private or private access. 
	//It automatically creates the constants that are defined at the beginning of the enum body. 
	//You cannot invoke an enum constructor yourself.
	private Suit(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
	public static Suit getSuitFromValue(int value){
		if(value == 0){
			return CLUB;
		}else if(value == 1){
			return DIAMOND;
		}else if(value == 2){
			return HEARD;
		}else{
			return SPADE;
		}
				
	}
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
