package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginScreenController {
    private String url="jdbc:mysql://localhost:3306/stayfit";
    public static Connection connection=null;

    @FXML
    private PasswordField passwrodField;

    @FXML
    private TextField logintextfield;

    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException {
        try {
            connection = DriverManager.getConnection(url, logintextfield.getText(), passwrodField.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuScreen.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene= new Scene((Parent) loader.load());
            window.setScene(scene);
            window.show();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
