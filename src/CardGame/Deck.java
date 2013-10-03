package CardGame;

import java.util.ArrayList;

public class Deck <T extends Card>{
	ArrayList<T> cards;
	private int dealtIndex = 0;
	public Deck(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	public void shuffle(){
		
	}
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	public T dealCard(){
		//deal card is completed. 
		//No more card is available
		if(dealtIndex == cards.size()) 
			return null;
		//else let's dispatch next card;
		T card = cards.get(dealtIndex);
		dealtIndex ++;
		card.markUnavailable();
		return card;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
