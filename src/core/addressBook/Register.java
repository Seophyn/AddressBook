package core.addressBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Register implements Serializable {

    private ArrayList<Contact> register = new ArrayList<>();

    public void setRegister(ArrayList<Contact> register) {
        this.register = register;
    }

    public ArrayList<Contact> getRegister() {
        return register;
    }

    public void addContact(String firstName, String surName, String mail) {
        Contact contact = new Contact(firstName, surName, mail);
        getRegister().add(contact);
    }

    public void deleteContact(Contact contact) {
        register.remove(contact);
    }

    public ArrayList<Contact> search(String searchTerm) {

        searchTerm = searchTerm.toLowerCase();
        ArrayList<Contact> tempArrayList = new ArrayList<>();
        for (int i = 0; i < register.size(); i++) {
            if (register.get(i).getFirstName().toLowerCase().startsWith(searchTerm) || register.get(i).getSurName().toLowerCase().startsWith(searchTerm)) {
                tempArrayList.add(register.get(i));
            }
        }
        Collections.sort(tempArrayList);
        return tempArrayList;
    }

    public ArrayList<Contact> listContacts() {
            ArrayList<Contact> tempArrayList = new ArrayList<>();
            for (int i = 0; i < register.size(); i++) {
                tempArrayList.add(register.get(i));
            }
            Collections.sort(tempArrayList);
            return tempArrayList;
            }
        }