package Controllers;

import Model.BMI_state;
import Model.Diet_plan;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DietPlanController {
    private ObservableList<Diet_plan> list;

    @FXML
    private TableView<Diet_plan> tableDietPlan;
    @FXML
    private TextField selectDayField;

    @FXML
    private TextField selectMealTypeField;

    @FXML
    private TextField addAndDeleteDay;

    @FXML
    private TextField addAndDeleteMealType;

    @FXML
    private TextField addAndDeleteProduct;

    @FXML
    private TextField andAndDeleteWeigh;

    @FXML
    private TableColumn<Object, Object> columnDay;

    @FXML
    private TableColumn<Object, Object> columnMealType;

    @FXML
    private TableColumn<Object, Object> columnProduct;

    @FXML
    private TableColumn<Object, Object> columnWeigh;

    @FXML
    private Label infoLabel;

    @FXML
    void onAddButton(ActionEvent event) {

    }


    @FXML
    void onDeleteButton(ActionEvent event) {

    }

    @FXML
    void onSearchButton(ActionEvent event) {
        Statement statement;
        ResultSet resultSet = null;
        String sql = null;
        list = FXCollections.observableArrayList();
        try {
            statement = LoginScreenController.connection.createStatement();
            if (selectDayField.getText().isEmpty() && selectMealTypeField.getText().isEmpty()) {
                sql = "SELECT * FROM Diet_plan";
            } else if (selectDayField.getText().isEmpty()) {
                sql = "SELECT * FROM Diet_plan WHERE Meal_type=\"" + selectMealTypeField.getText() + "\"";
            } else if (selectMealTypeField.getText().isEmpty()) {
                sql=  "SELECT * FROM Diet_plan WHERE dietDay=\"" + selectDayField.getText() + "\"";
            } else {
                sql=  "SELECT * FROM Diet_plan WHERE dietDay=\"" + selectDayField.getText() + "\" AND Meal_type=\""+selectMealTypeField.getText() + "\"";
            }
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                infoLabel.setText("Invalid date");
            }
            while (resultSet.next()) {
                list.add(new Diet_plan(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            infoLabel.setText("Invalid date");
        }
        columnDay.setCellValueFactory(new PropertyValueFactory<>("Day"));
        columnMealType.setCellValueFactory(new PropertyValueFactory<>("Meal_type"));
        columnProduct.setCellValueFactory(new PropertyValueFactory<>("Product"));
        columnWeigh.setCellValueFactory(new PropertyValueFactory<>("Weigh_of_the_product"));
        tableDietPlan.setItems(list);
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
