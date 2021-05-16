package ControllersViews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtrollNum;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnBackRegister;


    @FXML
    void AddUserInFile(){
        String name = txtName.getText();
        String rollNum = txtrollNum.getText();
        String password = txtPassword.getText();
        if(!name.isEmpty() && !rollNum.isEmpty() && !password.isEmpty()){
            //making user object using constructor with three params
            User user = new User(name, rollNum, password);
            //writing user data in file
            try{
                FileWriter outFile = new FileWriter("Users.txt",true);
                BufferedWriter outStream = new BufferedWriter(outFile);
                outStream.write(user.getName()+ " , "+ user.getrollNum()+" , "+user.getPassword() );
                outStream.newLine();
                outStream.close();
                txtName.setText("");
                txtrollNum.setText("");
                txtPassword.setText("");

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            //  Block of code to handle errors if input is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input error!");
            alert.setContentText("Fill all the fields to register!");
            alert.showAndWait();
        }

    }
    //go to main screen
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
