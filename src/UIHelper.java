import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.Collections;
public class UIHelper {

	

	public static ArrayList<Card> FlashCards;
	public static int CurrentFlashCard = 0;
	public static int ExercisePoints = 0;
	public static String ActiveCategory = "";
	
	
	public static MenuBar createMenu(BorderPane border) {
		Menu menuFlashCards = new Menu("Flash Cards");
		MenuItem fcAnimals = new MenuItem("Animals");
		fcAnimals.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "animals";
		    	showFlashCards(border);
		    }
		});	
		
		MenuItem fcFood = new MenuItem("Food");
		fcFood.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "food";
		    	showFlashCards(border);
		    }
		});
		MenuItem fcPeople = new MenuItem("People");
		fcPeople.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "people";
		    	showFlashCards(border);
		    }
		});
		MenuItem fcNature = new MenuItem("Nature");
		fcNature.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "nature";
		    	showFlashCards(border);
		    }
		});
		menuFlashCards.getItems().add(fcAnimals);
		menuFlashCards.getItems().add(fcFood);
		menuFlashCards.getItems().add(fcPeople);
		menuFlashCards.getItems().add(fcNature);

		Menu menuExercises = new Menu("Exercises");
		MenuItem exRandom = new MenuItem("Random");
		MenuItem exAnimals = new MenuItem("Animals");
		exAnimals.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "animals";
		    	showDrillCards(border);
		    }
		});
		MenuItem exFood = new MenuItem("Food");
		exFood.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "food";
		    	showDrillCards(border);
		    }
		});
		MenuItem exPeople = new MenuItem("People");
		exPeople.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "people";
		    	showDrillCards(border);
		    }
		});
		MenuItem exNature = new MenuItem("Nature");
		exNature.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ActiveCategory = "nature";
		    	showDrillCards(border);
		    }
		});
		menuExercises.getItems().add(exRandom);
		menuExercises.getItems().add(exAnimals);
		menuExercises.getItems().add(exFood);
		menuExercises.getItems().add(exPeople);
		menuExercises.getItems().add(exNature);
		
		Menu menuHelp = new Menu("Help");
		
		MenuBar menuBar = new MenuBar();		
		menuBar.getMenus().addAll(menuFlashCards, menuExercises, menuHelp);
		
		return menuBar;
	}
	
	
	
	
	public static void showFlashCards(BorderPane border) {
		Deck d = new Deck();
		FlashCards = d.deckByCategory(ActiveCategory, true);
		CurrentFlashCard = 0;
    	VBox center = UIHelper.BuildFlashCard(border, FlashCards.get(CurrentFlashCard));
		border.setCenter(center);
	}
	
	
	public static void showDrillCards(BorderPane border) {
		Deck d = new Deck();
    	FlashCards = d.deckByCategory(ActiveCategory, true);
		CurrentFlashCard = 0;
		ExercisePoints = 0;
		ArrayList<Card> choices = d.choicesByCategory(FlashCards.get(CurrentFlashCard), ActiveCategory, true);
    	VBox center = UIHelper.BuildDrillCard(border, FlashCards.get(CurrentFlashCard), choices);
		border.setCenter(center);
		
	}
	
	
	
	public static VBox BuildFlashCard(BorderPane border, Card word) {
		
		
		Image CardImage;
		ImageView CardImageView;	
		File CardImageFile;
		Text CardText;
		
		// create a vertical box container, which will be loaded into the center area
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        
        // a button to load a new card
        Button btn = new Button();
        btn.setText("Next");
        btn.setFont(new Font(24));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (CurrentFlashCard < FlashCards.size()-2) {
        			CurrentFlashCard++;
        		} else {
        			// re-shuffle/reset
        			CurrentFlashCard = 0;
        			Collections.shuffle(FlashCards);
        		}
            	border.setCenter(UIHelper.BuildFlashCard(border, FlashCards.get(CurrentFlashCard)));
				
            }
        });        
        
          
        
        CardText = new Text(10, 50, word.getWord().toLowerCase());
        CardText.setFont(new Font(48));
        CardText.setWrappingWidth(300);
        CardText.setTextAlignment(TextAlignment.CENTER);
        
        
        // defaults
        CardImageFile = new File("src/static/images/" + word.getWord().toLowerCase() + ".jpg");
        CardImage = new Image(CardImageFile.toURI().toString(), 300, 0, true, false);
        CardImageView = new ImageView();
        CardImageView.setImage(CardImage);
        DropShadow ds = new DropShadow(5, Color.BLACK);
        CardImageView.setEffect(ds);
        CardImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		    	 System.out.println("Image clicked");
		    	 Media sound = new Media(new File("src/static/audio/" + word.getWord().toLowerCase()+ ".mp3").toURI().toString());
		    	 MediaPlayer mediaPlayer = new MediaPlayer(sound);
		    	 mediaPlayer.play();
		         event.consume();
		     }
		});
        
        
        
        
        vb.getChildren().add(CardText);
        vb.getChildren().add(CardImageView);        
        vb.getChildren().add(btn);       
           
        VBox.setMargin(CardImageView, new Insets(20, 0, 20, 0));  // 20px padding above/below
        
        return vb;

	}
	
	
	
	public static VBox BuildDrillCard(BorderPane border, Card word, ArrayList<Card> options) {
		
		// create a vertical box container, which will be loaded into the center area
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        
        Text CardText;
        CardText = new Text(10, 30, word.getWord().toLowerCase());
        CardText.setFont(new Font(48));
        CardText.setWrappingWidth(300);
        CardText.setTextAlignment(TextAlignment.CENTER);
        vb.getChildren().add(CardText);
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 20, 20, 40));
        flow.setVgap(20);
        flow.setHgap(20);
        flow.setPrefWrapLength(150); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");
        
        
        for(int i=0; i< options.size(); i++) {
        	Image CardImage;
    		ImageView CardImageView;	
    		File CardImageFile;
    		String optionWord = options.get(i).getWord();
        	
        	// defaults
            CardImageFile = new File("src/static/images/" + optionWord.toLowerCase() + ".jpg");
            CardImage = new Image(CardImageFile.toURI().toString(), 150, 0, true, false);
            CardImageView = new ImageView();
            CardImageView.setImage(CardImage);
            DropShadow ds = new DropShadow(2, Color.BLACK);
            CardImageView.setEffect(ds);
            CardImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    		     @Override
    		     public void handle(MouseEvent event) {
    		    	 
    		    	 ImageView iv = (ImageView)event.getSource();
    		    	 String imagePath = iv.getImage().impl_getUrl();
    		    	 // IF CORRECT, ADD POINTS, HIDE INCORRECT CHOICES, PLAY SPEECH "CORRECT! [WORD]", 
    		    	 if (imagePath.contains(FlashCards.get(CurrentFlashCard).getImageFileName())) {
    		    		 System.out.println("CORRECT");
    		    		 Media soundCorrectSound = new Media(new File("src/static/audio/correct_sound.wav").toURI().toString());
    		    		 Media soundCorrect = new Media(new File("src/static/audio/correct.mp3").toURI().toString());
    			    	 Media soundWord = new Media(new File("src/static/audio/" + word.getWord().toLowerCase()+ ".mp3").toURI().toString());
    			    	 
    			    	 ObservableList<Media> mediaList = FXCollections.observableArrayList();
    			         mediaList.addAll(soundCorrectSound, soundCorrect, soundWord);
    			    	 playSounds(mediaList);     			    	      
    		    		 ExercisePoints++;
    		    	 }
    		    	 else {
    		    	 // IF INCORRECT, HIDE INCORRECT CHOICES, PLAY SPEECH "INCORRECT, [WORD]"
    		    		 System.out.println("INCORRECT"); 
    		    		 Media soundIncorrectSound = new Media(new File("src/static/audio/incorrect_sound.wav").toURI().toString());
    		    		 Media soundIncorrect = new Media(new File("src/static/audio/incorrect.mp3").toURI().toString());
    			    	 Media soundWord = new Media(new File("src/static/audio/" + word.getWord().toLowerCase()+ ".mp3").toURI().toString());
    			    	 
    			    	 ObservableList<Media> mediaList = FXCollections.observableArrayList();
    			         mediaList.addAll(soundIncorrectSound, soundIncorrect, soundWord);
    			    	 playSounds(mediaList); 
    		    	 }
    		    	 
    		    	 
    		    	 
    		    	 
    		    	 if (CurrentFlashCard < FlashCards.size()-2) {
    	        			CurrentFlashCard++;
    	        			
        	            	Deck d = new Deck();
        					ArrayList<Card> choices = d.choicesByCategory(FlashCards.get(CurrentFlashCard), ActiveCategory, true);
        			    	VBox center = UIHelper.BuildDrillCard(border, FlashCards.get(CurrentFlashCard), choices);
        					border.setCenter(center);
	        		 } else {
		        			// HIDE CHOICES
		        			//flow.getChildren().remove(0, 3);
		        			// SHOW FINAL SCORE
		        			System.out.println("Points: " + ExercisePoints);
		        			System.out.println("Total Cards: " + (CurrentFlashCard+1)); 
		        			double score = ((ExercisePoints+0.0)/(CurrentFlashCard+1))*100;
		        			DecimalFormat df = new DecimalFormat("###");
		        			String stringScore = df.format(score);
		        			
		        			Alert alert = new Alert(AlertType.INFORMATION);
		        			alert.setTitle("Information Dialog");
		        			alert.setHeaderText(null);
		        			alert.setContentText("Your score is... " +  stringScore + "%");
	
		        			alert.showAndWait();
	        		 }
    	            	
    	            	
    	            	
    	            	
    		     }
    		});
            
        	
            
        	flow.getChildren().addAll(CardImageView);
        }
        
        
        VBox.setMargin(flow, new Insets(20, 0, 20, 0));  // 20px padding above/below
        vb.getChildren().add(flow);
        
        return vb;
		
	}

	
	private static void playSounds(ObservableList<Media> mediaList) {
        if (mediaList.size() == 0)
            return;

        MediaPlayer mediaplayer = new MediaPlayer(mediaList.remove(0));
        mediaplayer.play();

        mediaplayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                playSounds(mediaList);
            }
        });
    }
	
}