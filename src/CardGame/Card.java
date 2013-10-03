package CardGame;

public abstract class Card {
	private boolean available = true;
	protected int faceValue;
	protected Suit suit;
	public Card(int value, Suit s){
		faceValue = value;
		suit = s;
	}
	public abstract int value();
	/*{
		//return faceValue;
	}*/
	public Suit suit(){
		return suit;
	}
	public boolean isAvailable(){
		return available;
	}
	public void markAvailable(){
		available = true;
	}
	public void markUnavailable(){
		available = false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
