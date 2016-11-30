package core;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CommandHandler {
    private Logger logger = Logger.getLogger(CommandHandler.class.getName());
    private FileManager filemanager = new FileManager();
    Register register;

    public CommandHandler(Register register) {
        this.register = register;
    }

    public void printList(ArrayList<Contact> arrayList) {
        for (Contact contact :
                arrayList) {
            System.out.println(contact.printContact());
        }
    }
    public void printSearchList(ArrayList<Contact> arrayList){
        for (Contact contact :
                arrayList) {
            System.out.println(contact.printContact());
        }
    }

    public void exitProgram() {
        System.out.println("Exiting program.");
        logger.info("Exiting program");
        writeRegister();
        System.exit(0);
    }

    public void helpMenu() {
        System.out.println("add \t Adds a new contact to the address book\n" +
                "delete \t Removes a contact from the address book\n" +
                "list \t Shows a list of all current contacts in the address book\n" +
                "quit \t Exits the program and saves address book to file\n" +
                "search \t Shows a list of contacts matching the search term.");
    }

    public void writeRegister() {
        filemanager.writeFile(register.getRegister());
    }
}