package core.addressBook;

import java.util.Scanner;
import java.util.logging.Logger;

public class AddressBookMenu {
    private Logger logger = Logger.getLogger(AddressBookMenu.class.getName());
    private InputHandler handler;

    public AddressBookMenu(InputHandler handler) {
        this.handler = handler;
    }

    public void menu() {
        Scanner choiceScan = new Scanner(System.in);
        System.out.println("Welcome! Type 'help' to show a list of available commands.");


        while (true) {
            String logString = "";
            String[] userInput = choiceScan.nextLine().split(" ");
            for (int i = 0; i < userInput.length; i++) {
                logString += userInput[i] + " ";
            }

            switch (userInput[0]) {
                case "add":
                    logger.fine("User Input: " + logString);
                    handler.add(userInput);
                    break;
                case "search":
                    logger.fine("User Input: " + logString);
                    handler.search(userInput);
                    break;
                case "list":
                    logger.fine("User Input: " + logString);
                    handler.list(userInput);
                    break;
                case "delete":
                    logger.fine("User Input: " + logString);
                    handler.delete(userInput);
                    break;
                case "help":
                    logger.fine("User Input: " + logString);
                    handler.help(userInput);
                    break;
                case "quit":
                    logger.fine("User Input: " + logString);
                    handler.quit();
                    break;
                default:
                    logger.fine("Invalid User Input: " + logString);
                    System.out.println("Command non-existent, please try another command or write \"help\" for a list of commands.");
                    break;
            }
        }
    }
}
