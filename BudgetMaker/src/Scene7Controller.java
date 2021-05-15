
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.sun.jdi.connect.spi.Connection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Scene7Controller implements Initializable {
String welcome,  goal, budgetOpt,  incFrequency;

	
	double income;
	double[] expArr;
	String[] expTime;
	@FXML
	private Label conc;
	
    @FXML
    private BarChart<String, Double> NetChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    

	
	public void createDisplay(ActionEvent event) {
		NetChart.getData().clear();

//		CompServer dataSender = new CompServer(String welcome, String goal, String budgetOpt, String incFrequency, double income, double[] expArr, String[] expTime);
		// TODO Auto-generated method stub
//		XYChart.Series  set1 = new XYChart.Series<>();
//		System.out.println("income is "+ income);
//		set1.getData().add(new XYChart.Data("Income",this.income));
//		
//		NetChart.getData().addAll(set1);
//		XYChart.Series series = new XYChart.Series<>();
//		series.setName("Device");
//		series.getData().add(new XYChart.Data("Income",23));
//		series.getData().add(new XYChart.Data("exp",54));
		

		
		//process goal, budgetOpt, incFrequency, to getIdeal Expenditure.

		
		// GOAL: focus, moderate or no focus? 
		// budgOption: Monthly or Weekly budget?
		// IncFreq: when are you paid? 
		// income: what is your income?
		// expArr: all the cost of expenses. Order is as follows:
		
		//		expArr[0] = this.rent;
		//		expArr[1] = this.utilities;
		//		expArr[2] = this.food;
		//		expArr[3] = this.miscellaneous;
		
		//expTime: all the TIME of each expArr[i]. Order is same.
		
		
		//budgetOption---> Normalize(budgetOption) [income, expenses]  ---> 
////////////////////////////////////////////////////////////////////////////////////////////////////	
		if(budgetOpt.equals("Weekly")) {
				for(int i = 0; i < expTime.length;i++) {
					if(!expTime[i].equals("Weekly")) {
						if(expTime[i].equals("Bi-Weekly")) {
							expArr[i] = expArr[i] / 2;
							expTime[i] = "Weekly";
						}
						else {
							expArr[i] = expArr[i] / 4;
							expTime[i] = "Weekly";
						}

					}
				}
				
				if(incFrequency.equals("once every other week")) {
					income = income /2;
					
				}
				if(incFrequency.equals("once a month")) {
					income = income /4;
					
				}
				
		}
		else if(budgetOpt.equals("Monthly")) {
			for(int i = 0; i < expTime.length;i++) {
				if(!expTime[i].equals("Monthly")) {
					if(expTime[i].equals("Bi-Weekly")) {
						expArr[i] = expArr[i] * 2;
						expTime[i] = "Weekly";
					}
					else {
						expArr[i] = expArr[i]  * 4;
						expTime[i] = "Weekly";
					}

				}
			}
			if(incFrequency.equals("once every other week")) {
				income = income * 2 ;
				
			}
			if(incFrequency.equals("once a week")) {
				income = income * 4;
				
			}
		
		
		}
		
	
		double idealRentBudget = 0;
		double idealUtilBudget = 0;
		double idealFoodBudget = 0;
		double idealMiscBudget = 0;

		if(this.goal.equals("Focus on savings")) {
			idealRentBudget = this.income * 0.35;
			idealUtilBudget = this.income * 0.10;
			idealFoodBudget = this.income * 0.20;
			idealMiscBudget = this.income * 0.10;
		}
		else if(this.goal.equals("Moderately focus on savings")) {
			idealRentBudget = this.income * 0.35;
			idealUtilBudget = this.income * 0.10;
			idealFoodBudget = this.income * 0.25;
			idealMiscBudget = this.income * 0.15;
			
		}
		else {
			idealRentBudget = this.income * 0.35;
			idealUtilBudget = this.income * 0.10;
			idealFoodBudget = this.income * 0.25;
			idealMiscBudget = this.income * 0.25;
			
		}
		
		XYChart.Series<String,Double> series = new XYChart.Series<>();
		series.setName("Current Budget");
		series.getData().add(new XYChart.Data("Rent",expArr[0]));
		series.getData().add(new XYChart.Data("Utilities",expArr[1]));
		series.getData().add(new XYChart.Data("Food",expArr[2]));
		series.getData().add(new XYChart.Data("Miscellaneous",expArr[3]));
		XYChart.Series<String,Double> series2 = new XYChart.Series<>();
		series2.setName("Ideal Budget");

		series2.getData().add(new XYChart.Data("Rent",idealRentBudget));
		series2.getData().add(new XYChart.Data("Utilities",idealUtilBudget));
		series2.getData().add(new XYChart.Data("Food",idealFoodBudget));
		series2.getData().add(new XYChart.Data("Miscellaneous",idealMiscBudget));
		NetChart.setLegendVisible(false);

	    NetChart.getData().addAll(series,series2);


//		// WILL DELETE
//		XYChart.Series<String,Double> series = new XYChart.Series<>();
//		series.setName("Current Budget");
//
//		
//		series.getData().add(new XYChart.Data("Income",35));
//	
//		XYChart.Series<String,Double> series2 = new XYChart.Series<>();
//		series2.setName("Ideal Budget");
//		
//		series2.getData().add(new XYChart.Data("Expenses",50));
//	    NetChart.getData().addAll(series,series2);

	    String good = "-fx-bar-fill: green;";
	    String bad = "-fx-bar-fill: red;";
	    String[] colorInd = new String[4];

	    colorInd[0] = good;
	    colorInd[1] = good; 
	    colorInd[2] = good; 
	    colorInd[3] = good;
	    String texttoReturn = "";
	    String careful = "Woah, you are over the ideal budget for";
	    if(expArr[0] > idealRentBudget) {
	    	colorInd[0] = bad;
	    	careful += " Rent, ";
	    }
	    if(expArr[1] > idealUtilBudget) {
	    	colorInd[1] = bad;
	    	careful += " Utilities, ";

	    }
	    if(expArr[2] > idealFoodBudget) {
	    	colorInd[2] = bad;
	    	careful += " Food, ";

	    }
	    if(expArr[3] > idealMiscBudget) {
	    	colorInd[3] = bad;
	    	careful += "and Miscillaneous Items!";

	    }
	    
	    else {
	    	careful = "Great Job! You are under the ideal budget for all your expenses!";
	    }
	    
	    int counter = 0;
	    for(Data<String,Double> data: series.getData()) {
	    	Node node = data.getNode();
	    	node.setStyle(colorInd[counter]);
	    	counter++;
	    }
	    
	    int count = 0;
	    for(Data<String,Double> data2: series2.getData()) {
	    	Node node = data2.getNode();
	    	if(colorInd[count].equals(good)) {
	    		node.setStyle("-fx-bar-fill: black;");
	    	} 
	    	else {
	    		node.setStyle("-fx-bar-fill: black;");
	    	}
	    	count++;
	    }

	    
	    conc.setText(careful);
		
	}

	    
		
	     
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
//		XYChart.Series series = new XYChart.Series<>();
//		series.setName("I vs C");
//		series.getData().add(new XYChart.Data("Income",0));
//		series.getData().add(new XYChart.Data("exp",0));
//		
//		NetChart.getData().add(series);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void initData(String welcome, String goal, String budgetOpt, String incFrequency, double income, double[] expArr, String[] expTime) {
		this.welcome = welcome; 
		this.goal = goal;
		this.budgetOpt = budgetOpt;
		this.incFrequency = incFrequency;
		this.income = income;
		this.expArr = expArr;
		this.expTime = expTime;
		System.out.println("In Controller 7, we passed\n");
		System.out.println(welcome);
		System.out.println(goal);
		System.out.println(budgetOpt);
		System.out.println(incFrequency);
		System.out.println(income);

		System.out.println(expArr.toString());
		System.out.println(expTime.toString());

		
	}

}
