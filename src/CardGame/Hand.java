package CardGame;

import java.util.ArrayList;

public class Hand{
	ArrayList<Card> cards = new ArrayList<Card>();
	int score = 0;
	public void add(Card card){
		cards.add(card);
	}
	
	public Card lead(){
		return cards.remove(0);
	}
	
	public int leftCards(){
		return cards.size();
	}
	
	public void addScore(int extra){
		score += extra;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
