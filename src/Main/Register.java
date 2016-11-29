package Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Register implements Serializable {

    private ArrayList<Contact> register = new ArrayList<>();

    public void setRegister(ArrayList<Contact> register){
        this.register = register;
    }
    public ArrayList<Contact> getRegister() {
        return register;
    }
}
