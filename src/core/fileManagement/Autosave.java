package core.fileManagement;

import core.addressBook.Register;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Autosave implements Runnable {
    private Register register;
    private FileManager fileManager;
    private Logger logger = Logger.getLogger(Autosave.class.getName());

    public Autosave(Register register, FileManager fileManager) {
        this.register = register;
        this.fileManager = fileManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "InterruptedException", e);
            }

            fileManager.writeFile(register.getRegister());
        }
    }
}
