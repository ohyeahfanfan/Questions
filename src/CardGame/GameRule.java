package CardGame;

import java.util.ArrayList;
interface GameRule{
	public abstract int maxHands();
	public abstract ArrayList<Card> createSetOfCards();
	public void score(ArrayList<Hand> hands, ArrayList<Card> cards);
}
/*
public class CardRule <T extends Card>{
	public int maxHands(){
		return 4;
	}
	public ArrayList<T> getSetOfCard(Class<T> clazz) throws InstantiationException, IllegalAccessException{
		ArrayList<T> cards = new ArrayList<T>();
		for(Suit suit: Suit.values()){
			for(int i = 0; i <= 13; i++){
				T bsc = clazz.newInstance();
				cards.add(bsc);
			}
		}
		return cards;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}*/
