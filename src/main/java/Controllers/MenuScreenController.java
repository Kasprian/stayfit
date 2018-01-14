package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;


public class MenuScreenController extends Component {
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
    void onCreateBackup(ActionEvent event)  {
        try {

        /*NOTE: Getting path to the Jar file being executed*/
        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = MenuScreenController.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();


        /*NOTE: Creating Database Constraints*/
            String dbName = "stayfit";
            String dbUser = "root";
            String dbPass = "inspiron1423";

        /*NOTE: Creating Path Constraints for folder saving*/
        /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "\\backup";

        /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

        /*NOTE: Creating Path Constraints for backup saving*/
        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";

        /*NOTE: Used to create a cmd command*/
            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --add-drop-database -B " + dbName + " -r C:\\Users\\Piotrek\\Desktop\\stayfit\\stayfit.sql";

        /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }

    @FXML
    void onRestoreBackup(ActionEvent event) {
        String[] restoreCmd = new String[]{"mysql ", "-u root -p inspiron1423 ","-e source", "C:\\Users\\Piotrek\\Desktop\\stayfit.sql"};
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
            ex.printStackTrace();
        }
    }
}
