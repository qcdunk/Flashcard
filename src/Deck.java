import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
	//create an empty ArrayList of the Card object
	private ArrayList<Card> flashCards = new ArrayList <Card>();

	public ArrayList<Card> getFlashCards() {
		return flashCards;
	}
	
	/*
	 * the deck constructor will read from a file named "cards"
	 * and creates a deck of cards based on inputs in the file
	 */
	public Deck () {
		File f = new File ("cards");
		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				//read lines in
				String Row = scanner.nextLine();
				
				String[] columnData = Row.split(",");
				
				//here we parsed data and store in a card object
				String cardName = columnData[0];
				String category = columnData[1];
				int idx =  Integer.parseInt(columnData[2]);
				Card card = new Card (cardName, cardName, cardName, category, idx);
				//adding card object to a list, forming a deck
				flashCards.add(card);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//the following method shuffles the arrayList of cards
	public void shuffleDeck(Deck myDeck) {
		Collections.shuffle(myDeck.getFlashCards());
	}
	
	//method to return a deck of cards from the animal category
	public ArrayList<Card> deckByCategory(String category, boolean shuffleDeck) {
		ArrayList<Card> cardsByCategory = new ArrayList<Card>();
		
		//here we assign cards from a particular category to a new deck of cards
		for (Card card : flashCards) {
			if (card.getCategory().equals(category)) {
				cardsByCategory.add(card);
			}
		}
		
		if (shuffleDeck) {
			Collections.shuffle(cardsByCategory);
		}
		
		return cardsByCategory;
	}
	
	//method to return 4 exercise choice options from a category
	public ArrayList<Card> choicesByCategory(Card activeCard, String category, boolean shuffleDeck) {
		ArrayList<Card> cardsByCategory = new ArrayList<Card>();
		
		for (Card card : flashCards) {
			if (card.getCategory().equals(category) && card.getWord().equals(activeCard.getWord()) == false) {
				cardsByCategory.add(card);
			}
		}
		
		// pre-shuffle without active card
		Collections.shuffle(cardsByCategory);
		// pull 3 random cards
		ArrayList<Card> newCards = new ArrayList<Card>(cardsByCategory.subList(0, 3));
		newCards.add(activeCard);
		// post-shuffle with active card
		Collections.shuffle(cardsByCategory);
		
		return newCards;
	}
	
}
