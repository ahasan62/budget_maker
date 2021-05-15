
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("MVC.fxml"));
         Parent root = loader.load();
         Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.show();
        
      //   primaryStage.close();

    	 // loader = new FXMLLoader(getClass().getResource("MVC.fxml"));

         
         
    	

    	
    	

    	
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
// 
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//
//        Scene scene = new Scene(root, 300, 250);
//
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
 public static void main(String[] args) {
	 System.out.println("java version: "+System.getProperty("java.version"));
	 System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        launch(args);
        
        
        
    }
}
