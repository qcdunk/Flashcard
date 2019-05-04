
public class Card {
	private String word;
	private String imageFileName;
	private String audioFileName;
	private String category;
	private int leitnerIdx; //each card would have a leitner index
	
	public Card (String word, String imageFileName, String audioFileName, String category, int leitnerIdx) {
		this.word = word;
		this.imageFileName = imageFileName;
		this.audioFileName = audioFileName;
		this.category = category;
		this.leitnerIdx = leitnerIdx; //we set the leitner index to 1 when we initially create a card
	}

	public String getWord() {
		return word;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public String getAudioFileName() {
		return audioFileName;
	}

	public String getCategory() {
		return category;
	}
	
	public int getLeitnerIdx() {
		return leitnerIdx;
	}
	
	
	
}
