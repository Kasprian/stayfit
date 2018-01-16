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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;

public class CaloriesBalanceController {
    ObservableList<Calories_balance> list;
    @FXML
    private TableColumn<Object, Object> sourceColumn;
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

    @FXML
    private TextField searchField;

    @FXML
    private RadioButton GroupRadioButton;

    @FXML
    private RadioButton GoodRadioButton;

    @FXML
    private RadioButton ExerciseRadioButton;

    @FXML
    private DatePicker datePicker;

    public void initialize() throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        list = FXCollections.observableArrayList();
        try {
            statement = LoginScreenController.connection.createStatement();
            resultSet = statement.executeQuery("select * from Calories_and_nutrients_balance");
            while (resultSet.next()) {
                list.add(new Calories_balance(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("sources"));
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
    @FXML
    void onSearchButton(ActionEvent event) {
        Statement statement = null;
        ResultSet resultSet = null;
        String sql=null;
        list = FXCollections.observableArrayList();
        try {
            statement = LoginScreenController.connection.createStatement();
            System.out.println(datePicker.getValue());
            if(datePicker.getValue()==null && !GroupRadioButton.isSelected() && !GoodRadioButton.isSelected() && !ExerciseRadioButton.isSelected()) {
                sql="select * from Calories_and_nutrients_balance";
            }else if(datePicker.getValue()==null && GroupRadioButton.isSelected() && !GoodRadioButton.isSelected() && !ExerciseRadioButton.isSelected()){
                sql="select id,sources,commitDate,SUM(calories),SUM(carbohydrate),SUM(protein),SUM(fats) from Calories_and_nutrients_balance GROUP BY commitDate";
            }
            try {
                resultSet = statement.executeQuery(sql);
            }catch (SQLException e) {
                    System.out.println("Invalid date");
                }
            while (resultSet.next()) {
                list.add(new Calories_balance(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("sources"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("commitDate"));
        columnCalories.setCellValueFactory(new PropertyValueFactory<>("Calories"));
        columnCarbohydrate.setCellValueFactory(new PropertyValueFactory<>("Carbohydrate"));
        columnProtein.setCellValueFactory(new PropertyValueFactory<>("Protein"));
        columnFats.setCellValueFactory(new PropertyValueFactory<>("Fats"));
        tableUser.setItems(list);
    }

}
