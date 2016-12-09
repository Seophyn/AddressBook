package core;

import core.Network.Client;
import core.addressBook.AddressBookMenu;
import core.addressBook.CommandHandler;
import core.addressBook.InputHandler;
import core.addressBook.Register;
import core.fileManagement.Autosave;
import core.fileManagement.FileManager;
import core.fileManagement.LogSettings;

import java.util.logging.Logger;

public class Program {
    private Logger logger = Logger.getLogger(Program.class.getName());
    private Register register = new Register();
    private FileManager fileManager = new FileManager();
    private CommandHandler commandHandler = new CommandHandler(register, fileManager);
    private InputHandler handler = new InputHandler(commandHandler);
    private AddressBookMenu userInput = new AddressBookMenu(handler);

    public void addressBook() {
        new LogSettings();
        logger.info("Starting program");

        Runnable autosave = new Autosave(register, fileManager);
        Thread saveThread = new Thread(autosave);
        saveThread.setName("Autosave");
        saveThread.start();

        readRegister();

        Runnable alphaClient = new Client(register, 61616);
        Thread alphaClientThread = new Thread(alphaClient);
        alphaClientThread.setName("AlphaClientThread");
        alphaClientThread.start();

        /*Runnable betaClient = new Client(register, 61615);
        Thread betaClientThread = new Thread(betaClient);
        betaClientThread.setName("BetaClientThread");
        betaClientThread.start();*/

        userInput.menu();
    }

    public void readRegister() {
        register.setRegister(fileManager.readFile());
    }
}
