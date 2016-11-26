import java.util.Scanner;
import java.util.logging.Logger;

public class AdressBookInterface {
    AdressBookCommandHandler handler = new AdressBookCommandHandler();
    Runnable autosave;
    Logger logger = Logger.getLogger(AdressBookInterface.class.getName());


    public void menu() {
        new LogSettings();
        logger.info("Starting program");
        handler.readRegister();

        autosave = new Autosave(handler.getRegister());
        Thread saveThread = new Thread(autosave);
        saveThread.start();

        Scanner choiceScan = new Scanner(System.in);
        System.out.println("Welcome");
        while (true) {
            String[] userInput = choiceScan.nextLine().split(" ");
            try {
                switch (userInput[0]) {
                    case "add":
                        if (userInput.length > 4 || userInput.length < 3){
                            System.out.println("Invalid command: Too many/few input variabels. ");
                            logger.fine("User input: Invalid command");
                        }
                        else {
                            logger.fine("Userinput: " + userInput[0]);
                            handler.addContact(userInput[1], userInput[2], userInput[3]);
                        }
                        break;
                    case "search":
                        logger.fine("Userinput: " + userInput[0]);
                        handler.search(userInput[1]);
                        break;
                    case "list":
                        logger.fine("Userinput: " + userInput[0]);
                        if (userInput.length == 1) {
                            handler.listContacts();
                        } else {
                            System.out.println("Invalid command");
                        }
                        break;
                    case "quit":
                        logger.fine("Userinput: " + userInput[0]);
                        logger.info("Exiting Program");
                        handler.writeRegister();
                        handler.exitProgram();
                        break;
                    case "delete":
                        logger.fine("Userinput: " + userInput[0]);
                        handler.deleteContact(userInput[1]);
                        break;
                    case "help":
                        logger.fine("Userinput: " + userInput[0]);
                        handler.helpMenu();
                        break;
                    default:
                        System.out.println("Command non-existent, please try another command or write \"help\" for a list of commands.");
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid command.");
            }
        }
    }
}
