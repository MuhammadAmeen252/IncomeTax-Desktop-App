package ControllersViews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class helpController {
    @FXML
    private Button btnCal;

    @FXML
    public void changeToMainScreen(ActionEvent event){
        try {
            Parent helpParent = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            Scene helpScene = new Scene(helpParent);

            //This gets the stage info
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(helpScene);
            window.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
