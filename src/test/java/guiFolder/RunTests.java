package guiFolder;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class RunTests extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        BorderPaneClass a = new BorderPaneClass();
        Scene b;
        b = a.getScene();
        primaryStage.setScene(b);
        primaryStage.setScene(b);
        primaryStage.show();


    }
}
