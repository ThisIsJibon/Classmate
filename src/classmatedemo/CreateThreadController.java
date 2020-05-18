/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CreateThreadController implements Initializable {

    @FXML
    private JFXTextField threadNameField;
    @FXML
    private JFXPasswordField threadPasswordField;
    @FXML
    private JFXButton nowCreateThreadButton;
    @FXML
    private JFXButton cancelThreadButton;
    @FXML
    private JFXTextField threadYearField;
    @FXML
    private TextField threadDescField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nowCreateThreadButtonAction(ActionEvent event) {
       
        String threadname = threadNameField.getText();
        String threadpass = threadPasswordField.getText();
        String threadyear = threadYearField.getText();
        String description = threadDescField.getText();
        String thread_id = threadNameField.getText()+"-"+threadYearField.getText();
        
        JdbcDao jdbc = new JdbcDao();
        jdbc.insertRecord(threadname,threadpass,threadyear,description,thread_id);


    }

    @FXML
    private void cancelThreadButtonAction(ActionEvent event) {
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.close();
    }
    
}
