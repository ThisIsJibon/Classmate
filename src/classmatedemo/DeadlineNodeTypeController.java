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
    private BorderPane gridPane;
    private FXMLLoader mLLoader;

    
        @Override
    protected void updateItem(DeadlineType deadline, boolean empty) {
        super.updateItem(deadline, empty);

        if(empty || deadline == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("DeadlineNodeType.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            dateText.setText((deadline.getDateText()));
            taskHeadlineText.setText(deadline.getTaskText());
            threadText.setText(deadline.getThreadText());
            timeText.setText(deadline.getTimeText());
            descriptionText.setText(deadline.getDescriptionText());

            setText(null);
            setGraphic(gridPane);
        }

    }
    @FXML
    private void doneButtonAction(ActionEvent event) {



    }

    
    
}
