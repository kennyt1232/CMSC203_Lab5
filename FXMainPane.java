


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
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	
	//  declare two HBoxes
	
	Button Hello;
	Button Howdy;
	Button Chinese;
	Button Clear;
	Button Exit;
	
	Label Feedback;
	
	TextField Section;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager X;
	/**
	 
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	

	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		Hello = new Button ("Hello");
		Howdy = new Button ("Howdy");
		Chinese = new Button ("Chinese");
		Clear = new Button ("Clear");
		Exit = new Button ("Exit");
		
		Feedback = new Label ("Feedback");
		Section = new TextField();
		
		HBox DisplayBox = new HBox();
		
		HBox ButtonBox = new HBox();
	
		Insets set = new Insets (10);
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		X = new DataManager();	
		class ButtonHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			if(event.getTarget() == Hello) {
				Section.setText(X.getHello());
			}
			else if (event.getTarget() == Howdy ) {
				Section.setText(X.getHowdy());
			}
			else if (event.getTarget() == Chinese ) {
				Section.setText(X.getChinese());
			}
			
			else if (event.getTarget() == Clear) {
				Section.setText("");
			}
			else if (event.getTarget() == Exit ) {
				System.exit(0);
				
			}
			
		}
		}
		ButtonHandler allign = new ButtonHandler();
		
		Hello.setOnAction(allign);
		Howdy.setOnAction(allign);
		Chinese.setOnAction(allign);
		Clear.setOnAction(allign);
		Exit.setOnAction(allign);
	
		
		
		HBox.setMargin(Hello, set);
		HBox.setMargin(Howdy, set);
		HBox.setMargin(Chinese, set);
		HBox.setMargin(Clear, set);
		HBox.setMargin(Exit, set);
		
		DisplayBox.setAlignment(Pos.CENTER);
		ButtonBox.setAlignment(Pos.CENTER);
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		DisplayBox.getChildren().addAll(Feedback,Section);
		ButtonBox.getChildren().addAll(Hello, Howdy, Chinese, Clear, Exit);
		this.getChildren().addAll(DisplayBox, ButtonBox);
	
	
		
		
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
}
	