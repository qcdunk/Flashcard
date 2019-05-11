import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeckByCategory() {
		
		Deck myDeck = new Deck();
		ArrayList<Card> animalDeck = new ArrayList<Card>();
		ArrayList<Card> testDeck = new ArrayList<Card>();
		
		Card card1 = new Card ("horse", "horse", "horse", "animals",1);
		Card card2 = new Card ("cat", "cat", "cat", "animals",1);
		Card card3 = new Card ("tiger", "tiger", "tiger", "animals",1);
		Card card4 = new Card ("crocodile", "crocodile", "crocodile", "animals",1);
		Card card5 = new Card ("dog", "dog", "dog", "animals",1);
		Card card6 = new Card ("fish", "fish", "fish", "animals",1);
		Card card7 = new Card ("rabbit", "rabbit", "rabbit", "animals",1);
		Card card8 = new Card ("mouse", "mouse", "mouse", "animals",1);
		Card card9 = new Card ("koala", "koala", "koala", "animals",1);
		Card card10 = new Card ("panda", "panda", "panda", "animals",1);
		Card card11 = new Card ("kangaroo", "fiskangarooh", "kangaroo", "animals",1);
		
		animalDeck.add(card1);
		animalDeck.add(card2);
		animalDeck.add(card3);
		animalDeck.add(card4);
		animalDeck.add(card5);
		animalDeck.add(card6);
		animalDeck.add(card7);
		animalDeck.add(card8);
		animalDeck.add(card9);
		animalDeck.add(card10);
		animalDeck.add(card11);
		
		//test deck should only contain card 1 and 2 (animal cards) after calling the method deckByCategory
		testDeck = myDeck.deckByCategory("animals", false);
		
		for (int x = 0; x < 10; x++) {
			assertEquals(animalDeck.get(x).getWord(), testDeck.get(x).getWord());
		}
	}

}
