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

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Login {

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    private TextField txtrollNumLogin;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnBackLogin;

    boolean validCredentials = false;
    String rollNum = "";
    @FXML
    void checkLoginCredentials(){
        rollNum = txtrollNumLogin.getText().trim();
        String password = txtPasswordLogin.getText().trim();
        //check if crendetials present in file
        if(!rollNum.isEmpty() && ! password.isEmpty()){
            try{
                Collection<User> userCollection = Files.readAllLines(new File("Users.txt").toPath())
                        .stream()
                        .map(line -> {
                            String[] data = line.split(",");
                            //creating empty income tax object and setting its properties
                            User userObj = new User();
                            userObj.setName(data[0]);
                            userObj.setrollNum(data[1]);
                            userObj.setPassword(data[2]);
                            return userObj;
                        })
                        .collect(Collectors.toList());

                //check if valid rollNum and password are entered
                ArrayList<User> usersList= new ArrayList<>(userCollection);
                for(int i=0 ;i<usersList.size(); i++){
                    //checking rollNum and password by redaing from list
                    if(usersList.get(i).getrollNum().trim().equalsIgnoreCase(rollNum) &&
                            usersList.get(i).getPassword().trim().equalsIgnoreCase(password)){
                        validCredentials = true;
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        //check if if valid credentials
        if(validCredentials){
            //if valid user then write its rollNum in file so that we can use it in mainController class to get rollNum of logged in user
            try{
                //we delete previous content from file if present
                FileOutputStream writer = new FileOutputStream("LoggedInUser.txt");
                //now we write user rollNum to file
                FileWriter outFile = new FileWriter("LoggedInUser.txt");
                BufferedWriter outStream = new BufferedWriter(outFile);
                outStream.write(rollNum.trim());
                outStream.newLine();
                outStream.close();

                //set text fields empty and display message
                txtrollNumLogin.setText("");
                txtPasswordLogin.setText("");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Login");
                alert.setContentText("You Logged in successFull!");
                alert.showAndWait();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        //check if not valid crdentials and not empty fields
        if (!validCredentials && !rollNum.isEmpty() && !password.isEmpty()) {
            //  Block of code to handle errors if input is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid credentials!");
            alert.setContentText("Enter valid rollNum and password!");
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
