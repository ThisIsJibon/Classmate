/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NodeTypeLargeController extends ListCell<postType> {

    @FXML
    private Text nameText;
    @FXML
    private Text dateText;
    @FXML
    private Text timeText;
    @FXML
    private Text postText;
    @FXML
    private BorderPane gridPane; 
    private FXMLLoader mLLoader;

    /**
     * Initializes the controller class.
     */
        @Override
    protected void updateItem(postType student, boolean empty) {
        super.updateItem(student, empty);

        if(empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("NodeTypeLarge.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            dateText.setText((student.getDateText()));
            nameText.setText(student.getNameText());
            postText.setText(student.getPostText());
            timeText.setText(student.getTimeText());

            setText(null);
            setGraphic(gridPane);
        }

    }
    
}
