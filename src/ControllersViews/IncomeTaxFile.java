package ControllersViews;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class IncomeTaxFile {
    StringProperty Income = new SimpleStringProperty();
    StringProperty Tax = new SimpleStringProperty();
    StringProperty NetSalary = new SimpleStringProperty();
    StringProperty userrollNum = new SimpleStringProperty();

    //constructor having all tha params
    public IncomeTaxFile(StringProperty income, StringProperty tax, StringProperty netSalary, StringProperty userrollNum) {
        Income = income;
        Tax = tax;
        NetSalary = netSalary;
        userrollNum = userrollNum;
    }

    //Empty constructor
    public IncomeTaxFile() {
        Income = new SimpleStringProperty(this,"Income");
        Tax =  new SimpleStringProperty(this,"Tax");;
        NetSalary =  new SimpleStringProperty(this,"Net Salary");
        userrollNum = new SimpleStringProperty(this,"userrollNum");
    }

    //getters and setters
    public String getIncome() {
        return Income.get();
    }

    public StringProperty incomeProperty() {
        return Income;
    }

    public void setIncome(String income) {
        this.Income.set(income);
    }


    public String getTax() {
        return Tax.get();
    }

    public StringProperty taxProperty() {
        return Tax;
    }

    public void setTax(String tax) {
        this.Tax.set(tax);
    }

    public String getNetSalary() {
        return NetSalary.get();
    }

    public StringProperty netSalaryProperty() {
        return NetSalary;
    }

    public void setNetSalary(String netSalary) {
        this.NetSalary.set(netSalary);
    }

    public String getUserrollNum() {
        return userrollNum.get();
    }

    public StringProperty userrollNumProperty() {
        return userrollNum;
    }

    public void setUserrollNum(String userrollNum) {
        this.userrollNum.set(userrollNum);
    }

    //overriding toString method
    @Override
    public String toString() {
        return "IncomeTaxFile{" +
                "Income=" + Income +
                ", Tax=" + Tax +
                ", NetSalary=" + NetSalary +
                '}';
    }
}
