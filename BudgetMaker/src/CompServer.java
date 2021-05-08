
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class CompServer {
	
	public void light(ActionEvent e) throws IOException {
		System.out.println("Light Savings");
		Parent root = FXMLLoader.load(getClass().getResource("light.fxml"));
	}
	public void mod(ActionEvent e) throws IOException {
		System.out.println("Moderate Savings");
		Parent root = FXMLLoader.load(getClass().getResource("mod.fxml"));

	}
	public void extreme(ActionEvent e) throws IOException {
		System.out.println("Extreme Savings");
		Parent root = FXMLLoader.load(getClass().getResource("extr.fxml"));

	}

}
