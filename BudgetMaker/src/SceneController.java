
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController{
	
	
	private Label label;
	private AnchorPane scene_01;
	private Button button;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String welcome;
	private String timeSelect;
	private String budgetGoals;
	private String budgetOption;
	private String incomeFreq;
	private double taxIncome;
	
	

	
	public void WelcomeSwitchToGoals(ActionEvent event) throws IOException {
        Button welcome = (Button) event.getSource();
        System.out.println("weclome answer is " +welcome.getText());
		if(welcome.getText().equals("Not right now")) {
	        this.welcome = welcome.getText();
			System.exit(0);	
		}
		else if(welcome.getText().equals("Yes")) {
	        this.welcome = welcome.getText();
		}
		
    	Parent root = FXMLLoader.load(getClass().getResource("goals.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
		
	
	
	

	
	public void GoalsSwitchToBudgetOption(ActionEvent event) throws IOException {
        Button budgetGoalButton = (Button) event.getSource();
        
        if(!budgetGoalButton.getText().equals("go back")) {
            this.budgetGoals =  budgetGoalButton.getText();
            }
        
        System.out.println("budget Goals are " +budgetGoals);

	  	Parent root = FXMLLoader.load(getClass().getResource("budgetopt.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
		
	}
	
	public void OptionswitchToIncTime(ActionEvent event) throws IOException {
        Button budgetOpt = (Button) event.getSource();
        
        if(!budgetOpt.getText().equals("go back")) {
        this.budgetOption =  budgetOpt.getText();
        }
        System.out.println("budget Option is " + this.budgetOption);

	  	Parent root = FXMLLoader.load(getClass().getResource("Incfreq.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
		
	}
	
	public void IncTimeswitchToIncomeVal(ActionEvent event) throws IOException {
        Button IncomeTime = (Button) event.getSource();
        
        if(!IncomeTime.getText().equals("go back")) {
            this.incomeFreq =  IncomeTime.getText();
            }
        System.out.println("Payment freq is " + incomeFreq);

        System.out.println("HANDLING INCOME VAL....");
        System.out.println("HANDLING INCOME VAL....");
        System.out.println("HANDLING INCOME VAL....");
        System.out.println("HANDLING INCOME VAL....");
        
        System.out.println("weclome answer is " +this.welcome);
        System.out.println("budget Goals are " +this.budgetGoals);
        System.out.println("budget Option is " + this.budgetOption);
        System.out.println("IcomeFreq is " + this.incomeFreq);

        
        
//	  	Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
//    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	
//		
	}
	
	public void IncValwitchToExpenses(ActionEvent event) throws IOException {
        Button IncomeTime = (Button) event.getSource();
        System.out.println("Payment freq is " + IncomeTime.getText());
        this.incomeFreq =  IncomeTime.getText();
	  	Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
		
	}






}
