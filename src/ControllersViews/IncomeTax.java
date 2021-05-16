package ControllersViews;

import javafx.fxml.FXML;

public class IncomeTax extends User{
    //These are the attributes that are used in this class
    private double TaxIncome;
    private double totalTax;
    private double netSal;

    //constructor for single parameter that sets our passed income equals to TaxIncome varibale in this class
    public IncomeTax(double income) {
        super();
        this.TaxIncome = income;
    }

    //constructor with income attribute
    public IncomeTax(String name, String rollNum,double income ) {
        super(name,rollNum);
        this.TaxIncome = income;
    }

    //constructor with income, tax, netSal and super class attribute rollNum
    public IncomeTax(String rollNum, double income, double tax, double netIncome) {
        super(rollNum);
        this.TaxIncome = income;
        this.totalTax = tax;
        this.netSal = netIncome;
    }

    //This is constructor used to store obj of IncomeTax in arraylist that has all three attributes
    public IncomeTax(double income, double tax, double netIncome) {
        this.TaxIncome = income;
        this.totalTax = tax;
        this.netSal = netIncome;
    }

    //This is our Empty constructor
    public IncomeTax() {
        this.TaxIncome = 0.0;
        this.totalTax = 0.0;
        this.netSal = 0.0;
    }

    //method to find which total tax according to income
    @FXML
    public void calculateTax() {
        // Note: this is only for single tax payers not for married etc.

        // we use if else conditions to differentiate different tax payers and calculate tax according to their income range
        if (TaxIncome <= 9325) {
            //here we pas our lower income, higher income, tax percentage and total income in paramaters of our taxBracket function
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);

        } else if (TaxIncome <= 37950) {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);

        } else if (TaxIncome <= 91900) {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);
            totalTax += taxBaracket(37950, 91900, 25.00, TaxIncome);

        } else if (TaxIncome <= 191650) {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);
            totalTax += taxBaracket(37950, 91900, 25.00, TaxIncome);
            totalTax += taxBaracket(91900, 191650, 28.00, TaxIncome);

        } else if (TaxIncome <= 416700) {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);
            totalTax += taxBaracket(37950, 91900, 25.00, TaxIncome);
            totalTax += taxBaracket(91900, 191650, 28.00, TaxIncome);
            totalTax += taxBaracket(191650, 416700, 33.00, TaxIncome);

        } else if (TaxIncome <= 418400) {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);
            totalTax += taxBaracket(37950, 91900, 25.00, TaxIncome);
            totalTax += taxBaracket(91900, 191650, 28.00, TaxIncome);
            totalTax += taxBaracket(191650, 416700, 33.00, TaxIncome);
            totalTax += taxBaracket(416700, 418400, 35.00, TaxIncome);

        } else {
            totalTax += taxBaracket(0, 9325, 10.00, TaxIncome);
            totalTax += taxBaracket(9325, 37950, 15.00, TaxIncome);
            totalTax += taxBaracket(37950, 91900, 25.00, TaxIncome);
            totalTax += taxBaracket(91900, 191650, 28.00, TaxIncome);
            totalTax += taxBaracket(191650, 416700, 33.00, TaxIncome);
            totalTax += taxBaracket(416700, 418400, 35.00, TaxIncome);
            totalTax += taxBaracket(418400, Integer.MAX_VALUE, 39.60, TaxIncome);

        }

        //calculating net Income
        netSal = TaxIncome - totalTax;
    }

    //function to calculate value of tax
    private static double taxBaracket(int lower, int higher, double rate, double totalincome) {
        double tax = 0.0;
        double usingcalculatortax = 0;
        if (totalincome > higher)
            usingcalculatortax = higher;
        else
            usingcalculatortax = totalincome;
        //formula to calculate tax applicable on income
        tax = ((double) usingcalculatortax - (double) lower) * rate / 100;

        return tax;
    }

    //getters and setters for our attributes of class

    public double getTaxIncome() {
        return TaxIncome;
    }

    public void setTaxIncome(double taxIncome) {
        TaxIncome = taxIncome;
    }

    public double getTotalTax() {
        return Math.round((totalTax*100)/100);
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getNetSal() {
        return Math.round((netSal*100)/100);
    }

    public void setNetSal(double netSal) {
        this.netSal = netSal;
    }

    //This is our equals method to comapare objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeTax incomeTax = (IncomeTax) o;
        return Double.compare(incomeTax.TaxIncome, TaxIncome) == 0 && Double.compare(incomeTax.totalTax, totalTax) == 0 && Double.compare(incomeTax.netSal, netSal) == 0;
    }

    //This is our to String method to return string of values of our attributes results
    @Override
    public String toString() {
        return "IncomeTax{" +
                "TaxIncome=" + TaxIncome +
                ", totalTax=" + totalTax +
                ", netSal=" + netSal +
                '}';
    }

    //we have this method in user class too we also use it here to apply polymorphism
    public String getUserIncomeTaxDetails(){
        return String.valueOf(getTaxIncome())+" , "+ String.valueOf(getTotalTax())+
                " , "+ String.valueOf(getNetSal())+" , "+getrollNum();
    }
}
