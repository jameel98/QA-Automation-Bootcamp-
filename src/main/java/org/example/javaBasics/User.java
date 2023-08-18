package org.example.javaBasics;

public class User {

    public String Name;
    public int Id;

    boolean Activated;

    public User(String name, int id, boolean activated) {
        Name = name;
        Id = id;
        Activated = activated;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isActivated() {
        return Activated;
    }

    public void setActivated(boolean activated) {
        Activated = activated;
    }

}
