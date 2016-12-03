package core.addressBook;

import core.fileManagement.FileManager;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CommandHandler {
    private Logger logger = Logger.getLogger(CommandHandler.class.getName());
    private FileManager filemanager = new FileManager();
    private Register register;

    public CommandHandler(Register register) {
        this.register = register;
    }

    public void printAdd(){
        System.out.println("Contact added");
    }

    public void delete(String ID){
        boolean deletedContact = false;
        for (int i = 0; i < register.getRegister().size(); i++) {
            if (register.getRegister().get(i).getID().equals(ID)) {
                System.out.println(register.getRegister().get(i).getFirstName() + " " + register.getRegister().get(i).getSurName() +
                        " removed from register.");
                register.deleteContact(register.getRegister().get(i));
                deletedContact = true;
            }
        }
        if (!deletedContact) {
            System.out.println("No contact found with that ID");
        }
    }

    public void printList(ArrayList<Contact> arrayList) {
        for (Contact contact :
                arrayList) {
            System.out.println(contact.printContact());
        }
    }

    public void printSearchList(ArrayList<Contact> arrayList){
        if(!(arrayList.isEmpty())){
        for (Contact contact :
                arrayList) {
            System.out.println(contact.printContact());
        }
        } else{
            System.out.println("No contacts found. Try another search term. ");
        }
    }

    public void exitProgram() {
        System.out.println("Exiting program.");
        logger.info("Exiting program");
        filemanager.writeFile(register.getRegister());
        System.exit(0);
    }

    public void helpMenu() {
        System.out.println("add \t Adds a new contact to the address book\n" +
                "delete \t Removes a contact from the address book\n" +
                "list \t Shows a list of all current contacts in the address book\n" +
                "quit \t Exits the program and saves address book to file\n" +
                "search \t Shows a list of contacts matching the search term.");
    }
}