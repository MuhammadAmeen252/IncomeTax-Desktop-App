package ControllersViews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class mainController {
    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTax;

    @FXML
    private TextField txtNetSal;

    //here we store our objects of Income Tax class that we create
    ArrayList<IncomeTax> IncomeTaxObjectList = new ArrayList<IncomeTax>();
    double Income, netIncome, Tax;

    @FXML
    void mainFunc() {
        txtNetSal.setStyle("-fx-opacity: 1.0;");
        txtTax.setStyle("-fx-opacity: 1.0;");
        try {
            //  Block of code to try
            //if input field is not empty
            if(!txtSalary.getText().isEmpty()){
                Income = Double.parseDouble(txtSalary.getText());
                // Creating Obj of Income Tax Type to calculate tax and get its value
                //here we single parameter constructor
                IncomeTax IncometaxObj = new IncomeTax(Income);
                //first we calculate tax then we get its and netIncome value
                IncometaxObj.calculateTax();
                Tax = IncometaxObj.getTotalTax();
                netIncome = IncometaxObj.getNetSal();

                //getting rollNum from file if user is logged in
                //if user is logged in we have value of rollNum else null
                String rollNumOfLoggedInUser = null;
                try {
                    File myObj = new File("LoggedInUser.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        rollNumOfLoggedInUser = myReader.nextLine();
                    }
                    myReader.close();


                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


                //Here i am using polymorphism technique as i am crating Income tax object and passing here rollNum of user
                //i.e from super class of user that i have inherited in IncomeTax
                //since polymorphism is ability of object taking many forms so here our Income Tax Obj is taking new
                //form by creating object with rollNum parameter
                IncomeTax UserIncomeObject = new IncomeTax(rollNumOfLoggedInUser, Income, Tax, netIncome);
                //here we added our object to array list
                IncomeTaxObjectList.add(UserIncomeObject);
                //setting values in text fields
                txtTax.setText(String.valueOf(Tax));
                txtNetSal.setText((String.valueOf(netIncome)));
                System.out.println("rollNum:"+rollNumOfLoggedInUser);
                try{
                    //here we write the object create above in txt file whenever user clicks calculate it automatically saves in txt file
                    FileWriter outFile = new FileWriter("IncomeTax.txt",true);
                    BufferedWriter outStream = new BufferedWriter(outFile);
                    //Noew here i am using polymorphic function from mu IncomeTax Class which i also created in User class
                        outStream.write(UserIncomeObject.getUserIncomeTaxDetails()) ;
                        outStream.newLine();
                    outStream.close();

                }catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        catch(Exception e) {
            //  Block of code to handle errors if input is invalid
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Income error!");
            alert.setContentText("Income should be in numbers");
            alert.showAndWait();
        }

    }

    public ArrayList<IncomeTax> getIncomeTaxObjectList() {
        return IncomeTaxObjectList;
    }

    public void setIncomeTaxObjectList(ArrayList<IncomeTax> incomeTaxObjectList) {
        IncomeTaxObjectList = incomeTaxObjectList;
    }

    //This is function to switch between scenes i.e to go to help screen
    @FXML
    public void changeToHelpScreen(ActionEvent event){
        try {
            Parent helpParent = FXMLLoader.load(getClass().getResource("help.fxml"));
            Scene helpScene = new Scene(helpParent);

            //This gets the stage info
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(helpScene);
            window.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    //function to change to table screen
    @FXML
    public void changeToTableScreen(ActionEvent event){
        try {
            Parent helpParent = FXMLLoader.load(getClass().getResource("Table.fxml"));
            Scene helpScene = new Scene(helpParent);

            //This gets the stage info
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(helpScene);
            window.show();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    //change to Register screen
    @FXML
    public void changeToRegisterScreen(ActionEvent event){
        try {
            Parent helpParent = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
            Scene helpScene = new Scene(helpParent);

            //This gets the stage info
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(helpScene);
            window.show();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    //change to Login screen
    @FXML
    public void changeToLoginScreen(ActionEvent event){
        try {
            Parent helpParent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
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
