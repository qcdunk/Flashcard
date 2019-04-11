import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Launcher extends Application {
	
	@Override
    public void start(Stage primaryStage) {
        // border pane is the outermost container (has top, bottom, left, right, and center areas)
        BorderPane border = new BorderPane();
        
        // create the menu bar and place it into the top area of the border pane
        // other functionality is driven from selections in the menuBar
		MenuBar menuBar = UIHelper.createMenu(border);
		border.setTop(menuBar);
		
		// this is the main window
        Scene scene = new Scene(border, 400, 500);
        primaryStage.setTitle("Learn English");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
    }
	 
	 
	public static void main(String[] args) {
        
		// launch is inherited from JavaFX's Application object
		launch(args);
	}
	

}