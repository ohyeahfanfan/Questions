package CardGame;

import java.util.ArrayList;


public class Game {
	GameRule cardRule;
	Deck<Card> deck;
	ArrayList<Hand> hands;
	GameStatus status;
	boolean token;
	/**
	 * @param args
	 */
	enum GameStatus{
		JOINING, PLAYING, OVER
	}
	public Game(GameRule rule){
		cardRule = rule;
		deck = new Deck<Card>(cardRule.createSetOfCards());
		status = GameStatus.JOINING;
	}
	public synchronized boolean join(Hand hand){
		if(status != GameStatus.JOINING){
			return false;
		}
		if(hands.size() < cardRule.maxHands()){
			hands.add(hand);
			//we have enough players. Let's play
			if(hands.size() == cardRule.maxHands()){
				status = GameStatus.PLAYING;
				this.start();
			}
			return true;
		}else{
			return false;
		}
	}
	public void start(){
		//dispatch cards to players
		int i = 0;
		Card card = null;
		while((card = deck.dealCard()) != null){
			hands.get(i % hands.size()).add(card);
			i++;
		}
		i = 0;
		while(!isOver()){
			ArrayList<Card> cards = new ArrayList<Card>();
			for(int j = 0; j < hands.size(); j++){
				cards.add(hands.get(j).lead());
			}
			cardRule.score(hands, cards);
		}
	}
	
	public boolean isOver(){
		for(Hand hand: hands){
			if(hand.leftCards() != 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
