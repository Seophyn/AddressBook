package core;

import core.addressBook.AddressBookMenu;
import core.addressBook.InputHandler;
import core.addressBook.Register;
import core.fileManagement.Autosave;
import core.fileManagement.FileManager;
import core.fileManagement.LogSettings;

import java.util.logging.Logger;

public class Program {
    private Logger logger = Logger.getLogger(Program.class.getName());
    private Register register = new Register();
    private InputHandler handler = new InputHandler(register);
    private AddressBookMenu userInput = new AddressBookMenu(handler);
    private FileManager fileManager = new FileManager();

    public void AddressBook(){
        new LogSettings();

        Runnable autosave = new Autosave(register);
        Thread saveThread = new Thread(autosave);
        saveThread.setName("Autosave");
        saveThread.start();

        logger.info("Starting program");
        readRegister();
        userInput.menu();
    }

    public void readRegister() {
        register.setRegister(fileManager.readFile());
    }
}
