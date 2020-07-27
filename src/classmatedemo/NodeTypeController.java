/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import java.util.*;
import java.lang.*;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author Asus

 */


public class NodeTypeController extends ListCell<postType>{

    @FXML
    private Text nameText;
    @FXML
    private Text dateText;
    @FXML
    private Text postText;
    @FXML
    private Text timeText;
    @FXML
    private Text stateText;
    @FXML
    private ToggleButton saveButton;
    @FXML
    private BorderPane gridPane;
    private FXMLLoader mLLoader;
    public static int buttonState=0;

    /**
     * Initializes the controller class.
     */


    Preferences preferences = Preferences.userRoot();
    public  String email = preferences.get("email", "root");



    String query = "select * from registration where email = ? ";
    JdbcDao jdbc = new JdbcDao();
    ArrayList<String> list = jdbc.get_all_info(email, query);

    public String roll = list.get(5);

    @Override
    protected void updateItem(postType student, boolean empty) {
        super.updateItem(student, empty);

        if(empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("NodeType.fxml"));
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
            if(student.getStateText()=="0") {
                saveButton.setText("Save");
                saveButton.setSelected(false);
            }
            else {
                saveButton.setText("Unsave");
                saveButton.setSelected(true);
            }
            setGraphic(gridPane);
        }

    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws SQLException {


        JdbcDao jdbc = new JdbcDao();
        String date = dateText.getText();
        String time = timeText.getText();
        String post = postText.getText();
        String name = nameText.getText();
        String ok = "0";


        if(saveButton.isSelected()){
            System.out.println("query hobe");
            saveButton.setText("Unsave");


            String query = "INSERT INTO important (name,date,time,description,done,reg) VALUES (?,?,?,?,?,?) ";

            jdbc.insert_important(name,date,time,post,ok,roll,query);


        }
        else {
            saveButton.setText("Save");
            System.out.println("query delete hobe");
            String query = "DELETE FROM important WHERE name = ? and date = ? and time = ? and description = ? and done = ? and reg = ?";
            jdbc.delete_important(name,date,time,post,ok,roll,query);
        }




    }
    
}
