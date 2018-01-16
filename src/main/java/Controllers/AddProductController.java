package Controllers;

import Model.Food_calories;
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

public class AddProductController {
    private ObservableList<Food_calories> list;
    @FXML
    private TextField productDeleteField;

    @FXML
    private TableView<Food_calories> tableExercise;

    @FXML
    private TableColumn<Object, Object> columnProduct;

    @FXML
    private TableColumn<Object, Object> columnCalories;

    @FXML
    private TableColumn<Object, Object> columnCarbohydrate;

    @FXML
    private TableColumn<Object, Object> columnProtein;

    @FXML
    private TableColumn<Object, Object> columnFats;

    @FXML
    private TextField selectProductField;

    @FXML
    private TextField productField;

    @FXML
    private TextField caloriesField;

    @FXML
    private TextField carbohydrateField;

    @FXML
    private TextField proteinField;

    @FXML
    private TextField fatsField;

    @FXML
    void onAddButton(ActionEvent event) {
        Statement statement;
        if (!productField.getText().isEmpty() && !caloriesField.getText().isEmpty()&& !carbohydrateField.getText().isEmpty()&& !proteinField.getText().isEmpty()&& !fatsField.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "INSERT INTO Food_calories_and_nutrients(Product,Calories_per_100gram,Carbohydrate_per_100gram,Protein_per_100gram,Fats_per_100gram) VALUES ('" + productField.getText() + "','" + caloriesField.getText()+"','" + carbohydrateField.getText() +"','" + proteinField.getText() +"','" + fatsField.getText() +  "')";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Invalid date!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all fields!");
            alert.showAndWait();
        }
    }

    @FXML
    void onButtonBack(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuScreen.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onButtonSelect(ActionEvent event) {
        Statement statement;
        ResultSet resultSet = null;
        String sql = null;
        list = FXCollections.observableArrayList();
        try {
            statement = LoginScreenController.connection.createStatement();
            if (selectProductField.getText().isEmpty()) {
                sql = "SELECT * FROM Food_calories_and_nutrients";
            } else if (!selectProductField.getText().isEmpty()) {
                sql = "SELECT * FROM Food_calories_and_nutrients WHERE Product='" + selectProductField.getText() + "'";
            }
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Invalid date!");
                alert.showAndWait();
            }
            try{
            while (resultSet.next()) {
                list.add(new Food_calories(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5)));
            }}catch(NullPointerException e){
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid date!");
            alert.showAndWait();
        }
        columnProduct.setCellValueFactory(new PropertyValueFactory<>("Product"));
        columnCalories.setCellValueFactory(new PropertyValueFactory<>("Calories_per_100gram"));
        columnCarbohydrate.setCellValueFactory(new PropertyValueFactory<>("Carbohydrate_per_100gram"));
        columnProtein.setCellValueFactory(new PropertyValueFactory<>("Protein_per_100gram"));
        columnFats.setCellValueFactory(new PropertyValueFactory<>("Fats_per_100gram"));
        tableExercise.setItems(list);
    }

    @FXML
    void onDeleteButton(ActionEvent event) {
        Statement statement;
        if (!productDeleteField.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "DELETE FROM Food_calories_and_nutrients WHERE Product='" + productDeleteField.getText() + "'";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Delete incorrect!");
                alert.showAndWait();
            }
        }
    }

}
