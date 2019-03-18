package guiFolder;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BorderPaneClass  {

    public Scene scene;
    public BorderPane root;
    public HBox hBoxRight;
    public HBox hBoxLeft;
    public Button TestButton;


    public Scene getScene() {

        root = new BorderPane();

        hBoxLeft = new HBox(10);
        hBoxLeft.setAlignment(Pos.CENTER);
        hBoxRight = new HBox();

        TestButton = new Button("Run Tests");
        TestButton.setPrefWidth(100);

        hBoxLeft.getChildren().addAll(TestButton);

        root.setTop(hBoxLeft);

        scene = new Scene(root, 1000, 500);


        TestButton.setOnAction(this::testFunction);

        return scene;


    }

    public void testFunction(ActionEvent ev) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/All tests.xml"));
            loader.load();

        }catch (IOException e) {
           e.printStackTrace();
        }



     /*   public void initRootLayout(){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("view/sample.fxml"));
                rootLayout = loader.load();    //ошибка

                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }






}

