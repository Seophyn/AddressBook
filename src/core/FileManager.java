package core;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileManager {
    private File file = new File("register");
    private Logger logger = Logger.getLogger(FileManager.class.getName());

    @SuppressWarnings("unchecked")
    public ArrayList<Contact> readFile() {
        ArrayList<Contact> register = null;
        if (file.isFile()) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("register"))) {
                    register = (ArrayList<Contact>) read.readObject();
            } catch (IOException |
                    ClassNotFoundException e) {
                logger.severe("Error when trying to read from file.");
                e.printStackTrace();
            }
            return register;
        } else return new Register().getRegister();
    }

    public synchronized void writeFile(ArrayList<Contact> register) {
        try (ObjectOutputStream saveTo = new ObjectOutputStream(new FileOutputStream("register"))){
            saveTo.writeObject(register);
            logger.info("Saving to file.");
        } catch (IOException e) {
            logger.severe("Error when trying to write to file.");
            e.printStackTrace();
        }
    }
}
