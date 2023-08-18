package org.example.commonMethods;

import java.util.Objects;

public class Contact implements Cloneable, Comparable<Contact> {

    private Name name;
    private PhoneNumber phoneNumber;

    public Contact(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected Contact clone() throws CloneNotSupportedException {
        return (Contact) super.clone();
    }

    @Override
    public String toString() {
        return "Contact { " + name + "}" + "\n" + "\t" + "\t" + "{ " + "phoneNumber " + phoneNumber + "}";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int compareTo(Contact o) {
        int result = name.compareTo(o.name);
        if (result == 0) {
            return phoneNumber.compareTo(o.phoneNumber);
        }
        return result;
    }

}
