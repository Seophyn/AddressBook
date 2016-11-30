package core;//todo "huvud-delen" av programmet som Main.Main skickar till. Hanterar initialization av programmet och skickar sedan vidare till menyn.

import java.util.logging.Logger;

public class Program {
    private Logger logger = Logger.getLogger(Program.class.getName());
    private Register register = new Register();
    private InputHandler handler = new InputHandler(register);
    private AddressBookInterface userInput = new AddressBookInterface(handler);
    private FileManager fileManager = new FileManager();

    public void AddressBook(){
        LogSettings logSettings = new LogSettings();
        logSettings.setupLogging();

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
