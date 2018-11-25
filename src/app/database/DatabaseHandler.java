package app.database;

import java.sql.*;
import app.database.Const;
import app.model.Volunteer;

import static app.database.Const.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        System.out.println(dbConnection.getCatalog());

        return dbConnection;
    }

    //todo Write
//    public void addVolunteer(String firstname, String lastname,
//                             String dob, String gender, String email,
//                             String phone){
//        String insert = "INSERT INTO " + VOlUNTEER_TABLE + "("+VOLUNTEER_FIRSTNAME+", "+VOLUNTEER_LASTNAME+", "+VOLUNTEER_DOB+", "+
//                VOLUNTEER_GENDER+", "+ VOLUNTEER_EMAIL+", "+ VOLUNTEER_PHONE)
//
//    }

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
        String insert = INSERT + VOlUNTEER_TABLE + "(" + SKILL_NAME +","+ SKILL_DESC + ") VALUES (?,?)";
    }


    //todo READ
    //todo UPDATE
    //todo Delete

}

