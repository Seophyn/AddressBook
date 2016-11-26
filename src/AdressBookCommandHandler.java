import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class AdressBookCommandHandler {
    private Register register = new Register();
    private FileManager filemanager = new FileManager();

    public void addContact(String firstName, String surName, String mail) {
        String ID = UUID.randomUUID().toString();
        Contact contact = new Contact(firstName, surName, mail, ID);
        register.getRegister().add(contact);
        System.out.println("Contact added");
    }

    public void search(String searchTerm) {

        searchTerm = searchTerm.toLowerCase();
        for (int i = 0; i < register.getRegister().size(); i++) {
            if (register.getRegister().get(i).getFirstName().toLowerCase().startsWith(searchTerm) || register.getRegister().get(i).getSurName().toLowerCase().startsWith(searchTerm)) {
                System.out.println(register.getRegister().get(i).toString());
            } else {
                System.out.println("No contacts found.");
            }
        }
    }

    public void listContacts() {
        ArrayList<Contact> tempArrayList = new ArrayList<>();
        for (int i = 0; i < register.getRegister().size(); i++) {
            tempArrayList.add(register.getRegister().get(i));
        }
        Collections.sort(tempArrayList);

        for (Contact contact :
                tempArrayList) {
            System.out.println(contact.toString());

        }
    }

    public void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }

    public void deleteContact(String ID) {
        for (int i = 0; i < register.getRegister().size(); i++) {
            if (register.getRegister().get(i).getID().equals(ID)) {
                System.out.println(register.getRegister().get(i).getFirstName() + " " + register.getRegister().get(i).getSurName() +
                        " removed from register.");
                register.getRegister().remove(i);
            }
        }
    }

    public void helpMenu() {
        System.out.println("add \t Adds a new contact to the adress book\n" +
                "delete \t Removes a contact from the adress book\n" +
                "list \t Shows a list of all current contacts in the adress book\n" +
                "quit \t Exits the program and saves adress book to file\n" +
                "search \t Shows a list of contacts matching the search term.");
    }

    public void writeRegister() {
        filemanager.writeFile(register);
    }

    public void readRegister() {
        register = filemanager.readFile();
    }

    public Register getRegister() {
        return register;
    }
}
