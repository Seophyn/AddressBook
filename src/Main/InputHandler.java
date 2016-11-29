package Main;

//todo Hantera inputs från Main.AddressBookInterface och bestäm action accordingly.
public class InputHandler {
    private CommandHandler handler;

    public InputHandler(CommandHandler handler){
        this.handler = handler;
    }

    void add(String[] userInput) {
        if (userInput.length > 4) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 4) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            handler.addContact(userInput[1], userInput[2], userInput[3]);
        }
    }
    void list(String[] userInput) {
        if (!(userInput.length == 1)) {
            System.out.println("Invalid command: List command does not take any arguments.");
        } else {
            handler.listContacts();
        }
    }
    void search(String[] userInput) {
        if (userInput.length > 2) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 2) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            handler.search(userInput[1]);
        }
    }
    void delete(String[] userInput) {
        if (userInput.length > 2) {
            System.out.println("Invalid command: Too many arguments.");
        } else if (userInput.length < 2) {
            System.out.println("Invalid command: Too few arguments.");
        } else {
            handler.deleteContact(userInput[1]);
        }
    }
    void help(){
        handler.helpMenu();
    }
    void quit(){
        handler.exitProgram();
    }
}
