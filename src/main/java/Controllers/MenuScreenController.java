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



public class MenuScreenController  {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;
    @FXML
    void goToDietPlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DietPlanScreen.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goToExercisePlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExercisePlanScreen.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goToSeeYourBMI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BMIStateScreen.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goToYourCaloriesBalance(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Calories_balance.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goToYourSize(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserSizeScreen.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onAddExercise(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddExercise.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onAddProduct(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddProduct.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene= new Scene((Parent) loader.load());
        window.setScene(scene);
        window.show();
    }
    @FXML
    void onCreateBackup(ActionEvent event)  {
        try {
            String executeCmd = "mysqldump -u" +loginField.getText()+ " -p" + passwordField.getText() + " --routines --add-drop-database -B stayfit -r C:\\Users\\Piotrek\\Desktop\\stayfit.sql";

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }

    @FXML
    void onRestoreBackup(ActionEvent event) {
        String[] restoreCmd = new String[]{"mysql ", "--user=" + loginField.getText(), "--password=" +  passwordField.getText(), "-e", "source " + "C:/Users/Piotrek/Desktop/stayfit.sql"};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(restoreCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Restored successfully!");
            } else {
                System.out.println("Could not restore the backup!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error at Restore" + ex.getMessage());
        }
    }

}
