import javafx.beans.property.SimpleStringProperty;

public class Income {
	

	public SimpleStringProperty incomeType;
	private double incomeVal;


	public Income(String inc, double val2) {
		// TODO Auto-generated constructor stub
		this.incomeType = new SimpleStringProperty(inc);
		this.incomeVal = val2;
	}
	
	public String getIncomeType() {
		return this.incomeType.get();
		
	}
	public double getIncomeVal() {
		return this.incomeVal;
		
	}
}
