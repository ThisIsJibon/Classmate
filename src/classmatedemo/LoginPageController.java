
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginPageController implements Initializable {

    @FXML
    private JFXButton loginbutton;
    @FXML
    private JFXButton registerButton;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXPasswordField passField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginbuttonAction(ActionEvent event) throws IOException, SQLException {

        String email = emailField.getText();
        String pass = passField.getText();

        String query = "SELECT * FROM registration where email = ? and pass = ?";

        System.out.println(email);
        System.out.println(pass);
        System.out.println(query);

        if(JdbcDao.checklogin(email,pass,query)){

            Preferences preference = Preferences.userRoot();
            preference.put("email",email);

            loginbutton.getScene().getWindow().hide();
            Parent blah = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.setTitle("Classmate");
            appStage.show();
        }
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Please enter your email & password correctly");
            alert.show();
//            reseting user and pass field
            //emailField.setText("");
            //passField.setText("");
        }

    }

    @FXML
    private void registerButtonAction(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("RegistrationForm.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void openBrowser(ActionEvent event) throws URISyntaxException, IOException {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://github.com/ThisIsJibon/Classmate"));
            }
    }

}







