package Controllers;

import Model.BMI_state;
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

public class BMIStateController {
    private ObservableList<BMI_state> list;
    @FXML
    private TableColumn<Object, Object> columnDate;

    @FXML
    private TableColumn<Object, Object> columnBMI;

    @FXML
    private TableColumn<Object, Object> columnDescription;

    @FXML
    private TextField selectDateField;

    @FXML
    private TableView<BMI_state> tableUser;

    @FXML
    private Label infoLabel;


    @FXML
    void onButtonSelect(ActionEvent event) {
        Statement statment = null;
        ResultSet resultSet = null;
        list = FXCollections.observableArrayList();
        try {
            statment = LoginScreenController.connection.createStatement();
            if(selectDateField.getText().isEmpty()) {
                resultSet = statment.executeQuery("SELECT * FROM BMI_state");
            }else{
                try {
                    resultSet = statment.executeQuery("SELECT * FROM BMI_state WHERE DateHistory=\""+selectDateField.getText()+"\"");
                }catch (SQLException e) {
                    infoLabel.setText("Invalid date");
                }
            }
            while (resultSet.next()) {
                list.add(new BMI_state(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getString(4)));
            }
        } catch (SQLException e) {
            infoLabel.setText("Invalid date");
        }
        columnDate.setCellValueFactory(new PropertyValueFactory<>("DateHistory"));
        columnBMI.setCellValueFactory(new PropertyValueFactory<>("BMI"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tableUser.setItems(list);
    }
    @FXML
    void onButtonBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuScreen.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
