package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileManager {
    private File file = new File("register");
    private Logger logger = Logger.getLogger(FileManager.class.getName());

    public ArrayList<Contact> readFile() {


        Register register = null;
        if (file.isFile()) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("register"))) {
                register = (Register) read.readObject();
                read.close();
            } catch (IOException |
                    ClassNotFoundException e) {
                logger.severe("Error when trying to read from file.");
                e.printStackTrace();
            }
            return register.getRegister();
        } else return new Register().getRegister();
    }

    public synchronized void writeFile(Register register) {
        try (ObjectOutputStream saveTo = new ObjectOutputStream(new FileOutputStream("register"))){
            saveTo.writeObject(register);
            saveTo.close();
            logger.info("Saving to file.");
        } catch (IOException e) {
            logger.severe("Error when trying to write to file.");
            e.printStackTrace();
        }
    }
}
