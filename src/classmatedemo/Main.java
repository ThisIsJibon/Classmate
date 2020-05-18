package classmatedemo;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       Pane root= new Pane();
       root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
       Scene scene = new Scene(root);
       Stage window=new Stage();
       window.setScene(scene);
       window.setTitle("Please Login");
       window.show();   
       
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
