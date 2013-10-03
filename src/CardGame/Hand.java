package CardGame;

import java.util.ArrayList;

import CardGame.Game.GameStatus;

public class Hand implements Runnable{
	ArrayList<Card> cards = new ArrayList<Card>();
	Game game;
	int index;
	int score = 0;
	String handName;
	public Hand(String name, Game gameToJoin, int index){
		handName = name;
		game = gameToJoin;
	}
	public void add(Card card){
		System.out.println("[" + handName +"] has a new card " + card.suit().getName() + card.value());
		cards.add(card);
	}
	
	public Card lead(){

		if(cards.size() > 0){
			Card card = cards.remove(0);
			System.out.println("[" + handName +"] leads the card "  + card.suit().getName() + card.value());
			return card;
		}else{
			return null;
		}
	}
	
	public int leftCards(){
		return cards.size();
	}
	
	public void addScore(int extra){
		score += extra;

		System.out.println("[" + handName +"] current score is " + score);
		
	}
	public void printTotalScore(){
		System.out.println("[" + handName +"] total score is " + score);
	}
	
	
	@Override
	public void run() {
		play();
	}
	public synchronized void play(){
		//joining is failed
		if(!game.join(this)) return;
		
		while(game.getGameStatus() != GameStatus.OVER){
			try {
				//wait for game granting access 
				wait();
				//System.out.println("["+this.handName+"] wakes up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Card card;
			if((card = this.lead()) != null){
				//System.out.println("["+this.handName+"] leads card "+ card.faceValue);
				game.addCardToRound(card);
			}
			//game is over
			if(this.cards.size() == 0) break;
		}
		System.out.println("["+this.handName+"] is done");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
