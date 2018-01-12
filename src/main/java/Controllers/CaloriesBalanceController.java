package Controllers;

import Model.Calories_balance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CaloriesBalanceController {
    ObservableList<Calories_balance> list;

    @FXML
    private TableView<Calories_balance> tableUser;

    @FXML
    private TableColumn<Object, Object> columnDate;

    @FXML
    private TableColumn<Object, Object> columnCalories;

    @FXML
    private TableColumn<Object, Object> columnCarbohydrate;

    @FXML
    private TableColumn<Object, Object> columnProtein;

    @FXML
    private TableColumn<Object, Object> columnFats;

    public void initialize() throws Exception {
        Statement statment = null;
        ResultSet resultSet = null;
        list = FXCollections.observableArrayList();
        try {
            statment = LoginScreenController.connection.createStatement();
            resultSet = statment.executeQuery("select * from Calories_and_nutrients_balance");
            while (resultSet.next()) {
                list.add(new Calories_balance(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6)));
                System.out.println(resultSet.getString("commitDate") + ", " +
                        resultSet.getString("Calories") + ", " +
                        resultSet.getString("Carbohydrate") + ", " +
                        resultSet.getString("Protein") + ", " +
                        resultSet.getString("Fats"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        columnDate.setCellValueFactory(new PropertyValueFactory<>("commitDate"));
        columnCalories.setCellValueFactory(new PropertyValueFactory<>("Calories"));
        columnCarbohydrate.setCellValueFactory(new PropertyValueFactory<>("Carbohydrate"));
        columnProtein.setCellValueFactory(new PropertyValueFactory<>("Protein"));
        columnFats.setCellValueFactory(new PropertyValueFactory<>("Fats"));
        tableUser.setItems(list);
    }
    @FXML
    void onButtonBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuScreen.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
