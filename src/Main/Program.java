package Main;//todo "huvud-delen" av programmet som Main.Main skickar till. Hanterar initialization av programmet och skickar sedan vidare till menyn.

import java.util.logging.Logger;

public class Program {
    private Logger logger = Logger.getLogger(Program.class.getName());
    private CommandHandler comHandler = new CommandHandler();
    private AddressBookInterface userInput = new AddressBookInterface(comHandler);
    private Runnable autosave;

    public void AddressBook(){
        LogSettings logSettings = new LogSettings();
        logSettings.setupLogging();
        autosave = new Autosave(comHandler.getRegister());
        Thread saveThread = new Thread(autosave);
        saveThread.setName("Autosave");
        saveThread.start();



        logger.info("Starting program");
        comHandler.readRegister();
        userInput.menu();
    }
}
