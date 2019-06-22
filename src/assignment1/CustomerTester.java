package assignment1;

public class CustomerTester {

    private void acceptCustomerInfo() {
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

    private void displayCustomerInfo() {
        System.out.println("Please enter customer ID: ");
        String custId = ReadData.acceptString();
        Customer customer = new CustomerFileDB().getCustomer(Integer.parseInt(custId));

        if(customer != null) {
            System.out.println("\n Customer ID: " + customer.getId());
            System.out.println(" Customer Name: " + customer.getName() + "\n");
        } else {
            System.out.println("Invalid customer id!!!");
            ReadData.acceptString();
            System.out.println("\n\n\n\n\n\n\n");
        }
    }

    public void customerMenu() {
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
