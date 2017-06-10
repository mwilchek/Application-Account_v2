package Core;

import java.io.*;

public class AcctDataTracker {

    public static void outputAccounts(Object accounts) throws IOException {
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream("accounts.dat"));
        output.writeObject(accounts);
        System.out.println("A full list of accounts for this application can be found under the location where this program was saved.");
    }

    public static Object readAccounts() throws IOException, ClassNotFoundException {
        ObjectInputStream input;
        input = new ObjectInputStream(new FileInputStream("accounts.dat"));
        return input.readObject();
    }
}
