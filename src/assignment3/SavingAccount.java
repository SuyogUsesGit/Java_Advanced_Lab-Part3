package assignment3;

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {

    private float rateOfInterest;
    private double minimumBalance;

    public SavingAccount(int accountNumber, Customer customer, double balance, float rateOfInterest, double minimumBalance) {
        super(accountNumber, customer, balance);
        this.rateOfInterest = rateOfInterest;
        this.minimumBalance = minimumBalance;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
