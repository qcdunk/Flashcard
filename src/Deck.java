import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//create an empty ArrayList of the Card object
	private ArrayList<Card> flashCards = new ArrayList <Card>();

	public ArrayList<Card> getFlashCards() {
		return flashCards;
	}
	
	public Deck () {
		Card card1 = new Card ("horse", "horse", "horse", "animals");
		Card card2 = new Card ("cat", "cat", "cat", "animals");
		Card card3 = new Card ("tiger", "tiger", "tiger", "animals");
		Card card4 = new Card ("flower", "flower", "flower", "nature");//this is NOT from the animals category, used as a test
		Card card5 = new Card ("dog", "dog", "dog", "animals");
		Card card6 = new Card ("fish", "fish", "fish", "animals");
		Card card7 = new Card ("rabbit", "rabbit", "rabbit", "animals");
		Card card8 = new Card ("mouse", "mouse", "mouse", "animals");
		Card card9 = new Card ("koala", "koala", "koala", "animals");
		Card card10 = new Card ("panda", "panda", "panda", "animals");
		Card card11 = new Card ("kangaroo", "fiskangarooh", "kangaroo", "animals");

		flashCards.add(card1);
		flashCards.add(card2);
		flashCards.add(card3);
		flashCards.add(card4);
		flashCards.add(card5);
		flashCards.add(card6);
		flashCards.add(card7);
		flashCards.add(card8);
		flashCards.add(card9);
		flashCards.add(card10);
		flashCards.add(card11);
	}

	//the following method shuffles the arrayList of cards
	void shuffleDeck(Deck myDeck) {
		Collections.shuffle(myDeck.getFlashCards());
	}
	
	//method to return a deck of cards from the animal category
	ArrayList<Card> deckByCategory(ArrayList<Card> allCards, String category) {
		ArrayList<Card> cardsByCategory = new ArrayList<Card>();
		
		//here we assign cards from a particular category to a new deck of cards
		for (Card card : allCards) {
			if (card.getCategory().equals(category)) {
				cardsByCategory.add(card);
			}
		}
		return cardsByCategory;
	}
	
}
