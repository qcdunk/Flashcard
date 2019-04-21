import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeckByCategory() {
		Deck myDeck = new Deck();
		ArrayList<Card> animalDeck = new ArrayList<Card>();
		ArrayList<Card> testDeck = new ArrayList<Card>();
		
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
		
		animalDeck.add(card1);
		animalDeck.add(card2);
		animalDeck.add(card3);
		animalDeck.add(card5);
		animalDeck.add(card6);
		animalDeck.add(card7);
		animalDeck.add(card8);
		animalDeck.add(card9);
		animalDeck.add(card10);
		animalDeck.add(card11);
		
		//test deck should only contain card 1 and 2 (animal cards) after calling the method deckByCategory
		testDeck = myDeck.deckByCategory("animals");
		
		for (int x = 0; x < 10; x++) {
			assertEquals(animalDeck.get(x).getWord(), testDeck.get(x).getWord());
		}	
	}

}
