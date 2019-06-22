package assignment2;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CustomerFileDB {

    static class FileList implements Serializable {
        List<Account> list = new ArrayList<>();
    }

    private File file = new File("data\\account.ser");

    public int saveCustomer(Customer customer) throws ClassNotFoundException, IOException {

        FileList list = checkIfExists();

        list.list.add(new Account(customer));
        File tmp = new File("data\\account.ser.tmp");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmp))) {
            oos.writeObject(list);
        }
        Files.move(tmp.toPath(), file.toPath(), REPLACE_EXISTING);
        return 0;
    }


    public Account getAccount(int customerId) throws ClassNotFoundException, IOException{
        FileList list = checkIfExists();

        if(list.list.isEmpty()) return null;
        else for(Account account: list.list) if(account.getCustomer().getId() == customerId) return account;

        return null;
    }

    private FileList checkIfExists() throws IOException, ClassNotFoundException {
        FileList list = new FileList();
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (FileList) ois.readObject();
            }
        }
        return list;
    }
}
