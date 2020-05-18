/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ManageThreadController implements Initializable {

    @FXML
    private JFXTextField userRegistrationField;
    @FXML
    private JFXButton addUserButton;
    @FXML
    private JFXButton removeUserButton;
    @FXML
    private TextField updateDescriptionField;
    @FXML
    private JFXTextField threadNameField;
    @FXML
    private JFXButton closeButton;
    @FXML
    private JFXPasswordField threadPassField;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXTextField threadYearField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addUserButtonAction(ActionEvent event) throws IOException {

        if(threadNameField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter your Thread Name");
            alert.show();
        }

        if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        if(userRegistrationField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Registration Number");
            alert.show();
        }
        if(threadPassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Password");
            alert.show();
        }

        String threadname = threadNameField.getText();
        String threadyear = threadYearField.getText();
        String threadpass = threadPassField.getText();
        String reg = userRegistrationField.getText();

        if(JdbcDao.checkthread(threadname,threadyear,threadpass)){
            JdbcDao jdbc = new JdbcDao();
            jdbc.insertRecord(threadname+"-"+threadyear,reg);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter all Information correctly");
            alert.show();
        }

    }

    @FXML
    private void removeUserButtonAction(ActionEvent event) throws IOException {

        if(threadNameField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter your Thread Name");
            alert.show();
        }

        if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        if(threadPassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Password");
            alert.show();
        }
        if(userRegistrationField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Registration Number");
            alert.show();
        }

        String threadname = threadNameField.getText();
        String threadpass = threadPassField.getText();
        String threadyear = threadYearField.getText();
        String reg = userRegistrationField.getText();

        if(JdbcDao.check_man_thread(threadname+"-"+threadyear,reg)&&JdbcDao.checkthread(threadname,threadyear,threadpass)){
            JdbcDao jdbc = new JdbcDao();
            jdbc.deleteRecord(reg);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("You are not registered in this course or check all information correctly");
            alert.show();
        }

    }


    @FXML
    private void closeButtonAction(ActionEvent event) {
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.close();
    }

    @FXML
    private void updateButtonAction(ActionEvent event) {

        if(threadNameField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter your Thread Name");
            alert.show();
        }

        if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        String threadname = threadNameField.getText();
        String threadyear = threadYearField.getText();
        String threadpass = threadPassField.getText();
        String description = updateDescriptionField.getText();

        JdbcDao jdbc = new JdbcDao();
        jdbc.UpdateRecord(threadname,threadyear,threadpass,description);

    }




}