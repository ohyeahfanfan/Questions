package CardGame;

import java.util.ArrayList;


import CardGame.Game.GameStatus;

public class Game {
	GameRule gameRule;
	Deck<Card> deck;
	ArrayList<Hand> hands = new ArrayList<Hand>();
	private GameStatus status;
	private int token = 0;
	ArrayList<Card> round = new ArrayList<Card>();

	/**
	 * @param args
	 */
	enum GameStatus {
		JOINING, PLAYING, OVER
	}

	public Game(GameRule rule) {
		gameRule = rule;
		deck = new Deck<Card>(gameRule.createSetOfCards());
		status = GameStatus.JOINING;
	}

	public synchronized boolean join(Hand hand) {
		if (status != GameStatus.JOINING) {
			return false;
		}
		if (hands.size() < gameRule.maxHands()) {
			hands.add(hand);
			System.out.println("[" + hand.handName + "] joins the game.");
			// we have enough players. Let's play
			if(hands.size() == gameRule.maxHands()){
				this.notifyAll();
			}
			return true;
		} else {
			return false;
		}
	}

	public synchronized void addCardToRound(Card card) {
		this.round.add(card);
		//everyone lead one card. Let's go next round.
		if(this.round.size() == this.hands.size()){
			notifyAll();
		}
	}

	public synchronized void start() {
		
		while(this.hands.size() < this.gameRule.maxHands()){
			try {
				//wait until we have enough players
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// dispatch cards to players
		int i = 0;
		Card card = null;
		
		while(!isOver()){
			ArrayList<Card> cards = new ArrayList<Card>();
			for(int j = 0; j < hands.size(); j++){
				cards.add(hands.get(j).lead());
			}
			gameRule.score(hands, cards);
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

	public ArrayList<Hand> getHands() {
		return new ArrayList<Hand>(this.hands);
	}

	public void totalScore() {
		for (Hand hand : hands) {
			hand.printTotalScore();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Game game = new Game(new BigSmallGameRule());
		Hand p1 = new Hand("fanfan", game, 0);
		Hand p2 = new Hand("lele", game, 1);
		Hand p3 = new Hand("zhuzhu", game, 2);
		Hand p4 = new Hand("benben", game, 3);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		game.start();
		
	}

	public GameStatus getGameStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

	public int getTokenNum() {
		return this.token;
	}

	public void goNext() {
		this.token++;
	}

}
