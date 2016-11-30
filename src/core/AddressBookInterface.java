package core;

import java.util.Scanner;
import java.util.logging.Logger;

public class AddressBookInterface {
    private Logger logger = Logger.getLogger(AddressBookInterface.class.getName());
    private InputHandler handler;

    public AddressBookInterface(InputHandler handler) {
        this.handler = handler;
    }

    public void menu() {
        Scanner choiceScan = new Scanner(System.in);
        System.out.println("Welcome");

        while (true) {
            String[] userInput = choiceScan.nextLine().split(" ");
            switch (userInput[0]) {
                case "add":
                    logger.fine("User Input: " + userInput[0]);
                    handler.add(userInput);
                    break;
                case "search":
                    logger.fine("User Input: " + userInput[0]);
                    handler.search(userInput);
                    break;
                case "list":
                    logger.fine("User Input: " + userInput[0]);
                    handler.list(userInput);
                    break;
                case "quit":
                    logger.fine("User Input: " + userInput[0]);
                    handler.quit();
                    break;
                case "delete":
                    logger.fine("User Input: " + userInput[0]);
                    handler.delete(userInput);
                    break;
                case "help":
                    logger.fine("User Input: " + userInput[0]);
                    handler.help();
                    break;
                default:
                    logger.fine("User Input: " + userInput[0]);
                    System.out.println("Command non-existent, please try another command or write \"help\" for a list of commands.");
                    break;
            }
        }

    }
}
