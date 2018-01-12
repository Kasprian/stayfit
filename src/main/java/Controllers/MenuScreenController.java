package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuScreenController {
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
}
