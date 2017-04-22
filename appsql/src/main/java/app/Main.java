package app;

/**
 *
 * @author Этигэл
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/mainForm.fxml"));
        primaryStage.setTitle("CRUD App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent, 600,405));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
