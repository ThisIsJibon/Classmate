package classmatedemo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.prefs.Preferences;

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
import javafx.scene.control.TextField;
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
    public  JFXComboBox<String> threadComboBox;
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
    @FXML
    private VBox searchboxPaneVBox;
    private LineChart<Number, Number> lineChart;
    private HBox accountPaneVBoxHBox;
    public  Vector<String> threadList;
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

    /**
     * Initializes the controller class.
     */

    Preferences preferences = Preferences.userRoot();
    public final  String email =preferences.get("email","root");
    public String selected;
    public String reg;
    public String name;
    @FXML
    private JFXListView<String> threadListView;
    @FXML
    private JFXListView<String> homeListView;
    @FXML
    private JFXListView<String> timelineListView;
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
    private JFXComboBox<?> bloodGroupComboBox;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //loadGraphData(); // loads cgpa graph
        String get_reg = "select *from registration where email = ?";
        String get_name = "select * from registration where email = ?";
        JdbcDao jdbc = new JdbcDao();
        reg = jdbc.get_reg(email,get_reg);
        name = jdbc.get_name(email,get_name);
        System.out.println(reg);
        System.out.println(name);

    }

    private void loadGraphData(){
        NumberAxis xAxis=new NumberAxis(1,8,1);
        NumberAxis yAxis=new NumberAxis(2, 4, 0.25); xAxis.setLabel("Term"); yAxis.setLabel("CGPA");
        lineChart = new LineChart(xAxis,yAxis); //lineChart.setTitle("");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("cgpa over terms");
        series1.getData().add(new XYChart.Data<>(1, 3.5));
        series1.getData().add(new XYChart.Data<>(2, 3.4));
        series1.getData().add(new XYChart.Data<>(3, 3.7));
        series1.getData().add(new XYChart.Data<>(4, 3.85));
        series1.getData().add(new XYChart.Data<>(5, 3.9));
        series1.getData().add(new XYChart.Data<>(6, 3.5));
        lineChart.getData().add(series1);
        lineChart.setMaxSize(300, 300);
        accountPaneVBoxHBox.getChildren().add(lineChart);
    }
    @FXML
    private void homeButtonAction(ActionEvent event) {
        homePane.toFront();
        homeListView.getItems().clear();

        String query = "select * from news_feed where thread_id = ? order by date desc ";
        String query1 = "select * from manage_thread where reg = ? ";

        JdbcDao jdbc = new JdbcDao();

        ArrayList <String> items = jdbc.get_all_thread(reg,query1);


        for(String str : items){
            ArrayList<String> list = jdbc.home_feed(str,query);
            for(String strr : list){
                System.out.println(strr);
                homeListView.getItems().add(strr);
            }
       }
    }

    @FXML
    private void threadButtonAction(ActionEvent event) {
        threadPane.toFront();

        threadComboBox.getItems().clear();
        JdbcDao jdbc = new JdbcDao();
        ArrayList<String> list = jdbc.threadlist(reg);
        for(String str : list) {
            threadComboBox.getItems().add(str);
        }



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

        String query = "select * from news_feed where thread_id = ? order by date desc ";
        String query1 = "select * from manage_thread where reg = ? ";

        JdbcDao jdbc = new JdbcDao();

        ArrayList <String> items = jdbc.get_all_thread(reg,query1);


        for(String str : items){
            ArrayList<String> list = jdbc.home_feed(str,query);
            for(String strr : list){
                System.out.println(strr);
                timelineListView.getItems().add(strr);
            }
        }
    }

    @FXML
    private void importantButtonAction(ActionEvent event) {
        importantPane.toFront();
    }

    @FXML
    private void deadlineButtonAction(ActionEvent event) {
        deadlinePane.toFront();
    }

    @FXML
    private void searchboxButtonAction(ActionEvent event) {
        searchboxPane.toFront();
    }

    @FXML
    private void acoountButtonAction(ActionEvent event) {
        accountPane.toFront();
    }

    @FXML
    private void createThreadButtonAction(ActionEvent event) throws IOException {
        Pane root= new Pane();
        root = FXMLLoader.load(getClass().getResource("CreateThread.fxml"));
        Scene scene = new Scene(root);
        Stage window=new Stage();
        window.setScene(scene);
        window.setTitle("Create a thread");
        window.show();
    }

    @FXML
    private void threadComboBoxAction(ActionEvent event) {
        //ekhane thread gular backend
        //threadCreation();

        selected =  threadComboBox.getSelectionModel().getSelectedItem();
        System.out.println(selected);
    }

    @FXML
    private void manageThreadButtonAction(ActionEvent event) throws IOException {
        Pane root= new Pane();
        root = FXMLLoader.load(getClass().getResource("ManageThread.fxml"));
        Scene scene = new Scene(root);
        Stage window=new Stage();
        window.setScene(scene);
        window.setTitle("Manage thread");
        window.show();
    }

    @FXML
    private void postInThreadButtonAction(ActionEvent event) throws SQLException {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));

        //HTMLEditor htmlEditor = new HTMLEditor();
        // htmlEditor.setHtmlText("<i>"+name+"</i>");

        String feed = postInThreadTextfield.getText();
        String query = "INSERT INTO news_feed (name,reg,thread_id,feed,date) VALUES (?, ?, ?, ?, ?) ";
        JdbcDao jdbc = new JdbcDao();
        jdbc.insertRecord_feed(name,reg,selected,feed,df.format(dateobj),query);




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
    public void AboutButtonAction(ActionEvent actionEvent) {
        JdbcDao jdbc = new JdbcDao();
        String query = "select * from thread where thread_id = ?";
        String ans = jdbc.get_about(selected,query);
        System.out.println(ans);
    }

    @FXML
    public void FeedButtonAction(ActionEvent actionEvent) {

        JdbcDao jdbc = new JdbcDao();
        String query = "select * from news_feed where thread_id = ? order by date desc ";
        threadListView.getItems().clear();
        ArrayList<String> list = jdbc.feed(selected,query);
        for(String str : list){
            System.out.println(str);
            threadListView.getItems().add(str);
        }

    }

    @FXML
    public void ResourcesButtonAction(ActionEvent actionEvent) {
    }

    @FXML
    public void MembersButtonAction(ActionEvent actionEvent) {

        JdbcDao jdbc = new JdbcDao();
        String query = "select * from manage_thread where thread_id = ? ";
        ArrayList<String> list = jdbc.memberlist(selected,query);
        for(String str : list){
            System.out.println(str);
        }

    }

    @FXML
    public void ArchivesButtonAction(ActionEvent actionEvent) {



    }

    @FXML
    private void accountApplyButtonAction(ActionEvent event) {
    }

    @FXML
    private void accountCancelButtonAction(ActionEvent event) {
    }
}