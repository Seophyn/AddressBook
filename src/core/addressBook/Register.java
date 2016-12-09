package core.addressBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Register implements Serializable {

    private ArrayList<Contact> register = new ArrayList<>();
    private ArrayList<Contact> externalRegister = new ArrayList<>();

    public void setRegister(ArrayList<Contact> register) {
        this.register = register;
    }

    public ArrayList<Contact> getRegister() {
        return register;
    }

    public ArrayList<Contact> getExternalRegister() {
        return externalRegister;
    }

    public void addContact(String firstName, String surName, String mail) {
        Contact contact = new Contact(firstName, surName, mail);
        getRegister().add(contact);
    }

    public synchronized void addServerContact(String ID, String firstName, String surName, String mail) {
        Contact contact = new Contact(ID, firstName, surName, mail);
        getExternalRegister().add(contact);
    }

    public void deleteContact(Contact contact) {
        register.remove(contact);
    }

    public ArrayList<Contact> search(String searchTerm) {

        searchTerm = searchTerm.toLowerCase();
        ArrayList<Contact> tempArrayList = new ArrayList<>();
        ArrayList<Contact> foundContacts = new ArrayList<>();

        tempArrayList.addAll(externalRegister);
        tempArrayList.addAll(register);
        Collections.sort(tempArrayList);

        for (int i = 0; i < tempArrayList.size(); i++) {
            if (tempArrayList.get(i).getFirstName().toLowerCase().startsWith(searchTerm) || tempArrayList.get(i).getSurName().toLowerCase().startsWith(searchTerm)) {
                foundContacts.add(tempArrayList.get(i));
            }
        }
        return foundContacts;
    }
    public ArrayList<Contact> listContacts() {
        ArrayList<Contact> tempArrayList = new ArrayList<>();

        tempArrayList.addAll(register);
        tempArrayList.addAll(externalRegister);

        Collections.sort(tempArrayList);

        return tempArrayList;
    }
}