
import java.awt.Label;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Scene3Controller implements Initializable {

	private String welcome;
	String goal;
	String budgetOpt;
	@FXML Button optButton;
	
	
	
	public void setButton(ActionEvent event) throws IOException{
		this.optButton = (Button)event.getSource();
		System.out.println("in budgetopt we received " + optButton.getText());
		this.budgetOpt = optButton.getText();
		
	   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Incfreq.fxml"));
	   	 Parent Scene3P = loader.load();
	   	 Scene scene3 = new Scene(Scene3P);
	   	 
	   	 Scene4Controller controller = loader.getController();
	   	 controller.initData(welcome,goal,budgetOpt);
	   	 
	   	 Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 window3.setScene(scene3);
	   	 window3.show();
		
	}


	

	public void initData(String welcome, String goal) {
		System.out.println("We made it to controller 3!!!!");
		this.welcome = welcome;
		this.goal = goal;
		System.out.println("In Controller 3, we passed\n");
		System.out.println(this.welcome);
		System.out.println(this.goal);


		
	}






















	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
