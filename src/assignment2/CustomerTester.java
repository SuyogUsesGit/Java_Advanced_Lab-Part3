package assignment2;

import java.io.IOException;

public class CustomerTester {

    private void acceptCustomerInfo() throws IOException, ClassNotFoundException {
        System.out.println("Please enter the details of the customer: " + "\n" + "Customer ID: ");
        String custId = ReadData.acceptString();
        System.out.println("Customer Name: ");
        String custName = ReadData.acceptString();

        Customer customer = new Customer();
        customer.setName(custName);
        customer.setId(Integer.parseInt(custId));


        int status = new CustomerFileDB().saveCustomer(customer);
        if(status == 0) {
            System.out.println("Your details are saved");
            ReadData.acceptString();
            System.out.println("\n\n\n\n\n\n\n");
        } else {
            System.out.println("Your details could not be saved please try again later");
            ReadData.acceptString();
            System.out.println("\n\n\n\n\n\n\n");
        }
    }

    private void displayCustomerInfo() throws IOException, ClassNotFoundException {
        System.out.println("Please enter customer ID: ");
        String custId = ReadData.acceptString();
        Account account = new CustomerFileDB().getAccount(Integer.parseInt(custId));

        if(account != null) {
            System.out.println("\nCustomer ID: " + account.getCustomer().getId() + "\n" +
                                "Customer Name: " + account.getCustomer().getName() + "\n" +
                                "Customer Account Number: " + account.getAccountNumber() + "\n" +
                                "Customer Account Balance: " + account.getBalance() + "\n");
        } else {
            System.out.println("Invalid customer id!!!");
            ReadData.acceptString();
            System.out.println("\n\n\n\n\n\n\n");
        }
    }

    public void customerMenu() throws IOException, ClassNotFoundException{
        while(true) {
            System.out.println("\t Customer Menu");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1) Add Customer " + "\n" +
                                "2) Get Customer Info" + "\n" +
                                "3) Exit" + "\n" + "Enter Option: ");

            String optedValue = ReadData.acceptString();
            int option = Integer.parseInt(optedValue);

            switch (option) {
                case 1: acceptCustomerInfo(); break;
                case 2: displayCustomerInfo(); break;
                case 3: System.exit(0); break;
                default:
                    System.out.println("Enter a valid option");
                    ReadData.acceptString();
            }
        }
    }
}
