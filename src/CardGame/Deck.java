package CardGame;
import java.util.*;

public class Deck <T extends Card>{
	ArrayList<T> cards;
	private int dealtIndex = 0;
	public Deck(ArrayList<T> deckOfCards){
		cards = deckOfCards;
		shuffle();
	}
	public void shuffle(){
		Random r = new Random();
		for(int i = cards.size()-1; i > 0; i--){
			//r.nextInt()
			int swapIndex = r.nextInt(i);
			T temp = cards.get(swapIndex);
			cards.set(swapIndex, cards.get(i));
			cards.set(i, temp);
		}
		
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
