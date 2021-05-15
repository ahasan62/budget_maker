import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene6Controller implements Initializable {
String welcome,  goal, budgetOpt,  incFrequency;
	
	double income;
	
	double rent;
	double utilities;
	double food; 
	double miscellaneous;
	
	// all of the expense time combo boxes.
	
	@FXML 
	private ComboBox<String> rentComb;

	@FXML 
	private ComboBox<String> utilitiesComb;
	@FXML 
	private ComboBox<String> foodComb;

	@FXML 
	private ComboBox<String> miscComb;
	
	@FXML 
	private TextField rentVal;

	@FXML 
	private TextField utilitiesVal;
	@FXML 
	private TextField foodVal;

	@FXML 
	private TextField miscVal;
	

	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> time = FXCollections.observableArrayList("Weekly","Bi-Weekly","Monthly");
		rentComb.setItems(time);
		utilitiesComb.setItems(time);
		foodComb.setItems(time);
		miscComb.setItems(time);
		
		rentComb.getSelectionModel().selectFirst();
		utilitiesComb.getSelectionModel().selectFirst();
		foodComb.getSelectionModel().selectFirst();
		miscComb.getSelectionModel().selectFirst();

		
	}
	
	public void goToFinal(ActionEvent event) throws IOException {
		if((rentVal.getText() != null && rentVal.getText().length() > 0) && 
		(utilitiesVal.getText() != null && utilitiesVal.getText().length() > 0) &&		
		(foodVal.getText() != null && foodVal.getText().length() > 0) &&
		(miscVal.getText() != null && miscVal.getText().length() > 0) ) {

			this.rent = Double.parseDouble(rentVal.getText());
			this.utilities = Double.parseDouble(utilitiesVal.getText());
			this.food = Double.parseDouble(foodVal.getText());
			this.miscellaneous = Double.parseDouble(miscVal.getText());
		}
		
		
		else {
					this.rent = 0;
					this.utilities = 0;
					this.food =0;
					this.miscellaneous = 0;
		}
		
		
		
		
		double[] expArr = new double[4];
		expArr[0] = this.rent;
		expArr[1] = this.utilities;
		expArr[2] = this.food;
		expArr[3] = this.miscellaneous;
		
		String[] expTime = new String[4];
		expTime[0] = rentComb.getValue();
		expTime[1] = utilitiesComb.getValue();
		expTime[2] = foodComb.getValue();
		expTime[3]=  miscComb.getValue();
		

			try {
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("graph.fxml"));
			   	 Parent Scene6P = loader.load();
			   	 Scene scene6 = new Scene(Scene6P);
				
	   	 Scene7Controller controller = loader.getController();
	   	 controller.initData(welcome,goal,budgetOpt,incFrequency,income,expArr,expTime);

	   	 
	   	Stage window6 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	window6.setScene(scene6);
	   	window6.show();
	   	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	
		
	}

	public void initData(String welcome, String goal, String budgetOpt, String incFrequency, double total) {
		// TODO Auto-generated method stub
		this.welcome = welcome;
		this.goal = goal;
		this.incFrequency = incFrequency;
		this.budgetOpt = budgetOpt;
		this.income = total;
		System.out.println("In Controller 6, we passed\n");
		System.out.println(this.welcome);
		System.out.println(this.goal);
		System.out.println(this.budgetOpt);
		System.out.println(this.incFrequency);
		System.out.println(this.income);;
		
	}

}
