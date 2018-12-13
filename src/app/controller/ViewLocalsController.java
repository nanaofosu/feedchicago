

package app.controller;

        import app.database.DatabaseHandler;
        import app.model.Volunteer;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;

        import java.sql.ResultSet;
        import java.sql.SQLException;

        import static app.database.Const.*;

public class ViewLocalsController {

    @FXML
    private TableView<Volunteer> table;

    @FXML
    private TableColumn<Volunteer, String> firstNameCol;

    @FXML
    private TableColumn<Volunteer, String> lastNameCol;

    @FXML
    private TableColumn<Volunteer, String> emailCol;

    @FXML
    private TableColumn<Volunteer, String> phoneCol;

    private ObservableList<Volunteer> localsList = FXCollections.observableArrayList();

    public void initialize()  {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String sql = "Select firstname, lastname, email, phone FROM Locals";

        try {
            ResultSet rs = databaseHandler.getDbConnection().createStatement().executeQuery(sql);
            while(rs.next()){
                localsList.add(
                    new Volunteer(
                        rs.getString(VOLUNTEER_FIRSTNAME),
                        rs.getString(VOLUNTEER_LASTNAME),
                        rs.getString(VOLUNTEER_EMAIL),
                        rs.getString(VOLUNTEER_PHONE)
                    )
                );
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_FIRSTNAME));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_LASTNAME));
        emailCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_EMAIL));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_PHONE));

        table.setItems(localsList);

        try {
            databaseHandler.getDbConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

