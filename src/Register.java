import java.io.Serializable;
import java.util.ArrayList;

public class Register implements Serializable {

    private ArrayList<Contact> register = new ArrayList<>();

    public ArrayList<Contact> getRegister() {
        return register;
    }
}
