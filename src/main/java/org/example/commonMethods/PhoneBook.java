package org.example.commonMethods;

import java.util.LinkedList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contactsList;

    private String name;

    public PhoneBook(String name){
        contactsList = new LinkedList<>();
        this.name = name;
    }

    public void addContact(Name name, PhoneNumber phoneNumber){
        Contact contact = new Contact(name, phoneNumber);
        contactsList.add(contact);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("{ ");
        for (Contact c: contactsList) {
            stringBuilder.append(c);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
