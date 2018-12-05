package app.database;

import java.sql.*;

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
        String insert = INSERT + SKILL_TABLE + "(" +
                SKILL_NAME +","+
                SKILL_DESC
                + ") VALUES (?,?)";

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

    /*
        Adding a volunteer to the database
    */
    public int addVolunteer(String firstname, String lastname, String dob, String email,
                             String address, String city, String state, String zipcode, String phone,
                             String occupation, String employer, String volunteerGender, String license){
        int newestVolunteerID = 0;
        String insert = INSERT + VOlUNTEER_TABLE + "(" +
                VOLUNTEER_FIRSTNAME +","+
                VOLUNTEER_LASTNAME +","+
                VOLUNTEER_DOB +","+
                VOLUNTEER_EMAIL  +","+
                VOLUNTEER_ADDRESS  +","+
                VOLUNTEER_CITY +","+
                VOLUNTEER_STATE  +","+
                VOLUNTEER_ZIPCODE  +","+
                VOLUNTEER_PHONE  +","+
                VOLUNTEER_OCCUPATION  +","+
                VOLUNTEER_EMPLOYER +","+
                VOLUNTEER_GENDER +","+
                VOLUNTEER_LICENSE
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

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
            preparedStatement.setString(12, volunteerGender);
            preparedStatement.setString(13, license);
            preparedStatement.executeUpdate();

            Statement stmt = getDbConnection().createStatement();
            String sql = "SELECT volunteerID FROM volunteer ORDER BY volunteerID DESC LIMIT 1;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                newestVolunteerID = rs.getInt("volunteerID");
            }



        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB COnnection fail.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        return newestVolunteerID;

    }

    public void addToSkillIndex(int skillID, int volunteerID){

        //get the volunteer id
        String insert =  "INSERT INTO skill_index(skillID, volunteerID) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, skillID);
            preparedStatement.setInt(2, volunteerID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getSkillID(String skillname){
        String sql =  "Select skillID from skill where skillname = '"+skillname+"'";
        int skillID = 0;
        try {
            Statement stmt = getDbConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                skillID = rs.getInt("skillID");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return skillID;

    }




    //todo READ




    //todo UPDATE
    //todo Delete

}

