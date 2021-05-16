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

public class Scene1Controller implements Initializable {
	String welcome;

	@FXML Button welcomeButton;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void setButton(ActionEvent event) throws IOException{
		this.welcomeButton = (Button)event.getSource();
		System.out.println("We received " + welcomeButton.getText());
		this.welcome = welcomeButton.getText();
		if(welcomeButton.getText().equals("No, not right now")) {
			System.exit(0);
		}
	   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("goals.fxml"));
	   	 Parent Scene2P = loader.load();
	   	 Scene scene2 = new Scene(Scene2P);
	  // 	 Stage window = (Stage)((Node)event.getSource()).ge
	   	 
	   	 Scene2Controller controller = loader.getController();
	   	 controller.initData(welcome);
	   	 
	   	 Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 window2.setScene(scene2);
	   	 window2.show();
         
		
	}
	
	public String getData() {
		System.out.println("welcome is "+ welcome);
		return welcome;
		
	}

	
	
}
