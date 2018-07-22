

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TravelExpenses extends Application{

	private Button button;
	private double actualExpense, carNum, lodgeNum, airNum, taxiNum, milesNum,feeNum, parkingNum, daysNum;
	private Label result;
	private Label space;
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Travel Expenses");
		
		/*
		 * prompts the user for each of the required data
		 */
		
		Label days = new Label("Days on trip.");
		Label car = new Label("Car rental cost. ");
		Label lodge = new Label("Daily Lodging cost.");
		Label air = new Label("Air Fare Cost.");
		Label taxi = new Label("Taxi Cost.");
		Label miles = new Label("miles driven.");
		Label fee = new Label("Seminar or Registration fees.");
		Label parking = new Label("Parking fees.");
		
		result = new Label();
		space = new Label();
		/*
		 * creates a text field for the user to input for each of question
		 */
		TextField daysIn= new TextField();
		TextField carIn= new TextField();
		TextField lodgeIn= new TextField();
		TextField airIn= new TextField();
		TextField taxiIn= new TextField();
		TextField milesIn= new TextField();
		TextField feeIn= new TextField();
		TextField parkingIn= new TextField();
		
		/*
		 * multiple horizontal boxes that would stack on top each other in vbox
		 */
		HBox dBox = new HBox(10, days, daysIn);
		HBox cBox = new HBox(10, car, carIn);
		HBox lBox = new HBox(10, lodge, lodgeIn);
		HBox aBox = new HBox(10, air, airIn);
		HBox tBox = new HBox(10, taxi, taxiIn);
		HBox mBox = new HBox(10, miles, milesIn);
		HBox fBox = new HBox(10, fee, feeIn);
		HBox pBox = new HBox(10, parking, parkingIn);
		
		
		/*
		 * inner class that is called when the button is pressed.
		 */
		button = new Button("Calculate");
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				daysNum = Integer.parseInt(daysIn.getText());
				carNum = Double.parseDouble(carIn.getText());
				lodgeNum = Double.parseDouble(lodgeIn.getText());
				airNum = Double.parseDouble(airIn.getText());
				taxiNum = Double.parseDouble(taxiIn.getText());
				milesNum = Double.parseDouble(milesIn.getText());
				feeNum = Double.parseDouble(feeIn.getText());
				parkingNum = Double.parseDouble(parkingIn.getText());
				
				/*
				 * Would normally create a variable for each category like taxiDiff.
				 * However, user is not prompted for amount spent on meals so I interpreted 
				 * as all the expenses together.
				 */
				actualExpense += lodgeNum + airNum + taxiNum + milesNum + feeNum + parkingNum + carNum;
				double reim = (daysNum*(37.0 + 20.0 + 40.0 + 195.0)) + milesNum * 0.42;
				double cover = actualExpense - reim;
				if(cover<0) {
					cover=0.0;
				}
				
				DecimalFormat dollar = new DecimalFormat("$#,##0.00");
				
				result.setText("Total expenses: " + dollar.format(actualExpense) + "\n" +
						"Allowable expenses: " + dollar.format(reim) + "\n" +
						"Amount to be paid back: " + dollar.format(cover));
			}
		});
		/*
		 * While initializing the vbox, I found out that more than 6 parameter causes an error.
		 * I added each Hbox into the vbox.
		 */
		VBox vbox= new VBox();
		vbox.getChildren().add(dBox);
		vbox.getChildren().add(cBox);
		vbox.getChildren().add(lBox);
		vbox.getChildren().add(aBox);
		vbox.getChildren().add(tBox);
		vbox.getChildren().add(mBox);
		vbox.getChildren().add(fBox);
		vbox.getChildren().add(pBox);
		vbox.getChildren().add(button);
		vbox.getChildren().add(result);
		vbox.getChildren().add(space);
		
		/*
		 * setting the vbox to be at the center of the scene
		 */
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));
		
		
		
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setHeight(400); // increased the height of the screen so everything fits in the scene.
		primaryStage.show(); // shows the stage

	}
	

}
