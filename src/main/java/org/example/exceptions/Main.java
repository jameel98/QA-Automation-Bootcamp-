package org.example.exceptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ReadConfigFile myService = new ReadConfigFile();

        try {
            myService.loadDataFromFile("file.txt");
            String value = myService.get("NONE");
            System.out.println("Value: " + value);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

