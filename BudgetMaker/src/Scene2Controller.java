
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

public class Scene2Controller implements Initializable {
	
	
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



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
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

	
	
}