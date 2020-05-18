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
import java.util.ArrayList;

public class JdbcDao {


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/classmate?autoReconnect=true&useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "mahinjibon";


    private static final String INSERT_QUERY = "INSERT INTO  registration(name,username,email,reg,pass,repeatPass) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_man_QUERY = "INSERT INTO  manage_thread(thread_id,reg) VALUES (?, ?)";
    private static final String check_query = "select *from registration where email = ? and pass = ?";
    private static final String insert = "INSERT INTO  thread (threadname,threadpass,threadyear,description,thread_id) VALUES (?, ?, ?, ?, ?)";
    private static final String get_thread ="select *from manage_thread where reg = ?";
    private static final String upd_man_thread = "UPDATE thread SET threadpass = ?, description = ? WHERE threadname = ? and threadyear = ?";
    private static final String check_thread = "select * from thread where threadname = ? and threadyear = ? and threadpass = ?";
    private static final String delete_reg = "DELETE from manage_thread WHERE reg = ?";
    private static final String check_man_thread ="select * from manage_thread WHERE thread_id = ? and reg = ? ";






    public String get_reg(String email,String query){
         String rst ="";
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
             rst = resultSet.getString("reg");
        }
        catch (Exception e){
            e.printStackTrace();
        }

       return rst;
    }


    public String get_name(String email,String query){
        String rst ="";
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                rst = resultSet.getString("name");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return rst;
    }





    public String get_about(String selected,String query){
        String rst ="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,selected);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                rst = resultSet.getString("description");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return rst;
    }


    public void insertRecord(String name, String username, String email,String reg,String pass,String repeatPass) throws SQLException {

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
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
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



    public void insertRecord_feed (String name,String reg, String thread_id, String feed,String date,String query) throws SQLException {

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



            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }



    public void insertRecord(String thread_id, String reg) throws IOException {

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
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_man_QUERY)) {
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


    public void deleteRecord(String reg) throws IOException{

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(delete_reg)) {
            preparedStatement.setString(1, reg);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            // print SQL exception information
            e.printStackTrace();
        }

    }

    public static boolean checklogin(String email,String pass) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(check_query)) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,pass);

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


    public static boolean check_email(String email,String query)  {

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

    public static boolean checkthread(String threadname,String threadyear,String threadpass) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(check_thread)) {
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

    public static boolean check_man_thread(String thread_id,String reg) throws IOException {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try(Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(check_man_thread)) {
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


    public void insertRecord(String threadname,String threadpass,String threadyear,String description,String thread_id){

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
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
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



    public ArrayList<String> threadlist (String reg){
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

                 PreparedStatement preparedStatement = connection.prepareStatement(get_thread)) {
                preparedStatement.setString(1,reg);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                  //System.out.println(resultSet.getString("thread_id"));
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




    public ArrayList<String> feed (String thread_id,String query){
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
                    String name = resultSet.getString("name");
                    String date = resultSet.getString("date");
                    String text = resultSet.getString("feed");
                    list.add(name+"\n"+date+"\n"+text+"\n");
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




    public ArrayList<String> home_feed (String thread_id, String query){
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
                    String name = resultSet.getString("name");
                    String thread__id= resultSet.getString("thread_id");
                    String date = resultSet.getString("date");
                    String text = resultSet.getString("feed");
                    list.add(name+" > "+thread__id+"\n"+date+"\n"+text+"\n");
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


    public ArrayList<String> get_all_thread (String reg, String query){
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
                    String thread_id= resultSet.getString("thread_id");
                    list.add(thread_id);
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


    public void UpdateRecord(String threadname,String threadyear,String threadpass,String description){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(upd_man_thread)) {
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
