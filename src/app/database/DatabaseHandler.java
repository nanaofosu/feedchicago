package app.database;

import app.model.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;

import static app.database.Const.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
//        System.out.println(dbConnection.getCatalog());

        return dbConnection;
    }

    //todo Write

    public void addSkill(String name, String description){
        String insert = INSERT + SKILL_TABLE + "(" + SKILL_NAME +","+ SKILL_DESC + ") VALUES (?,?)";

        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB COnnection fail.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addVolunteer(String firstname, String lastname, String dob, String email,
                             String address, String city, String state, String zipcode, String phone,
                             String occupation, String employer){
        String insert = INSERT + VOlUNTEER_TABLE + "(" + VOLUNTEER_FIRSTNAME +","+ VOLUNTEER_LASTNAME
                +","+ VOLUNTEER_DOB +","+ VOLUNTEER_EMAIL  +","+ VOLUNTEER_ADDRESS  +","+ VOLUNTEER_CITY
                +","+ VOLUNTEER_STATE  +","+ VOLUNTEER_ZIPCODE  +","+ VOLUNTEER_PHONE  +","+
                VOLUNTEER_OCCUPATION  +","+ VOLUNTEER_EMPLOYER
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, state);
            preparedStatement.setString(8, zipcode);
            preparedStatement.setString(9, phone);
            preparedStatement.setString(10, occupation);
            preparedStatement.setString(11, employer);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB COnnection fail.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //todo READ




    //todo UPDATE
    //todo Delete

}

