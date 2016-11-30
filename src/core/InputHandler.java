package core;

//todo Hantera inputs från Main.AddressBookInterface och bestäm action accordingly.
public class InputHandler {
    private CommandHandler handler;
    private Register register;

    public InputHandler(Register register){
        this.register = register;
        handler = new CommandHandler(register);
    }

    void add(String[] userInput) {
        if (userInput.length > 4) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 4) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            register.addContact(userInput[1], userInput[2], userInput[3]);
        }
    }
    void list(String[] userInput) {
        if (!(userInput.length == 1)) {
            System.out.println("Invalid command: List command does not take any arguments.");
        } else {
            if(register.getRegister().size() > 0) {
                handler.printList(register.listContacts());
            }
            else{
                System.out.println("There are currently no contacts in the address book. ");
            }
        }
    }
    void search(String[] userInput) {
        if (userInput.length > 2) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 2) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            if(register.getRegister().size() > 0) {
                handler.printSearchList(register.search(userInput[1]));
            }

        }
    }
    void delete(String[] userInput) {
        if (userInput.length > 2) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 2) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            register.deleteContact(userInput[1]);
        }
    }
    void help(){
        handler.helpMenu();
    }
    void quit(){
        handler.exitProgram();
    }
}
