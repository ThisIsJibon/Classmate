/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class DeadlineNodeTypeController extends ListCell<DeadlineType> {

    @FXML
    private Text threadText;
    @FXML
    private JFXButton doneButton;
    @FXML
    private Text taskHeadlineText;
    @FXML
    private Text timeText;
    @FXML
    private Text dateText;
    @FXML
    private Text descriptionText;

    @FXML
    private void doneButtonAction(ActionEvent event) {
    }

    
    
}
