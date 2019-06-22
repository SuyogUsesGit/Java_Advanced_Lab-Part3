package assignment1;

import java.io.*;

public class CustomerFileDB {

    String file = "data\\customer.dat";


    public int saveCustomer(Customer customer) {
        int status = -1;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String data = customer.getId() + ": " + customer.getName() + "\n";
            bufferedWriter.write(data);
            bufferedWriter.flush();
            status = 0;

        }catch (IOException e) {
            status = -2;
            e.printStackTrace();
        }finally {
            if(null!=bufferedWriter) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=fileWriter) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }


    public Customer getCustomer(int customerId) {
        Customer customer = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] data = null;

            String input = bufferedReader.readLine();
            while (input!=null) {
                data = input.split(":");

                if(Integer.parseInt(data[0]) == customerId) {
                    customer = new Customer();
                    customer.setId(Integer.parseInt(data[0]));
                    customer.setName(data[1]);
                    break;
                }

                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=fileReader) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return customer;
    }
}
