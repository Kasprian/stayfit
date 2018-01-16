package Controllers;

import Model.Exercise_calories;
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

public class AddExerciseController {
    private ObservableList<Exercise_calories> list;
    @FXML
    private TableView<Exercise_calories> tableExercise;

    @FXML
    private TableColumn<Object, Object> columnExercise;

    @FXML
    private TableColumn<Object, Object> columnCalories;

    @FXML
    private TextField selectExerciseField;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField exerciseAddField;

    @FXML
    private TextField CaloriesAddField;

    @FXML
    private TextField exerciseDeleteField;

    @FXML
    void onAddButton(ActionEvent event) {
        Statement statement;
        if (!exerciseAddField.getText().isEmpty() && !CaloriesAddField.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "INSERT INTO Exercise_calories(Exercise,Calories_per_hour) VALUES ('" + exerciseAddField.getText() + "','" + CaloriesAddField.getText() + "')";
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
    void onButtonBack(ActionEvent event) throws IOException {
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
            if (selectExerciseField.getText().isEmpty()) {
                sql = "SELECT * FROM Exercise_calories";
            } else if (!selectExerciseField.getText().isEmpty()) {
                sql = "SELECT * FROM Exercise_calories WHERE Exercise='" + selectExerciseField.getText() + "'";
            }
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                infoLabel.setText("Invalid date");
            }
            try {
                while (resultSet.next()) {
                    list.add(new Exercise_calories(resultSet.getString(1), resultSet.getInt(2)));
                }
            }catch(NullPointerException e){

            }
        } catch (SQLException e) {
            infoLabel.setText("Invalid date");
        }
        columnExercise.setCellValueFactory(new PropertyValueFactory<>("Exercise"));
        columnCalories.setCellValueFactory(new PropertyValueFactory<>("Calories_per_hour"));
        tableExercise.setItems(list);
    }

    @FXML
    void onDeleteButton(ActionEvent event) {
        Statement statement;
        if (!exerciseDeleteField.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "DELETE FROM Exercise_calories WHERE Exercise='" + exerciseDeleteField.getText() + "'";
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
