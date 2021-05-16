package ControllersViews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class table {

    @FXML
    private TableColumn<IncomeTaxFile, String> colIncome;

    @FXML
    private TableColumn<IncomeTaxFile, String> colTax;

    @FXML
    private TableColumn<IncomeTaxFile, String> colrollNum;

    @FXML
    private TableView<IncomeTaxFile> table;

    @FXML
    private TableColumn<IncomeTaxFile, String> colNetIncome;

    @FXML
    void showListInTable() {
        try{
            //reading data from file
            Collection<IncomeTaxFile> IncomeTaxList = Files.readAllLines(new File("IncomeTax.txt").toPath())
                    .stream()
                    .map(line -> {
                        String[] data = line.split(",");
                        //creating empty income tax object and setting its properties
                        IncomeTaxFile IncTaxObj = new IncomeTaxFile();
                        IncTaxObj.setIncome(data[0]);
                        IncTaxObj.setTax(data[1]);
                        IncTaxObj.setNetSalary(data[2]);
                        IncTaxObj.setUserrollNum(data[3]);
                        return IncTaxObj;
                    })
                    .collect(Collectors.toList());

            //creating obs list for passing in table
            ObservableList<IncomeTaxFile> IncomeTaxObsList = FXCollections.observableArrayList(IncomeTaxList);

            //setting values in table from obs list
            table.setItems(IncomeTaxObsList);
            colrollNum.setCellValueFactory(item -> item.getValue().userrollNumProperty());
            colIncome.setCellValueFactory(item -> item.getValue().incomeProperty());
            colTax.setCellValueFactory(item -> item.getValue().taxProperty());
            colNetIncome.setCellValueFactory(item -> item.getValue().netSalaryProperty());
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
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
