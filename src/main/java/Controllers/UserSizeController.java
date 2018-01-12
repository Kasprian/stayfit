package Controllers;

import Model.User_size;
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

public class UserSizeController {
    private ObservableList<User_size> list;
    @FXML
    private TextField fieldHeight;

    @FXML
    private TextField fieldWeigh;

    @FXML
    private TextField filedChest;

    @FXML
    private TextField fieldWaist;

    @FXML
    private TextField fieldHip;
    @FXML
    private TableView<User_size> tableUser;
    @FXML
    private TableColumn<Object, Object> columnDate;

    @FXML
    private TableColumn<Object, Object> columnHeight;

    @FXML
    private TableColumn<Object, Object> columnWeigh;

    @FXML
    private TableColumn<Object, Object> columnChest;

    @FXML
    private TableColumn<Object, Object> columnWaist;

    @FXML
    private TableColumn<Object, Object> columnHip;

    @FXML
    private TextField selectDateField;
    @FXML
    private Label infoLabel;

    @FXML
    void onBackButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuScreen.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
    void onButtonSelect(ActionEvent event) {
        Statement statment = null;
        ResultSet resultSet = null;
        list = FXCollections.observableArrayList();
        try {
            statment = LoginScreenController.connection.createStatement();
            if(selectDateField.getText().isEmpty()) {
                resultSet = statment.executeQuery("SELECT * FROM User_size");
            }else{
                try {
                    resultSet = statment.executeQuery("SELECT * FROM User_size WHERE commitDate=\""+selectDateField.getText()+"\"");
                }catch (SQLException e) {
                    infoLabel.setText("Invalid date");
                }
            }
            while (resultSet.next()) {
                list.add(new User_size(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6),resultSet.getInt(7)));
            }
        } catch (SQLException e) {
                infoLabel.setText("Invalid date");
        }
        columnDate.setCellValueFactory(new PropertyValueFactory<>("commitDate"));
        columnHeight.setCellValueFactory(new PropertyValueFactory<>("Height"));
        columnWeigh.setCellValueFactory(new PropertyValueFactory<>("Weigh"));
        columnChest.setCellValueFactory(new PropertyValueFactory<>("Chest_size"));
        columnWaist.setCellValueFactory(new PropertyValueFactory<>("Waist_size"));
        columnHip.setCellValueFactory(new PropertyValueFactory<>("Hip_size"));
        tableUser.setItems(list);
    }

    @FXML
    void onButtonInsert(ActionEvent event) {
        Statement statment = null;
        list = FXCollections.observableArrayList();
        try {
            statment = LoginScreenController.connection.createStatement();
            String sql="INSERT INTO User_size(commitDate ,HEIGHT ,WEIGH ,CHEST_SIZE ,WAIST_SIZE,HIP_SIZE) VALUES (CURDATE(),"+
                    fieldHeight.getText()+","+
                    fieldWeigh.getText()+","+
                    filedChest.getText()+","+
                    fieldWaist.getText()+","+
                    fieldHip.getText()+")";
            statment.executeUpdate(sql);
            infoLabel.setText("Insert correct");
        } catch (SQLException e) {
            infoLabel.setText("Invalid date");
        }
        if(selectDateField.getText().isEmpty())
        System.out.println("there is null");
    }
}
