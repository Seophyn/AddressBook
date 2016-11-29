package Main;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact>{
    private String firstName;
    private String surName;
    private String mail;
    private String ID;

    public Contact(String firstname, String surName, String mail, String ID) {
        this.firstName = firstname;
        this.surName = surName;
        this.mail = mail;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getMail() {
        return mail;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nFirst Name: %s\nSurname: %s\nEmail: %s", this.getID(), this.getFirstName(), this.getSurName(), this.getMail() + "\n");
    }

    @Override
    public int compareTo(Contact contact) {
        return this.getFirstName().compareToIgnoreCase((contact.getFirstName()));
    }
}
