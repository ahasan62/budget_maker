import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.sun.jdi.connect.spi.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Scene5Controller implements Initializable {
	
	String welcome,  goal, budgetOpt,  incFrequency;
	
	double income;
	
	private Label label;
	@FXML
	private TextField tfStream;
	@FXML
	private TextField tfAmount;
	@FXML
	private TableView<Income> Income;
	@FXML 
	private TableColumn<Income, String> type;
	@FXML 
	private TableColumn<Income, Double> revenue;
	@FXML 
	private Button btnInsert;
	private Button btnDel;

	@FXML TextField totalVal;
	
	
	public void handleAddButton(ActionEvent event) {
		if((tfAmount.getText() != null && tfAmount.getText().length() > 0) && (tfStream.getText() != null && tfStream.getText().length() > 0)) {
		String inc = tfStream.getText();
		double val;
		val = Double.parseDouble(tfAmount.getText());
	
		System.out.println(inc);
		System.out.println(val);
		Income income = new Income(inc,val);
			Income.getItems().add(income);
			tfStream.clear();
			tfAmount.clear();
		}
		
	}
	
	public void handleDelButton(ActionEvent event) {
		
		Income.getItems().removeAll(Income.getSelectionModel().getSelectedItems());
		
		
	}
	public void totalIncomeDisplay(ActionEvent event) throws IOException {
		double total = 0;
		for (Income income : Income.getItems()) {
		    total += income.getIncomeVal();
		}
		
		this.totalVal.setText(Double.toString(total));
		this.income = total;
		
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("expensesval.fxml"));
	   	 Parent Scene5P = loader.load();
	   	 Scene scene5 = new Scene(Scene5P);
	   	 
	   	 Scene6Controller controller = loader.getController();
	   	 controller.initData(welcome,goal,budgetOpt,incFrequency,total);
	   	 
	   	 Stage window5 = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	window5.setScene(scene5);
	   	window5.show();
	   	
		
	}
	
	
	
	
//	
//	 */
//	 public class ExampleOfTableViewController implements Initializable {
//
//	     //configure the table
//	     @FXML private TableView<Person> tableView;
//	     @FXML private TableColumn<Person, String> firstNameColumn;
//	     @FXML private TableColumn<Person, String> lastNameColumn;
//	     @FXML private TableColumn<Person, LocalDate> birthdayColumn;
//	     
//	     //These instance variables are used to create new Person objects
//	     @FXML private TextField firstNameTextField;
//	     @FXML private TextField lastNameTextField;
//	     @FXML private DatePicker birthdayDatePicker;
//	     
//	     @FXML private Button detailedPersonViewButton;
//	
//	
	
	
	
	
	

	public void initData(String welcome, String goal, String budgetOpt, String incFrequency) {

		this.welcome = welcome;
		this.goal = goal;
		this.budgetOpt = budgetOpt;
		this.incFrequency = incFrequency;
		System.out.println("In Controller 5, we passed\n");
		System.out.println(this.welcome);
		System.out.println(this.goal);
		System.out.println(this.budgetOpt);
		System.out.println(this.incFrequency);

	}
	
	ObservableList<Income> getIncomeList(){
		ObservableList<Income> incomes = FXCollections.observableArrayList();
		return incomes;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		type.setCellValueFactory(new PropertyValueFactory<Income, String>("incomeType"));
		revenue.setCellValueFactory(new PropertyValueFactory<Income, Double>("incomeVal"));
		Income.setItems(getIncomeList());
		
	}
}
