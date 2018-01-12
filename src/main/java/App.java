import Controllers.LoginScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class App extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Stayfit");
        stage.setResizable(false);
        stage.show();
    }
    @Override
    public void stop() throws SQLException {
        if(LoginScreenController.connection!=null) {
            LoginScreenController.connection.close();
        }
    }
}

