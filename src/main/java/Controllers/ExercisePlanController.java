package Controllers;

import Model.Training_plan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExercisePlanController {
    private ObservableList<Training_plan> list;
    @FXML
    private TableView<Training_plan> tableExercisePlan;

    @FXML
    private TableColumn<Object, Object> columnExercise;

    @FXML
    private TableColumn<Object, Object> columnDay;

    @FXML
    private TableColumn<Object, Object> columnTime;

    @FXML
    private TextField selectDayField;

    @FXML
    private TextField selectExerciseField;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField addAndDeleteDay;

    @FXML
    private TextField addAndDeleteExercise;

    @FXML
    private TextField addAndDeleteTime;

    @FXML
    private TextField executePlanDayField;


    @FXML
    private TextField addAdditionalExercise;


    @FXML
    private TextField addAdditionalTime;

    @FXML
    void onAddAdditionalExercise(ActionEvent event) {
        Statement statement;
        if (!addAdditionalExercise.getText().isEmpty() && !addAdditionalTime.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "INSERT INTO User_exercise(Exercise,trainingDate,trainingTime) VALUES ('" + addAdditionalExercise.getText() + "',CURDATE(),'" + addAdditionalTime.getText() + "')";
                statement.executeUpdate(sql);
                infoLabel.setText("Insert correct");
            } catch (SQLException e) {
                e.printStackTrace();
                infoLabel.setText("Invalid date");
            }
        } else {
            infoLabel.setText("You need to fill all fields");
        }
    }

    @FXML
    void onAddButton(ActionEvent event) {
        Statement statement;
        if (!addAndDeleteDay.getText().isEmpty() && !addAndDeleteTime.getText().isEmpty() && !addAndDeleteExercise.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "INSERT INTO Training_plan(Exercise,trainingDay,trainingTime) VALUES ('" + addAndDeleteExercise.getText() + "','" + addAndDeleteDay.getText() + "','" + addAndDeleteTime.getText() + "')";
                statement.executeUpdate(sql);
                infoLabel.setText("Insert correct");
            } catch (SQLException e) {
                e.printStackTrace();
                infoLabel.setText("Invalid date");
            }
        } else {
            infoLabel.setText("You need to fill all fields");
        }
    }


    @FXML
    void onDeleteButton(ActionEvent event) {
        Statement statement;
        if (!addAndDeleteDay.getText().isEmpty() && !addAndDeleteExercise.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "DELETE FROM Training_plan WHERE trainingDay='" + addAndDeleteDay.getText() + "'AND Exercise='" + addAndDeleteExercise.getText() + "'";
                statement.executeUpdate(sql);
                infoLabel.setText("Delete correct");
            } catch (SQLException e) {
                e.printStackTrace();
                infoLabel.setText("Invalid date");
            }
        } else if (!addAndDeleteDay.getText().isEmpty() && addAndDeleteExercise.getText().isEmpty()) {
            try {
                statement = LoginScreenController.connection.createStatement();
                String sql = "DELETE FROM Training_plan WHERE trainingDay='" + addAndDeleteDay.getText() + "'";
                statement.executeUpdate(sql);
                infoLabel.setText("Delete correct");
            } catch (SQLException e) {
                e.printStackTrace();
                infoLabel.setText("Invalid date");
            }
        }
    }

    @FXML
    void onExecuteButton(ActionEvent event) {
        CallableStatement statement;
        if (!executePlanDayField.getText().isEmpty())
            try {
                statement = LoginScreenController.connection.prepareCall("{call stayfit.execute_training(?)}");
                statement.setString(1, executePlanDayField.getText());
                statement.execute();
                infoLabel.setText("Executed training");
            } catch (SQLException e) {
                e.printStackTrace();
                infoLabel.setText("Invalid date");
            }
        else {
            infoLabel.setText("Choose Day and Meal");
        }
    }

    @FXML
    void onSearchButton(ActionEvent event) {
        Statement statement;
        ResultSet resultSet = null;
        String sql = null;
        list = FXCollections.observableArrayList();
        try {
            statement = LoginScreenController.connection.createStatement();
            if (selectDayField.getText().isEmpty() && selectExerciseField.getText().isEmpty()) {
                sql = "SELECT * FROM Training_plan";
            } else if (selectDayField.getText().isEmpty()) {
                sql = "SELECT * FROM Training_plan WHERE Exercise=\"" + selectExerciseField.getText() + "\"";
            } else if (selectExerciseField.getText().isEmpty()) {
                sql = "SELECT * FROM Training_plan WHERE trainingDay=\"" + selectDayField.getText() + "\"";
            } else {
                sql = "SELECT * FROM Training_plan WHERE trainigDay=\"" + selectDayField.getText() + "\" AND Exercise=\"" + selectExerciseField.getText() + "\"";
            }
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                infoLabel.setText("Invalid date");
            }
            while (resultSet.next()) {
                list.add(new Training_plan(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            infoLabel.setText("Invalid date");
        }
        columnExercise.setCellValueFactory(new PropertyValueFactory<>("Exercise"));
        columnDay.setCellValueFactory(new PropertyValueFactory<>("trainingDay"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("trainingTime"));
        tableExercisePlan.setItems(list);
    }

    @FXML
    void onBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuScreen.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
