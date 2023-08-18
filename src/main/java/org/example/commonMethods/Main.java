package org.example.commonMethods;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Name name = new Name("Mr.", "pop", "jack");
        PhoneNumber phoneNumber = new PhoneNumber("03", 689656);
        PhoneBook phoneBook = new PhoneBook("codio");
        phoneBook.addContact(name, phoneNumber);
        System.out.println(phoneBook);
    }
}