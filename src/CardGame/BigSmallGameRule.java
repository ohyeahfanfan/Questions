package CardGame;

import java.util.ArrayList;

public class BigSmallGameRule implements GameRule{
	public int maxHands(){
		return 4;
	}
	public void score(ArrayList<Hand> hands, ArrayList<Card> cards){
		int maxVal = -1;
		int maxIndex = -1;
		for(int i = 0; i < cards.size(); i++){
			Card card = cards.get(i);
			if(card.value() > maxVal){
				maxVal = card.value();
				maxIndex = i;
			}
		}

		hands.get(maxIndex).addScore(10);
	}
	public ArrayList<Card> createSetOfCards(){
		ArrayList<Card> cards = new ArrayList<Card>();
		for(Suit suit: Suit.values()){
			for(int i = 1; i <= 13; i++){
				cards.add(new BigSmallCard(i, suit));
			}
		}
		return cards;
	}
	public boolean isOver(Game game){
		ArrayList<Hand> hands = game.getHands();
		for(Hand hand: hands){
			if(hand.leftCards() != 0){
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
