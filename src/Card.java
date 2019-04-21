
public class Card {
	private String word;
	private String imageFileName;
	private String audioFileName;
	private String category;
	
	public Card (String word, String imageFileName, String audioFileName, String category) {
		this.word = word;
		this.imageFileName = imageFileName;
		this.audioFileName = audioFileName;
		this.category = category;
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
	
	
	
}
