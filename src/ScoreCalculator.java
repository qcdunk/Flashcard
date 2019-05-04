import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreCalculator {
	/*	
	 * Percentage of occurence of cards during the excercise activity
	 * index 1 = 100%
	 * index 2 = 60%
	 * index 3 = 30%
	 * 	
	 */
	
	/**
	 * This method is called right after the user makes a selection during the exercise multiple choice activity 
	 * to update the leitner score for each card
	 * @param selection
	 * @param word
	 * @param idx
	 */
	public void adjustIndex(boolean selection, String word, String category, int idx) {
		//if user selected the correct card
		if (selection == true && idx != 3) {
			idx = idx + 1;
			//here we update the file with the new leitner index
			updateFile(word, category,idx);
		}
		
		//if wrong selection
		if (idx != 1 && selection == false) {
			idx = idx - 1;
			updateFile(word, category, idx);
		}
	}
	
	/**
	 * method used to repla
	 * @param word
	 * @param category
	 * @param idx
	 */
	public void updateFile (String word, String category, int idx) {
		//here we search and update file with new leitener indx
	    try {
	        // input the file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader("cards"));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();
	        String inputStr = inputBuffer.toString();
	        
	        //here we extract the first word of the line - the card name
	        int position = inputStr.indexOf(",");
	        String cardName = null;
	        if (position != -1) {
	        	cardName = inputStr.substring(0, position);
	        }
	        
	        //update the leitner index of the card
	        if (cardName.equals(word)) {
	        	inputStr = inputStr.replace(inputStr, word+","+category+","+idx);
	        }

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("cards");
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }

    }
	
}
