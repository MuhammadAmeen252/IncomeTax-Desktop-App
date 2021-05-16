package ControllersViews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        primaryStage.setTitle("Income Tax App");
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add("./ControllersViews/styleSheet.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        //we delete previous content from file if present
        FileOutputStream writer = new FileOutputStream("LoggedInUser.txt");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
