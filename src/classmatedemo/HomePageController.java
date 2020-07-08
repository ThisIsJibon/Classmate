
package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.prefs.Preferences;
import java.awt.Desktop;
import java.net.URI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import static java.awt.Color.*;
import static java.util.Calendar.AM;


import java.net.URISyntaxException;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckListView;



/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomePageController implements Initializable {

    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton threadButton;
    @FXML
    private JFXButton notificationButton;
    @FXML
    private JFXButton messageButton;
    @FXML
    private JFXButton timelineButton;
    @FXML
    private JFXButton importantButton;
    @FXML
    private JFXButton deadlineButton;
    @FXML
    private JFXButton searchboxButton;
    @FXML
    private Pane threadPane;
    @FXML
    private Pane homePane;
    @FXML
    private Pane notificationPane;
    @FXML
    private Pane messagePane;
    @FXML
    private Pane timelinePane;
    @FXML
    private Pane importantPane;
    @FXML
    private Pane deadlinePane;
    @FXML
    private Pane searchboxPane;
    @FXML
    private Pane accountPane;
    @FXML
    private JFXButton acoountButton;
    @FXML
    public JFXComboBox<String> threadComboBox;
    @FXML
    private JFXButton createThreadButton;
    @FXML
    private AnchorPane threadFeedAnchorPane;
    @FXML
    private VBox threadFeedAnchorPaneVbox;
    @FXML
    private VBox notificationPaneVBox;
    @FXML
    private VBox messagePaneVBox;
    @FXML
    private VBox timelimnePaneVBox;
    @FXML
    private VBox importantPaneVBox;
    @FXML
    private VBox deadlinePaneVBox;
    private LineChart<Number, Number> lineChart;
    private HBox accountPaneVBoxHBox;
    public Vector<String> threadList;
    @FXML
    private JFXButton manageThreadButton;
    @FXML
    private JFXButton postInThreadButton;
    @FXML
    private JFXButton undoInThreadButton;
    @FXML
    private TextField postInThreadTextfield;
    @FXML
    private JFXButton callButton;
    @FXML
    private JFXButton infoButton;
    @FXML
    private TextField messageTextfield;
    @FXML
    private JFXButton sendMessageButton;
    @FXML
    private JFXButton composeButton;
    @FXML
    private JFXTextField searchChatBox;
    @FXML
    private JFXButton searchChatButton;
    @FXML
    private JFXButton AboutButton;
    @FXML
    private JFXButton FeedButton;
    @FXML
    private JFXButton ResourcesButton;
    @FXML
    private JFXButton MembersButton;
    @FXML
    private JFXButton ArchivesButton;
    @FXML
    private javafx.scene.control.ScrollPane feedScrollPane;
    @FXML
    private ListView<postType> threadListView;
    @FXML
    private ListView<postType> homeListView;
    @FXML
    private ListView<postType> timelineListView;
    @FXML
    private JFXPasswordField accountPasswordField;
    @FXML
    private JFXButton accountApplyButton;
    @FXML
    private JFXButton accountCancelButton;
    @FXML
    private JFXTextField accountName;
    @FXML
    private JFXTextField accountReg;
    @FXML
    private JFXTextField accountEmail;
    @FXML
    private JFXTextField accountUsername;
    @FXML
    private JFXTextField accountHometown;
    @FXML
    private JFXTextField accountCGPA;
    @FXML
    private JFXComboBox<String> bloodGroupComboBox;
    @FXML
    private JFXPasswordField changePasswordField;
    @FXML
    private JFXTextField accountSemester;
    @FXML
    private JFXCheckBox cricketCheck;
    @FXML
    private JFXCheckBox footballCheck;
    @FXML
    private JFXCheckBox handballCheck;
    @FXML
    private JFXCheckBox volleyballCheck;
    @FXML
    private JFXCheckBox basketballCheck;
    @FXML
    private JFXCheckBox actingCheck;
    @FXML
    private JFXCheckBox debateCheck;
    @FXML
    private JFXCheckBox danceCheck;
    @FXML
    private JFXCheckBox musicCheck;
    @FXML
    private JFXCheckBox photographyCheck;
    @FXML
    private JFXCheckBox teacherCheck;
    @FXML
    private JFXCheckBox studentCheck;
    @FXML
    private JFXCheckBox bloodYesCheck;
    @FXML
    private JFXCheckBox bloodNoCheck;
    public boolean isFeedClicked = true;
    final ListView htmListView = new ListView();


    /**
     * Initializes the controller class.
     */
    Preferences preferences = Preferences.userRoot();
    public final String email = preferences.get("email", "root");
    public String selected;
    public String reg;
    public String name;
    public String password;
    public String thread_name;

    @FXML
    private JFXComboBox<String> queryTypeComboBox;
    @FXML
    private JFXTextField queryValueField;
    @FXML
    private JFXCheckBox searchboxCricketCheck;
    @FXML
    private JFXCheckBox searchboxFootballCheck;
    @FXML
    private JFXCheckBox searchboxHandballCheck;
    @FXML
    private JFXCheckBox searchboxVolleyballCheck;
    @FXML
    private JFXCheckBox searchboxBasketballCheck;
    @FXML
    private JFXCheckBox searchboxActingCheck;
    @FXML
    private JFXCheckBox searchboxDebateCheck;
    @FXML
    private JFXCheckBox searchboxDanceCheck;
    @FXML
    private JFXCheckBox searchboxMusicCheck;
    @FXML
    private JFXCheckBox searchboxPhotographyCheck;
    @FXML
    private JFXCheckBox searchboxBloodCheck;
    @FXML
    private JFXButton searchInSearchboxButton;
    @FXML
    private TableColumn<User, Integer> slColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> registrationColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> hometownColumn;
    @FXML
    private TableColumn<User, String> bloodgpColumn;
    @FXML
    private TableColumn<User, String> cgpaColumn;
    @FXML
    private TableView<User> searchTable;
    @FXML
    private HBox threadFeedAnchorPaneHbox;
    private ObservableList<postType>studentObservableList;
    private ObservableList<DeadlineType>deadlineObList;
    @FXML
    private ListView<postType> importantListview;
    @FXML
    private Pane postDeadlinePane;
    @FXML
    private JFXComboBox<String> threadForTaskCombobox;
    @FXML
    private JFXDatePicker taskDatePicker;
    @FXML
    private JFXTimePicker taskTimePicker;
    @FXML
    private JFXTextField taskNameField;
    @FXML
    private TextField taskDescriptionField;
    @FXML
    private JFXButton postTaskButton;
    @FXML
    private JFXButton setDeadlineButton;
    @FXML
    private ListView<DeadlineType> deadlineListview;
    @FXML
    private Pane aboutThreadPane;
    @FXML
    private JFXButton aboutThreadBackButton;
    @FXML
    private Text aboutThreadNameText;
    @FXML
    private Text aboutThreadYearText;
    @FXML
    private Text aboutThreadMembersText;
    @FXML
    private Text aboutThreadPasswordText;
    @FXML
    private Text aboutThreadDescText;
    @FXML
    private Pane threadMemberPane;
    @FXML
    private Text threadMembersNumberText;
    @FXML
    private CheckListView<String> globalListView;
    @FXML
    private CheckListView<String> threadMembersListview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //loadGraphData(); // loads cgpa graph

        String query = "select * from registration where email = ? ";
        JdbcDao jdbc = new JdbcDao();
        ArrayList<String> list = jdbc.get_all_info(email, query);

        reg = list.get(5);

        System.out.println(reg);

        homePageInitialize();
    }
    void homePageInitialize(){
        homePane.toFront();
        homeListView.getItems().clear();

        String query1 = "select * from manage_thread where reg = ? order by thread_id asc ";
        String query = "select * from news_feed where ";
        JdbcDao jdbc = new JdbcDao();
        ArrayList<String> items = jdbc.threadlist(reg, query1);

        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1)
                query += ("thread_id = \"" + items.get(i) + "\" order by  date desc");
            else
                query += ("thread_id = \"" + items.get(i) + "\"  OR ");
        }
        ArrayList<ArrayList<String>> list = jdbc.home_feed(query);

        studentObservableList = FXCollections.observableArrayList();

        for(int i=0;i<list.size();i++){
            studentObservableList.add(new postType(list.get(i).get(3), list.get(i).get(2),list.get(i).get(0), list.get(i).get(4)));
        }

        homeListView.setItems(studentObservableList);
        homeListView.setCellFactory(NodeTypeLargeController -> new NodeTypeLargeController());
    }
    @FXML
    private void homeButtonAction(ActionEvent event) {

        homePageInitialize();


    }

    @FXML
    private void threadButtonAction(ActionEvent event) {
        threadPane.toFront();

        threadComboBox.getItems().clear();
        threadListView.getItems().clear();

        String query = "select *from manage_thread where reg = ? order by thread_id asc";

        JdbcDao jdbc = new JdbcDao();
        ArrayList<String> list = jdbc.threadlist(reg, query);
        for (String str : list) {
            threadComboBox.getItems().add(str);
        }

        postInThreadTextfield.setText("");


        AboutButton.setEffect(null);
        FeedButton.setEffect(null);
        ResourcesButton.setEffect(null);
        MembersButton.setEffect(null);
        ArchivesButton.setEffect(null);


    }

    @FXML
    private void notificationButtonAction(ActionEvent event) {
        notificationPane.toFront();
    }

    @FXML
    private void messageButtonAction(ActionEvent event) {
        messagePane.toFront();
    }

    @FXML
    private void timelineButtonAction(ActionEvent event) {
        timelinePane.toFront();
        timelineListView.getItems().clear();

        String query1 = "select * from manage_thread where reg = ? order by thread_id asc";
        String query = "select * from news_feed where ";

        JdbcDao jdbc = new JdbcDao();

        ArrayList<String> items = jdbc.threadlist(reg, query1);


        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1)
                query += ("thread_id = \"" + items.get(i) + "\" order by date desc");
            else
                query += ("thread_id = \"" + items.get(i) + "\"  OR ");
        }

        System.out.println(query);
        ArrayList<ArrayList<String>> list = jdbc.home_feed(query);


        studentObservableList = FXCollections.observableArrayList();

        for(int i=0;i<list.size();i++){
            studentObservableList.add(new postType(list.get(i).get(3), list.get(i).get(2),list.get(i).get(0), list.get(i).get(4)));
        }

        /**studentObservableList.addAll(
                new postType("kalke exam", "3-04-2010", "Mahin", "5:50 PM"),
                new postType("gjgjhgjhjgjgjgjghjg", "19-03-2013","Mehedi", "5:10 AM")
        );*/
        timelineListView.setItems(studentObservableList);
        timelineListView.setCellFactory(NodeTypeLargeController -> new NodeTypeLargeController());
    }

    @FXML
    private void importantButtonAction(ActionEvent event) {
        importantPane.toFront();
        importantListview.getItems().clear();
        studentObservableList = FXCollections.observableArrayList();
        studentObservableList.addAll(
                new postType("kalke exam", "3-04-2010", "Mahin", "5:50 PM"),
                new postType("gjgjhgjhjgjgjgjghjg", "19-03-2013","Mehedi", "5:10 AM")
        );
        importantListview.setItems(studentObservableList);
        importantListview.setCellFactory(NodeTypeLargeController -> new NodeTypeLargeController());
        
    }

    @FXML
    private void deadlineButtonAction(ActionEvent event) {
        deadlinePane.toFront();
        
        deadlineObList = FXCollections.observableArrayList();
        /**deadlineObList.addAll(
                new DeadlineType("CSE150", "EXAM", "2020-09-10", "7:10PM","be prepared")
        );  */

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df1 = new SimpleDateFormat("hh:mm aa");
        DateFormat df2 = new SimpleDateFormat("hh:mm");
        Date dateobj = new Date();

        String PresentDay = df.format(dateobj);

        try {

            String PresentTime = df1.format(dateobj);
            System.out.println(PresentTime);
            Date dd = df1.parse(PresentTime);
            System.out.println(df2.format(dd));


            String ok = "0";

            String query1 = "select * from manage_thread where reg = ? order by thread_id asc";
            String query = "select * from deadline  where date >= \""+PresentDay+" "+df2.format(dd)+"\" AND done = \""+ok+"\" AND ( ";

            JdbcDao jdbc = new JdbcDao();

            ArrayList<String> items = jdbc.threadlist(reg, query1);


            for (int i = 0; i < items.size(); i++) {
                if (i == items.size() - 1)
                    query += ("thread = \"" + items.get(i)+"\" ) order by  dat asc ");
                else
                    query += ("thread = \"" + items.get(i) + "\"  OR ");
            }

            System.out.println(query);
            ArrayList<ArrayList<String>> list = jdbc.deadline(query);


            for(int i=0;i<list.size();i++){

                try{
                    Date date =  df2.parse(list.get(i).get(2));
                    System.out.println(df1.format(date));
                    deadlineObList.add(new DeadlineType(list.get(i).get(0), list.get(i).get(1),list.get(i).get(3), df1.format(date),list.get(i).get(4)));
                }
                catch (ParseException e){
                    e.printStackTrace();
                }



            }

        }
        catch (ParseException e){
            e.printStackTrace();
        }

        deadlineListview.setItems(deadlineObList);
        deadlineListview.setCellFactory(DeadlineNodeTypeController -> new DeadlineNodeTypeController());


    }

    @FXML
    private void searchboxButtonAction(ActionEvent event) {
        searchboxPane.toFront();
        queryTypeComboBox.getItems().clear();
        queryTypeComboBox.getItems().addAll(
                          "name",
                          "reg",
                          "email",
                          "hometown",
                          "bloodgroup"
        );
    }

    @FXML
    private void acoountButtonAction(ActionEvent event) {
        accountPane.toFront();

        JdbcDao jdbc = new JdbcDao();

        String query = "select * from registration where email = ? ";
        ArrayList<String> list = jdbc.get_all_info(email, query);
        for (String str : list) {
            System.out.println(str);
        }
        bloodGroupComboBox.getItems().clear();

        bloodGroupComboBox.getItems().addAll(
                "A+",
                "A-",
                "B+",
                "B-",
                "AB+",
                "AB-",
                "O+",
                "O-"
        );

        password = list.get(6);
        accountName.setText(list.get(0));
        accountReg.setText(list.get(5));
        accountEmail.setText(email);
        accountUsername.setText(list.get(1));
        accountHometown.setText(list.get(2));
        accountCGPA.setText(list.get(3));
        accountSemester.setText(list.get(4));
        bloodGroupComboBox.getSelectionModel().select(list.get(7));

        if (list.get(8).equals("1")) {
            cricketCheck.setSelected(true);
        } else {
            cricketCheck.setSelected(false);
        }
        if (list.get(9).equals("1")) {
            footballCheck.setSelected(true);
        } else {
            footballCheck.setSelected(false);
        }
        if (list.get(10).equals("1")) {
            handballCheck.setSelected(true);
        } else {
            handballCheck.setSelected(false);
        }
        if (list.get(11).equals("1")) {
            volleyballCheck.setSelected(true);
        } else {
            volleyballCheck.setSelected(false);
        }
        if (list.get(12).equals("1")) {
            basketballCheck.setSelected(true);
        } else {
            basketballCheck.setSelected(false);
        }
        if (list.get(13).equals("1")) {
            actingCheck.setSelected(true);
        } else {
            actingCheck.setSelected(false);
        }
        if (list.get(14).equals("1")) {
            debateCheck.setSelected(true);
        } else {
            debateCheck.setSelected(false);
        }
        if (list.get(15).equals("1")) {
            danceCheck.setSelected(true);
        } else {
            danceCheck.setSelected(false);
        }
        if (list.get(16).equals("1")) {
            musicCheck.setSelected(true);
        } else {
            musicCheck.setSelected(false);
        }
        if (list.get(17).equals("1")) {
            photographyCheck.setSelected(true);
        } else {
            photographyCheck.setSelected(false);
        }
        if (list.get(18).equals("1")) {
            teacherCheck.setSelected(true);
        } else {
            teacherCheck.setSelected(false);
        }
        if (list.get(19).equals("1")) {
            studentCheck.setSelected(true);
        } else {
            studentCheck.setSelected(false);
        }
        if (list.get(20).equals("1")) {
            bloodYesCheck.setSelected(true);
        } else {
            bloodYesCheck.setSelected(false);
        }
        if (list.get(21).equals("1")) {
            bloodNoCheck.setSelected(true);
        } else {
            bloodNoCheck.setSelected(false);
        }


    }

    @FXML
    private void createThreadButtonAction(ActionEvent event) throws IOException {
        Pane root = new Pane();
        root = FXMLLoader.load(getClass().getResource("CreateThread.fxml"));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("Create a thread");
        window.show();
    }

    @FXML
    private void threadComboBoxAction(ActionEvent event) {
        //ekhane thread gular backend
        //threadCreation();

        selected = threadComboBox.getSelectionModel().getSelectedItem();
        System.out.println(selected);
    }

    @FXML
    private void manageThreadButtonAction(ActionEvent event) throws IOException {
        Pane root = new Pane();
        root = FXMLLoader.load(getClass().getResource("ManageThread.fxml"));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("Manage thread");
        window.show();
    }

    @FXML
    private void postInThreadButtonAction(ActionEvent event) throws SQLException {
        
        if(isFeedClicked==true){
            // feed clicked
            
            String info_query = "select * from registration where email = ? ";
            JdbcDao jdbc = new JdbcDao();
            ArrayList<String> list = jdbc.get_all_info(email, info_query);

            name = list.get(0);


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat df1 = new SimpleDateFormat("hh.mm aa");
            Date dateobj = new Date();

            System.out.println(df.format(dateobj));
            System.out.println(df1.format(dateobj));

            //HTMLEditor htmlEditor = new HTMLEditor();
            // htmlEditor.setHtmlText("<i>"+name+"</i>");

            String feed = postInThreadTextfield.getText().trim();
            String query = "INSERT INTO news_feed (name,reg,thread_id,feed,date,time) VALUES (?, ?, ?, ?, ?,?) ";
            jdbc.insertRecord_feed(name, reg, selected, feed, df.format(dateobj), df1.format(dateobj),query);

            postInThreadTextfield.setText("");
            
        }
        else{
            // resources
            String info_query = "select * from registration where email = ? ";
            JdbcDao jdbc = new JdbcDao();
            ArrayList<String> list = jdbc.get_all_info(email, info_query);

            name = list.get(0);


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat df1 = new SimpleDateFormat("hh.mm aa");
            Date dateobj = new Date();
            System.out.println(df.format(dateobj));

            //HTMLEditor htmlEditor = new HTMLEditor();
            // htmlEditor.setHtmlText("<i>"+name+"</i>");

            String feed = postInThreadTextfield.getText().trim();
            String query = "INSERT INTO resource (name,reg,thread_id,feed,date,time) VALUES (?, ?, ?, ?, ?,?) ";
            jdbc.insertRecord_feed(name, reg, selected, feed, df.format(dateobj),df1.format(dateobj) ,query);

            postInThreadTextfield.setText("");

        }


   


    }

    @FXML
    private void undoInThreadButtonAction(ActionEvent event) {
        postInThreadTextfield.setText("");

    }

    @FXML
    private void callButtonAction(ActionEvent event) {
    }

    @FXML
    private void infoButtonAction(ActionEvent event) {
    }

    @FXML
    private void sendMessageButtonAction(ActionEvent event) {
    }

    @FXML
    private void composeButtonAction(ActionEvent event) {
    }

    @FXML
    private void searchChatButtonAction(ActionEvent event) {
    }

    @FXML
    private void AboutButtonAction(ActionEvent actionEvent) {


        postInThreadTextfield.setText("");

        DropShadow shadow = new DropShadow();

        AboutButton.setEffect(shadow);
        FeedButton.setEffect(null);
        ResourcesButton.setEffect(null);
        MembersButton.setEffect(null);
        ArchivesButton.setEffect(null);

        aboutThreadPane.toFront();


        aboutThreadNameText.setText("");
        aboutThreadMembersText.setText("");
        aboutThreadPasswordText.setText("");
        aboutThreadYearText.setText("");
        aboutThreadDescText.setText("");


        try {

            if(!threadComboBox.getSelectionModel().getSelectedItem().isEmpty()){


                JdbcDao jdbc = new JdbcDao();
                String query = "select * from thread where thread_id = ?";
                ArrayList<String> list = jdbc.get_about(selected, query);


                String query1 = "select * from manage_thread where thread_id = ? ";
                ArrayList<String> list1 = jdbc.memberlist(selected, query1);



                aboutThreadNameText.setText(list.get(0));
                aboutThreadMembersText.setText(String.valueOf(list1.size()));
                aboutThreadPasswordText.setText(list.get(2));
                aboutThreadYearText.setText(list.get(1));
                aboutThreadDescText.setText(list.get(3));


            }

        }
        catch (NullPointerException e){
            System.out.println("NullPointerException occured");
        }


    }

    @FXML
    private void FeedButtonAction(ActionEvent actionEvent) {


        postInThreadTextfield.setText("");


        DropShadow shadow = new DropShadow();

        AboutButton.setEffect(null);
        FeedButton.setEffect(shadow);
        ResourcesButton.setEffect(null);
        MembersButton.setEffect(null);
        ArchivesButton.setEffect(null);

        
        threadFeedAnchorPaneVbox.getChildren().clear();
        threadFeedAnchorPaneVbox.getChildren().add(threadFeedAnchorPaneHbox);
        threadFeedAnchorPaneVbox.getChildren().add(threadListView);
        isFeedClicked=true;
        
        JdbcDao jdbc = new JdbcDao();
        String query = "select * from news_feed where thread_id = ? order by date desc ";
        threadListView.getItems().clear();
        ArrayList<ArrayList<String>> list = jdbc.feed(selected, query);


        studentObservableList = FXCollections.observableArrayList();

        for (int i=0;i<list.size();i++) {
            studentObservableList.add(new postType(list.get(i).get(2), list.get(i).get(1), list.get(i).get(0),list.get(i).get(3)));
        }

       /** studentObservableList.addAll(
                new postType("kalke exam", "3-04-2010", "Mahin", "5:50 PM"),
                new postType("gjgjhgjhjgjgjgjghjg", "19-03-2013","Mehedi", "5:10 AM")
        );*/
        threadListView.setItems(studentObservableList);
        threadListView.setCellFactory(NodeTypeController -> new NodeTypeController());


    }

    @FXML
    private void ResourcesButtonAction(ActionEvent actionEvent) {

        postInThreadTextfield.setText("");


        DropShadow shadow = new DropShadow();

        AboutButton.setEffect(null);
        FeedButton.setEffect(null);
        ResourcesButton.setEffect(shadow);
        MembersButton.setEffect(null);
        ArchivesButton.setEffect(null);


        htmListView.setPrefHeight(553);
        threadFeedAnchorPaneVbox.getChildren().clear();
        threadFeedAnchorPaneVbox.getChildren().add(threadFeedAnchorPaneHbox);
       // Hyperlink link = new Hyperlink();
        String post = postInThreadTextfield.getText();
       // link.setText(post);
        htmListView.getItems().clear();
       // htmListView.getItems().add(link);
        threadFeedAnchorPaneVbox.getChildren().add(htmListView);
        isFeedClicked=false;
        
        
        List<Hyperlink> links = new ArrayList<>();

        JdbcDao jdbc = new JdbcDao();
        String query = "select * from resource where thread_id = ? order by date desc ";
       
        ArrayList<ArrayList<String>> list = jdbc.feed(selected, query);
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i).get(2));
            Hyperlink link = new Hyperlink(list.get(i).get(2).toString());
            links.add(link);
            htmListView.getItems().add(link);
        }
        for(Hyperlink link : links){
            String url=link.getText();
            link.setOnAction(new EventHandler<ActionEvent>() {
                @Override            
                public void handle(ActionEvent e) {
                     Desktop desktop = Desktop.getDesktop();
                    try {
                         try {
                             desktop.browse(new URI(url));
                         } catch (IOException ex) {
                             Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
             
    }
   
    @FXML
    private void MembersButtonAction(ActionEvent actionEvent) {

        postInThreadTextfield.setText("");


        DropShadow shadow = new DropShadow();

        AboutButton.setEffect(null);
        FeedButton.setEffect(null);
        ResourcesButton.setEffect(null);
        MembersButton.setEffect(shadow);
        ArchivesButton.setEffect(null);


        JdbcDao jdbc = new JdbcDao();
        String query = "select * from manage_thread where thread_id = ? order by reg asc";
        String query1 = "select * from registration order by reg asc";
        ArrayList<String> list = jdbc.memberlist(selected, query);

        for (String str : list) {
            System.out.println(str);
        }

        ArrayList<String> list1 = jdbc.allUser(query1);


        threadMemberPane.toFront();
        globalListView.getItems().clear();
        threadMembersListview.getItems().clear();

        threadMembersNumberText.setText(String.valueOf(list.size()));

        for(String str : list1){
            globalListView.getItems().add(str);
        }

        for(String str : list){
            threadMembersListview.getItems().add(str);
        }


        String nameString="2018331001";
        globalListView.getItems().add(nameString);
        nameString="2018331002";
        globalListView.getItems().add(nameString);

    }

    @FXML
    private void ArchivesButtonAction(ActionEvent actionEvent) {

        postInThreadTextfield.setText("");

        DropShadow shadow = new DropShadow();

        AboutButton.setEffect(null);
        FeedButton.setEffect(null);
        ResourcesButton.setEffect(null);
        MembersButton.setEffect(null);
        ArchivesButton.setEffect(shadow);

    }

    @FXML
    private void accountApplyButtonAction(ActionEvent event) throws SQLException {

        String query = "UPDATE registration SET name = ? , username = ? , email = ? , pass = ? , repeatPass = ? , hometown = ? , cgpa = ? , semester = ? , bloodgroup = ?,cricket = ?, football = ?,handball = ?, volleyball = ?, basketball = ?, acting = ?, debate = ?, dance = ?, music = ?, photography = ?, teacher = ?, student = ?, blood_donate_yes = ?, blood_donate_no = ?  WHERE reg = ? and pass = ? ";

        if (accountPasswordField.getText().isEmpty() || (!accountPasswordField.getText().equals(password))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Please enter your Password Correctly");
            alert.show();

        } else if ((teacherCheck.isSelected() && studentCheck.isSelected()) || (bloodYesCheck.isSelected() && bloodNoCheck.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Select One of your role & donate blood");
            alert.show();
        } else {

            String pass;
            if (changePasswordField.getText().isEmpty()) {
                pass = password;
            } else {
                pass = changePasswordField.getText();
            }

            String name = accountName.getText();
            String username = accountUsername.getText();
            String email = accountEmail.getText();
            String hometown = accountHometown.getText();
            String cgpa = accountCGPA.getText();
            String semester = accountSemester.getText();
            String bloodgroup = bloodGroupComboBox.getSelectionModel().getSelectedItem();

            String cricket;
            String football;
            String handball;
            String volleyball;
            String basketball;
            String acting;
            String debate;
            String dance;
            String music;
            String photography;
            String teacher;
            String student;
            String blood_donate_yes;
            String blood_donate_no;

            if (cricketCheck.isSelected()) {
                cricket = "1";
            } else {
                cricket = "0";
            }
            if (footballCheck.isSelected()) {
                football = "1";
            } else {
                football = "0";
            }
            if (handballCheck.isSelected()) {
                handball = "1";
            } else {
                handball = "0";
            }
            if (volleyballCheck.isSelected()) {
                volleyball = "1";
            } else {
                volleyball = "0";
            }
            if (basketballCheck.isSelected()) {
                basketball = "1";
            } else {
                basketball = "0";
            }
            if (actingCheck.isSelected()) {
                acting = "1";
            } else {
                acting = "0";
            }
            if (debateCheck.isSelected()) {
                debate = "1";
            } else {
                debate = "0";
            }
            if (danceCheck.isSelected()) {
                dance = "1";
            } else {
                dance = "0";
            }
            if (musicCheck.isSelected()) {
                music = "1";
            } else {
                music = "0";
            }
            if (photographyCheck.isSelected()) {
                photography = "1";
            } else {
                photography = "0";
            }
            if (teacherCheck.isSelected()) {
                teacher = "1";
            } else {
                teacher = "0";
            }
            if (studentCheck.isSelected()) {
                student = "1";
            } else {
                student = "0";
            }

            if (bloodYesCheck.isSelected()) {
                blood_donate_yes = "1";
            } else {
                blood_donate_yes = "0";
            }
            if (bloodNoCheck.isSelected()) {
                blood_donate_no = "1";
            } else {
                blood_donate_no = "0";
            }

            JdbcDao jdb = new JdbcDao();
            jdb.update_registration(name, username, email, pass, pass, hometown, cgpa, semester, bloodgroup, cricket, football, handball, volleyball, basketball, acting, debate, dance, music, photography, teacher, student, blood_donate_yes, blood_donate_no, reg, accountPasswordField.getText(), query);
            System.out.println("successful");
            accountPasswordField.setText("");

            String info_query = "select * from registration where email = ? ";
            ArrayList<String> list = jdb.get_all_info(email, info_query);

            if (name != list.get(0)) {
                String update_query = "UPDATE news_feed SET name = ? where reg =? ";
                jdb.update_name_news_feed(reg, name, update_query);
            }


        }


    }

    @FXML
    private void accountCancelButtonAction(ActionEvent event) {
    }

    @FXML
    private void searchInSearchboxButton(ActionEvent event) throws IOException {
        
        searchTable.getItems().clear();
        StringBuffer query = new StringBuffer("select * from registration where ");
        
        try {
            if (!queryTypeComboBox.getSelectionModel().getSelectedItem().isEmpty()) {
                query.append(queryTypeComboBox.getSelectionModel().getSelectedItem() + "  =  \"" + queryValueField.getText() + "\"  and");
            }
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException occurred");
        }

        if(searchboxCricketCheck.isSelected()){
            query.append(" cricket = \"1\" and");
        }
        if(searchboxFootballCheck.isSelected()){
            query.append(" football = \"1\" and");
        }
        if(searchboxHandballCheck.isSelected()){
            query.append(" handball = \"1\" and");
        }
        if(searchboxVolleyballCheck.isSelected()){
            query.append(" volleyball = \"1\" and");
        }
        if(searchboxBasketballCheck.isSelected()){
            query.append(" basketball = \"1\" and");
        }
        if(searchboxActingCheck.isSelected()){
            query.append(" acting = \"1\" and");
        }
        if(searchboxDebateCheck.isSelected()){
            query.append(" debate = \"1\" and");
        }
        if(searchboxDanceCheck.isSelected()){
            query.append(" dance = \"1\" and");
        }
        if(searchboxMusicCheck.isSelected()){
            query.append(" music = \"1\" and");
        }
        if(searchboxPhotographyCheck.isSelected()){
            query.append(" photography = \"1\" and");
        }
        if(searchboxBloodCheck.isSelected()){
            query.append(" blood_donate_yes = \"1\"   ");
        }

        int a = query.length();

        query.delete(a-3,a);
        
        //query.append("where student=\"1\"");
        
        System.out.println(query);


        slColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("sl"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        registrationColumn.setCellValueFactory(new PropertyValueFactory<User,String>("registration"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        hometownColumn.setCellValueFactory(new PropertyValueFactory<User,String>("hometown"));
        bloodgpColumn.setCellValueFactory(new PropertyValueFactory<User,String>("bloodGroup"));
        cgpaColumn.setCellValueFactory(new PropertyValueFactory<User,String>("cgpa"));

        JdbcDao jdbcDao = new JdbcDao();
        ArrayList<ArrayList<String>>list = jdbcDao.search_info(query.toString());
        
        
        //searchTable.setItems(oblist);
        // User user=User.createUser("mahin","mahinur@gmail.com","54","Noagaon","4.0","3rd","o+","mahin54","asdasd");

        for(int i=0;i<list.size();i++){
            User user = User.createUser(i+1,list.get(i).get(0),list.get(i).get(1),list.get(i).get(2),list.get(i).get(3),list.get(i).get(4),
                    list.get(i).get(5),list.get(i).get(6),list.get(i).get(7),list.get(i).get(8));
            searchTable.getItems().add(user);
            System.out.println(list.get(i).get(1));
        }


    }

    @FXML
    private void setDeadlineButtonAction(ActionEvent event) {
        postDeadlinePane.toFront();

        threadForTaskCombobox.getItems().clear();

        String query = "select *from manage_thread where reg = ? order by thread_id asc";

        JdbcDao jdbc = new JdbcDao();
        ArrayList<String> list = jdbc.threadlist(reg, query);
        for (String str : list) {
            threadForTaskCombobox.getItems().add(str);
        }

    }

    @FXML
    private void postTaskButtonAction(ActionEvent event) throws SQLException {



        String thread = threadForTaskCombobox.getSelectionModel().getSelectedItem();
        String task = taskNameField.getText();
        String description = taskDescriptionField.getText();
        String done ="0";


        LocalDate date = taskDatePicker.getValue();
        LocalTime time = taskTimePicker.getValue();

        System.out.println( date );
        System.out.println( time );

        String query = "INSERT INTO deadline (thread,dat,tim,task,description,reg,done,date) VALUES (?, ?, ?, ?, ?,?,?,?) ";

        JdbcDao jdbc = new JdbcDao();
        jdbc.insertRecord_deadline(thread,date.toString(),time.toString(),task,description,reg,done,date.toString()+" "+time.toString(),query);




    }

    @FXML
    private void removeUserFromThreadAction(ActionEvent event) throws IOException {

        ObservableList<String> list = threadMembersListview.getCheckModel().getCheckedItems();

        JdbcDao jdbc = new JdbcDao();



        String remove_query = "DELETE from manage_thread WHERE reg = ? and thread_id =? ";
        String manage_thread_query = "select * from manage_thread WHERE thread_id = ? and reg = ? ";


        for(String str : list){

            if(JdbcDao.check_man_thread(selected,str,manage_thread_query)){
                jdbc.deleteRecord(str,selected,remove_query);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("warning");
                alert.setContentText("This Reg-Num : "+str+" is not registered in "+selected+" course");
                alert.show();
            }


        }


        String query = "select * from manage_thread where thread_id = ? order by reg asc";
        ArrayList<String> list1 = jdbc.memberlist(selected, query);

        threadMembersListview.getItems().clear();

        for(String str : list1){
            threadMembersListview.getItems().add(str);
        }

        threadMembersNumberText.setText(String.valueOf(list1.size()));



    }

    @FXML
    private void addUserFromThreadAction(ActionEvent event) throws IOException {

       ObservableList<String> list = globalListView.getCheckModel().getCheckedItems();


        JdbcDao jdbc = new JdbcDao();


        String check_query = " select * from manage_thread where reg = ? and thread_id = ? ";
        String insert_query = "INSERT INTO  manage_thread(thread_id,reg) VALUES (?, ?)";

       for(String str : list){
           System.out.println(str);


           if(JdbcDao.check_user(str,selected,check_query)){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Information");
               alert.setContentText("This Registration Number user is already added in this Course");
               alert.show();
           }
           else{
               jdbc.insertRecord(selected,str,insert_query);
           }



       }


        String query = "select * from manage_thread where thread_id = ? order by reg asc";
        ArrayList<String> list1 = jdbc.memberlist(selected, query);

        threadMembersListview.getItems().clear();

        threadMembersNumberText.setText(String.valueOf(list1.size()));


        for(String str : list1){
            threadMembersListview.getItems().add(str);
        }



    }


}

