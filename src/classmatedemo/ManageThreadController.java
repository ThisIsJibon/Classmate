
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.*;
import java.util.Scanner;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class   ManageThreadController implements Initializable {

    public AnchorPane mainAnchorPane;
    @FXML
    private JFXTextField userRegistrationField;
    @FXML
    private JFXButton addUserButton;
    @FXML
    private JFXButton removeUserButton;
    @FXML
    private javafx.scene.control.TextArea updateDescriptionField;
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

        else if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        else if(threadPassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Password");
            alert.show();
        }
        else if(userRegistrationField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter Registration Number");
            alert.show();
        }

        else{

            String check_query = " select * from manage_thread where reg = ? and thread_id = ? ";
            String query = "select * from thread where threadname = ? and threadyear = ? and threadpass = ?";
            String insert_query = "INSERT INTO  manage_thread(thread_id,reg) VALUES (?, ?)";

            String threadname = threadNameField.getText();
            String threadyear = threadYearField.getText();
            String threadpass = threadPassField.getText();
            String reg = userRegistrationField.getText();

            if(JdbcDao.check_thread(threadname,threadyear,threadpass,query)){

                if(JdbcDao.check_user(reg,threadname+"-"+threadyear,check_query)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setContentText("This Registration Number user is already added in this Course");
                    alert.show();
                }
                else{
                    JdbcDao jdbc = new JdbcDao();
                    jdbc.Insert_Record(threadname+"-"+threadyear,reg,insert_query);
                }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("warning");
                alert.setContentText("Please enter all Information correctly");
                alert.show();
            }


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

        else if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        else if(threadPassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Password");
            alert.show();
        }
        else if(userRegistrationField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Registration Number");
            alert.show();
        }
        else{

            String threadname = threadNameField.getText();
            String threadpass = threadPassField.getText();
            String threadyear = threadYearField.getText();
            String reg = userRegistrationField.getText();
            String thread_id = threadNameField.getText()+"-"+threadYearField.getText();

            String remove_query = "DELETE from manage_thread WHERE reg = ? and thread_id =? ";
            String thread_query = "select * from thread where threadname = ? and threadyear = ? and threadpass = ?";
            String manage_thread_query = "select * from manage_thread WHERE thread_id = ? and reg = ? ";

            if(JdbcDao.check_thread(threadname,threadyear,threadpass,thread_query)&&JdbcDao.check_man_thread(thread_id,reg,manage_thread_query)){
                JdbcDao jdbc = new JdbcDao();
                jdbc.deleteRecord(reg,thread_id,remove_query);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("warning");
                alert.setContentText("You are not registered in this course or check all information correctly");
                alert.show();
            }


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

        else if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        else{

            String threadname = threadNameField.getText();
            String threadyear = threadYearField.getText();
            String threadpass = threadPassField.getText();
            String description = updateDescriptionField.getText();

            String query = "UPDATE thread SET threadpass = ?, description = ? WHERE threadname = ? and threadyear = ?";
            String thread_query = "select * from thread where thread_id = ? ";

            JdbcDao jdbc = new JdbcDao();
            ArrayList<String> list = jdbc.thread_data(threadname+"-"+threadyear,thread_query);

            if(threadpass.equals(""))
                threadpass=list.get(0);
            if(description.equals(""))
                description=list.get(1);


            if(JdbcDao.check_data(threadname+"-"+threadyear,thread_query)){

                jdbc.UpdateRecord(threadname,threadyear,threadpass,description,query);

            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("warning");
                alert.setContentText("This Thread_id doesn't exist.");
                alert.show();
            }



        }

    }


    public void addUserCSVButtonAction(ActionEvent actionEvent) throws FileNotFoundException,IOException{
        FileChooser fileChooser = new FileChooser();
        Stage primaryStage=(Stage) mainAnchorPane.getScene().getWindow();
        File csvFile = (File) fileChooser.showOpenDialog(primaryStage);
        Scanner sc = new Scanner(csvFile);
        sc.useDelimiter(",");   //sets the delimiter pattern
        System.out.print("here is CSV output");


        if(threadNameField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter your Thread Name");
            alert.show();
        }

        else if(threadYearField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Year");
            alert.show();
        }
        else if(threadPassField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter your Thread Password");
            alert.show();
        }


        String check_query = " select * from manage_thread where reg = ? and thread_id = ? ";
        String query = "select * from thread where threadname = ? and threadyear = ? and threadpass = ?";
        String insert_query = "INSERT INTO  manage_thread(thread_id,reg) VALUES (?, ?)";

        String threadname = threadNameField.getText();
        String threadyear = threadYearField.getText();
        String threadpass = threadPassField.getText();
        String reg = userRegistrationField.getText();

        if(!JdbcDao.check_thread(threadname,threadyear,threadpass,query)){


            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setContentText("Please enter all Information correctly");
            alert.show();

        }


        ArrayList<String>list = new ArrayList<>();

        while (sc.hasNext())  //returns a boolean value
        {
            ///System.out.print(sc.next());  //find and returns the next complete token from this scanner
            String text=sc.nextLine();
            System.out.println(text);
            list.add(text);

        }
        sc.close();

        JdbcDao jdbc = new JdbcDao();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            if(JdbcDao.check_user(list.get(i),threadname+"-"+threadyear,check_query))
                System.out.println("already exists");
            else
                jdbc.Insert_Record(threadname+"-"+threadyear, list.get(i), insert_query);
        }
    }
}
