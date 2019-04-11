import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class UIHelper {

	
	public static Image CardImage;
	public static ImageView CardImageView;	
	public static File CardImageFile;
	public static Text CardText;
	
	
	public static MenuBar createMenu(BorderPane border) {
		Menu menuFlashCards = new Menu("Flash Cards");
		MenuItem fcAnimals = new MenuItem("Animals");
		fcAnimals.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	VBox center = UIHelper.BuildFlashCardsContainer();
				border.setCenter(center);
		    }
		});
		
		
		
		MenuItem fcFood = new MenuItem("Food");
		MenuItem fcPeople = new MenuItem("People");
		MenuItem fcNature = new MenuItem("Nature");
		menuFlashCards.getItems().add(fcAnimals);
		menuFlashCards.getItems().add(fcFood);
		menuFlashCards.getItems().add(fcPeople);
		menuFlashCards.getItems().add(fcNature);

		Menu menuExercises = new Menu("Exercises");
		MenuItem exRandom = new MenuItem("Random");
		MenuItem exAnimals = new MenuItem("Animals");
		MenuItem exFood = new MenuItem("Food");
		MenuItem exPeople = new MenuItem("People");
		MenuItem exNature = new MenuItem("Nature");
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
	
	
	
	
	public static VBox BuildFlashCardsContainer() {
		// create a vertical box container, which will be loaded into the center area
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        
        // a button for fun
        Button btn = new Button();
        btn.setText("Next");
        btn.setFont(new Font(24));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	UIHelper.displayCard("CAT");
                System.out.println("Hello World!");
            }
        });        
        
        CardText = new Text(10, 50, "horse");
        CardText.setFont(new Font(48));
        CardText.setWrappingWidth(300);
        CardText.setTextAlignment(TextAlignment.CENTER);
        
        
        CardImageFile = new File("src/static/images/horse.jpg");
        CardImage = new Image(CardImageFile.toURI().toString(), 300, 0, true, false);
        CardImageView = new ImageView();
        CardImageView.setImage(CardImage);
        DropShadow ds = new DropShadow(5, Color.BLACK);
        CardImageView.setEffect(ds);
        
        
        vb.getChildren().add(CardText);
        vb.getChildren().add(CardImageView);
        vb.getChildren().add(btn);       
           
        VBox.setMargin(CardImageView, new Insets(20, 0, 20, 0));  // 20px padding above/below
        
        return vb;

	}
	
	
	
	public static void BuildExercisesContainer() {
		
	}
	
	
	// this method will display a new Flash Card based on a key passed in
	// the key drives both the text and the image to be displayed
	public static void displayCard(String cardKey) {
		switch(cardKey) {
			case "HORSE":
				CardImageFile = new File("src/static/images/horse.jpg");
				CardText.setText("horse");
				break;
			case "CAT":
				CardImageFile = new File("src/static/images/cat.jpg");
				CardText.setText("cat");				
				break;
		}
		
		CardImage = new Image(CardImageFile.toURI().toString(), 300, 0, true, false);
		CardImageView.setImage(CardImage);
	}
	
	
}