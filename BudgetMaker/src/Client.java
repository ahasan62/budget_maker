import java.util.Scanner;  // Import the Scanner class

import javafx.application.Application;
public class Client {
	
	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter Financial Goal: ");
	    String fin_goal = myObj.nextLine();  // Read user input
	    System.out.println("What is your weekly income?: ");
	    double income = myObj.nextInt();
	    System.out.println("What is your rent expense? ");
	    double housing = myObj.nextInt();
	    System.out.println("What is your food expense? ");
	    double food = myObj.nextInt();
	    System.out.println("What is your misc. expense? ");
	    double misc = myObj.nextInt();
	    
	    if(fin_goal.equals("Limited")) {
	    	Limited lim = new Limited(); 
	    	 housing = lim.idealRentBudget() * housing;
	    	 food = lim.idealfoodBudget() * food;
	    	 misc = lim.idealmiscBudget() * misc;
	    	 
	    	 System.out.println("You should spend " + housing + " on rent");
	    	 System.out.println("You should spend " + food + " on food");
	    	 System.out.println("You should spend " + misc + " on misc");


	    }


		
		
	}

}
