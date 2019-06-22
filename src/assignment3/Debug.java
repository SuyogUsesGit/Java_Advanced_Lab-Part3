package assignment3;

import java.io.*;

public class Debug {

    private static final String fileName = "data.ser";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Customer customer = new Customer(1001, "Tan");

        SavingAccount sb1 = new SavingAccount(9001, customer, 2000, 5, 1000);

        // Serialization (saving object)
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(sb1);
            System.out.println("Object Saved" + "\n");
        }

        // Deserializing SavingAccount Object
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            SavingAccount temp = (SavingAccount) objectInputStream.readObject();
            System.out.println("Retreiving Saved Object: " + "\n");
            printDetails(temp);
        }


    }

    private static void printDetails(SavingAccount temp) {
        System.out.println("Account Number: " + temp.getAccountNumber() + "\n" +
                            "Customer Name: " + temp.getCustomer().getName() + "\n" +
                            "Customer ID: " + temp.getCustomer().getId() + "\n" +
                            "Balance: " + temp.getBalance() + "\n" +
                            "Rate of Interest: " + temp.getRateOfInterest() + "\n" +
                            "Minimum Balance: " + temp.getMinimumBalance());
    }
}
