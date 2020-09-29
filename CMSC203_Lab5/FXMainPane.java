import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */

public class FXMainPane extends VBox {

	Button button1 = new Button("Hello");
	Button button2 = new Button("Howdy");
	Button button3 = new Button("Chinese");
	Button button4 = new Button("Clear");
	Button button5 = new Button("Exit");
	Label label = new Label("Feedback");
	TextField textField = new TextField();

	HBox hBox1 = new HBox();
	HBox hBox2 = new HBox();

	DataManager datum= new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {

				
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());

		hBox1.getChildren().addAll(button1,button2,button3,button4,button5);

		hBox2.getChildren().addAll(label,textField);

		getChildren().addAll(hBox1,hBox2);
	}
	
	
	class ButtonHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent event)
		{
			if(event.getTarget() == button1) {
				textField.setText(datum.getHello());
				
			}
			else if(event.getTarget() == button2) {
				textField.setText(datum.getHowdy());
			}
			else if(event.getTarget() == button3) {
				textField.setText(datum.getChinese());
			}
			else if(event.getTarget() == button4) {
				textField.setText("");
			}
			else if(event.getTarget() == button5) {
				Platform.exit();
				System.exit(0);
			}
		}
	}

}
	
