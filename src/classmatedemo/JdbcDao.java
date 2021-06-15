



package classmatedemo;




import javafx.collections.ObservableList;
import javafx.scene.web.HTMLEditor;

import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JdbcDao {


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/classmate?autoReconnect=true&useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "mahinjibon";


    public ArrayList<String> allUser(String query){
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            ArrayList<String> list = new ArrayList<>();
            try(Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){

                    String reg = resultSet.getString("reg");
                    list.add(reg);

                }


            }
            catch (Exception e){
                e.printStackTrace();
            }

            return list;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    public ArrayList<String> get_about(String selected,String query){
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            ArrayList<String> list = new ArrayList<>();
            try(Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,selected);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                String description = resultSet.getString("description");
                String thread = resultSet.getString("threadname");
                String pass = resultSet.getString("threadpass");
                String year = resultSet.getString("threadyear");
                list.add(thread);
                list.add(year);
                list.add(pass);
                list.add(description);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return list;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public void insertRecord (String name, String username, String email,String reg,String pass,String repeatPass,String query) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, reg);
            preparedStatement.setString(5, pass);
            preparedStatement.setString(6, repeatPass);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }



    public void update_registration(String name,String username,String email,String pass,String repeatpass,String hometown,String cgpa,String semester,String bloodgroup,String cricket,String football,String handball,String volleyball,String basketball,String acting, String debate,String

                                    dance,String music,String photography,String teacher,String student,String blood_donate_yes,String blood_donate_no,String reg,String pas,String query) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,pass);
            preparedStatement.setString(5,repeatpass);
            preparedStatement.setString(6,hometown);
            preparedStatement.setString(7,cgpa);
            preparedStatement.setString(8,semester);
            preparedStatement.setString(9,bloodgroup);
            preparedStatement.setString(10,cricket);
            preparedStatement.setString(11,football);
            preparedStatement.setString(12,handball);
            preparedStatement.setString(13,volleyball);
            preparedStatement.setString(14,basketball);
            preparedStatement.setString(15,acting);
            preparedStatement.setString(16,debate);
            preparedStatement.setString(17,dance);
            preparedStatement.setString(18,music);
            preparedStatement.setString(19,photography);
            preparedStatement.setString(20,teacher);
            preparedStatement.setString(21,student);
            preparedStatement.setString(22,blood_donate_yes);
            preparedStatement.setString(23,blood_donate_no);
            preparedStatement.setString(24,reg);
            preparedStatement.setString(25,pas);
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }





    public void insertRecord_feed (String name,String reg, String thread_id, String feed,String date,String time,String ordering,String query) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, reg);
            preparedStatement.setString(3, thread_id);
            preparedStatement.setString(4, feed);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, time);
            preparedStatement.setString(7, ordering);



            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }


    public void insertRecord_deadline (String thread,String dat, String time, String task,String description,String reg,String done,String date,String query) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, thread);
            preparedStatement.setString(2, dat);
            preparedStatement.setString(3, time);
            preparedStatement.setString(4, task);
            preparedStatement.setString(5, description);
            preparedStatement.setString(6, reg);
            preparedStatement.setString(7, done);
            preparedStatement.setString(8, date);




            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    public void insert_important (String name,String date, String time, String post,String done,String roll,String query) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            preparedStatement.setString(4, post);
            preparedStatement.setString(5, done);
            preparedStatement.setString(6, roll);





            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }



    public void delete_important (String name,String date, String time, String post,String done,String roll,String query) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            preparedStatement.setString(4, post);
            preparedStatement.setString(5, done);
            preparedStatement.setString(6, roll);





            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }





    public void insertRecord(String thread_id, String reg,String query) throws IOException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, thread_id);
            preparedStatement.setString(2, reg);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void deleteRecord(String reg,String thread_id,String query) throws IOException{

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, reg);
            preparedStatement.setString(2, thread_id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

    }

    public static boolean checklogin(String email,String pass,String query) throws  SQLException{

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,pass);

            System.out.println("succesful connection");

            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();

            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }


    public static boolean check_data(String a,String query)  {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,a);


            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }

    public static boolean check_thread(String threadname,String threadyear,String threadpass,String query) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,threadname);
            preparedStatement.setString(2,threadyear);
            preparedStatement.setString(3,threadpass);
            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }

    public static boolean check_user(String reg,String thread_id,String query) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,reg);
            preparedStatement.setString(2,thread_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }




    public static boolean check_man_thread(String thread_id,String reg,String query) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,thread_id);
            preparedStatement.setString(2,reg);
            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }


    public void insertRecord(String threadname,String threadpass,String threadyear,String description,String thread_id,String query){

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, threadname);
            preparedStatement.setString(2, threadpass);
            preparedStatement.setString(3, threadyear);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, thread_id);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }



    public ArrayList<String> get_all_info (String email,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<String> list = new ArrayList<String>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,email);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String hometown = resultSet.getString("hometown");
                String cgpa = resultSet.getString("cgpa");
                String semester = resultSet.getString("semester");
                String reg = resultSet.getString("reg");
                String pass = resultSet.getString("pass");
                String bloodgroup = resultSet.getString("bloodgroup");
                String cricket = resultSet.getString("cricket");
                String football = resultSet.getString("football");
                String handball = resultSet.getString("handball");
                String volleyball = resultSet.getString("volleyball");
                String basketball = resultSet.getString("basketball");
                String acting = resultSet.getString("acting");
                String debate = resultSet.getString("debate");
                String dance = resultSet.getString("dance");
                String music = resultSet.getString("music");
                String photography = resultSet.getString("photography");
                String teacher = resultSet.getString("teacher");
                String student = resultSet.getString("student");
                String blood_donate_yes = resultSet.getString("blood_donate_yes");
                String blood_donate_no = resultSet.getString("blood_donate_no");

                list.add(name);
                list.add(username);
                list.add(hometown);
                list.add(cgpa);
                list.add(semester);
                list.add(reg);
                list.add(pass);
                list.add(bloodgroup);
                list.add(cricket);
                list.add(football);
                list.add(handball);
                list.add(volleyball);
                list.add(basketball);
                list.add(acting);
                list.add(debate);
                list.add(dance);
                list.add(music);
                list.add(photography);
                list.add(teacher);
                list.add(student);
                list.add(blood_donate_yes);
                list.add(blood_donate_no);

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }




    public ArrayList<String> threadlist (String reg,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<String> list = new ArrayList<String>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,reg);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                  //System.out.println(resultSet.getString("thread_id"));
                  System.out.println("Successful");
                    list.add(resultSet.getString("thread_id"));
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }




    public ArrayList<String> thread_data (String thread_id,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<String> list = new ArrayList<String>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,thread_id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    //System.out.println(resultSet.getString("thread_id"));
                    list.add(resultSet.getString("threadpass"));
                    list.add(resultSet.getString("description"));
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }


    public ArrayList<ArrayList<String>> search_info (String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<ArrayList<String>> list = new ArrayList<>();
            

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    ArrayList<String> list1 = new ArrayList<>();
                    String name = resultSet.getString("name");
                    String reg = resultSet.getString("reg");
                    String email = resultSet.getString("email");
                    String hometown = resultSet.getString("hometown");
                    String bloodgroup = resultSet.getString("bloodgroup");
                    String cgpa = resultSet.getString("cgpa");
                    String semester = resultSet.getString("semester");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("pass");
                    list1.add(name);
                    list1.add(email);
                    list1.add(reg);
                    list1.add(hometown);
                    list1.add(cgpa);
                    list1.add(semester);
                    list1.add(bloodgroup);
                    list1.add(username);
                    list1.add(password);

                    list.add(list1);
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }




    public ArrayList<ArrayList<String>> feed (String thread_id,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<ArrayList<String>> list = new ArrayList<>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,thread_id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    ArrayList<String> list1 = new ArrayList<>();
                    String name = resultSet.getString("name");
                    String date = resultSet.getString("date");
                    String text = resultSet.getString("feed");
                    String time = resultSet.getString("time");
                    //String state = resultSet.getString("state");
                    //list.add(name+"\n"+date+"\n"+text+"\n");
                    list1.add(name);
                    list1.add(date);
                    list1.add(text);
                    list1.add(time);
                    //list1.add(state);
                    list.add(list1);
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }



    public ArrayList<ArrayList<String>> home_feed (String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<ArrayList<String>> list = new ArrayList<>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    ArrayList<String> list1 = new ArrayList<>();
                    String name = resultSet.getString("name");
                    String thread__id= resultSet.getString("thread_id");
                    String date = resultSet.getString("date");
                    String text = resultSet.getString("feed");
                    String time = resultSet.getString("time");
                    list1.add(name);
                    list1.add(thread__id);
                    list1.add(date);
                    list1.add(text);
                    list1.add(time);
                    list.add(list1);
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }





  public ArrayList<ArrayList<String>> deadline(String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<ArrayList<String>> list = new ArrayList<>();



            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    ArrayList<String> list1 = new ArrayList<>();
                    String thread= resultSet.getString("thread");
                    String task= resultSet.getString("task");
                    String time= resultSet.getString("tim");
                    String date = resultSet.getString("dat");
                    String description = resultSet.getString("description");

                    list1.add(thread);
                    list1.add(task);
                    list1.add(time);
                    list1.add(date);
                    list1.add(description);
                    list.add(list1);


                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }


    public ArrayList<ArrayList<String>> get_important(String reg,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<ArrayList<String>> list = new ArrayList<>();



            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,reg);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    ArrayList<String> list1 = new ArrayList<>();
                    String name = resultSet.getString("name");
                    String time = resultSet.getString("time");
                    String date = resultSet.getString("date");
                    String description = resultSet.getString("description");

                    list1.add(name);
                    list1.add(date);
                    list1.add(time);
                    list1.add(description);
                    list.add(list1);


                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }

    public static boolean check_important(String name,String date,String time ,String description,String reg,String query) throws SQLException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,date);
            preparedStatement.setString(3,time);
            preparedStatement.setString(4,description);
            preparedStatement.setString(5,reg);
            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return status;

    }






    public void update_deadline(String done,String thread,String task,String date,String description,String query){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, done);
            preparedStatement.setString(2, thread);
            preparedStatement.setString(3, task);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, description);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }








    public ArrayList<String> memberlist (String thread_id,String query){
        try{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            ArrayList<String> list = new ArrayList<String>();

            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1,thread_id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    //System.out.println(resultSet.getString("thread_id"));
                    list.add(resultSet.getString("reg"));
                }
                resultSet.close();

            } catch (Exception e) {
                // print SQL exception information
                e.printStackTrace();
            }
            return list;

        }catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

        return null;

    }


    public void UpdateRecord(String threadname,String threadyear,String threadpass,String description,String query){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, threadpass);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, threadname);
            preparedStatement.setString(4, threadyear);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }


    public void update_name_news_feed(String reg,String name,String query){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, reg);



            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}

