package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;


public class RegistrationFormController implements Initializable {

    @FXML
    private JFXButton closeButton;
    @FXML
    private JFXButton sighUpButton;
    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXTextField regField;
    @FXML
    private JFXPasswordField passField;
    @FXML
    private JFXPasswordField repeatPassField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeButtonAction(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void sighUpButtonAction(ActionEvent event) throws SQLException {

        Pane gridPane= new Pane();
        Scene scene = new Scene(gridPane);
        Stage window=new Stage();
        window.setScene(scene);
        // window.show();


        System.out.println(nameField.getText());
        System.out.println(usernameField.getText());
        System.out.println(emailField.getText());
        System.out.println(regField.getText());
        System.out.println(passField.getText());
        System.out.println(repeatPassField.getText());

        if(nameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
            return;
        }
        if(usernameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your username");
            return;
        }
        if(emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email");
            return;
        }
        String query = "select *from registration where email = ? ";
        if(JdbcDao.check_data(emailField.getText(),query)){
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This Email id : "+emailField.getText()+" already exists.Use another Email id.");
            return;
        }
        if(regField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your RegistrationNumber");
            return;
        }
        if(passField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
            return;
        }
        if(repeatPassField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter repeatpassword");
            return;
        }

        if(!repeatPassField.getText().equals(passField.getText())) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter repeatpassword same as password");
            return;
        }


        String name = nameField.getText();
        String username = usernameField.getText();
        String email  = emailField.getText();
        String reg =  regField.getText();
        String pass = passField.getText();
        String repeatPass  = repeatPassField.getText();


        Random rand = new Random();
        String code = String.format("%04d", rand.nextInt(10000));

        System.out.println(code);
        String msg = "Welcome to Classmate.Your verification code is : "+code;

     //   SendEmail sendemail = new SendEmail();
      //  sendemail.send(email,msg);

        ConfirmationForm confirmation = new ConfirmationForm ();

        confirmation.cnfrm(name,username,email,reg,pass,repeatPass,code);


    }


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.setX(600);
        alert.setY(350);
        alert.show();
    }

}

