package org.example.exceptions;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadConfigFile {
    private Map<String, String> configData;
    public ReadConfigFile() {
        configData = new HashMap<>();
    }
    private Map<String, String> getMyData() {
        if (configData.isEmpty())
            throw new IllegalStateException("Data not initialized!");
        return configData;
    }
    public String get(String key) {
        Map<String, String> data = getMyData();
        if (!data.containsKey(key)) {
            throw new IllegalArgumentException("Key does not exist.");
        }
        return data.get(key);
    }
    public void loadDataFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String strLine = "";
            while ((strLine = reader.readLine()) != null) {
                String[] parts = strLine.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configData.put(key, value);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found! Creating a new default file.");

            // Write the default data to a file
            createDefaultConfigFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error reading the configuration file.", e);
        }
    }

    private void createDefaultConfigFile(String filePath) {
        Map<String, String> configurationMap = new HashMap<>();
        configurationMap.put("PASSWORD", "myPass");
        configurationMap.put("USER", "pop");
        configurationMap.put("EMAIL", "pop@gmail.com");
        configData = configurationMap;
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, String> entry : configurationMap.entrySet()) {
                String line = entry.getKey() + "=" + entry.getValue() + System.lineSeparator();
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating new file",e);
        }
    }
    public String getDataByKey(String key) {
        if (!configData.containsKey(key)) {
            throw new NullPointerException("Key not found!");
        }
        return configData.get(key);
    }

}
