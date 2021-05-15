import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Scene2Controller implements Initializable {
	String welcome;
	String goal;
	@FXML Button welcomeButton;
	@FXML Button goalButton;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void setButton(ActionEvent event) throws IOException{
		this.goalButton = (Button)event.getSource();
		System.out.println("in goals we received " + goalButton.getText());
		this.goal = goalButton.getText();
		
	   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("budgetopt.fxml"));
	   	 Parent Scene2P = loader.load();
	   	 Scene scene2 = new Scene(Scene2P);
	   	 
	   	 Scene3Controller controller = loader.getController();
	   	 controller.initData(welcome,goal);
	   	 
	   	 Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 window3.setScene(scene2);
	   	 window3.show();
		
	}
	
	
//	public void setButton(ActionEvent event) throws IOException{
//		this.welcomeButton = (Button)event.getSource();
//		System.out.println("We received " + welcomeButton.getText());
//		this.welcome = welcomeButton.getText();
//		
//	   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("goals.fxml"));
//	   	 Parent Scene2P = loader.load();
//	   	 Scene scene2 = new Scene(Scene2P);
//	  // 	 Stage window = (Stage)((Node)event.getSource()).ge
//	   	 
//	   	 Scene2Controller controller = loader.getController();
//	   	 controller.initData(welcome);
//	   	 
//	   	 Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
//	   	 window2.setScene(scene2);
//	   	 window2.show();
//         
//		
//	}
	
	public String getData() {
		System.out.println("welcome is "+ welcome);
		return welcome;
		
	}

	public void initData(String welcome2) {
		System.out.println("we made it to controller2!!!");
		this.welcome = welcome2;
		System.out.println("IN 2 WE RECEIVED " + welcome);
		
		
		
	}

	
	
}
