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
import javafx.stage.Stage;

public class Scene4Controller  implements Initializable {

	String welcome;
	String goal;
	String budgetOpt;
	String incFrequency;
	@FXML Button incFreqButton;
	

	public void setButton(ActionEvent event) throws IOException{
		this.incFreqButton = (Button)event.getSource();
		System.out.println("in incFreq we received " + incFreqButton.getText());
		this.incFrequency = incFreqButton.getText();
		
	   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("incval.fxml"));
	   	 Parent Scene4P = loader.load();
	   	 Scene scene4 = new Scene(Scene4P);
	   	 
	   	 Scene5Controller controller = loader.getController();
	   	 controller.initData(welcome,goal,budgetOpt,incFrequency);
	   	 
	   	 Stage window4 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	window4.setScene(scene4);
	   	window4.show();
		
	}
	
	
	public void initData(String welcome, String goal, String budgetOpt) {
		System.out.println("We made it to controller 4!!!!");
		this.welcome = welcome;
		this.goal = goal;
		this.budgetOpt = budgetOpt;
		System.out.println("In Controller 4, we passed\n");
		System.out.println(this.welcome);
		System.out.println(this.goal);
		System.out.println(this.budgetOpt);


		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
