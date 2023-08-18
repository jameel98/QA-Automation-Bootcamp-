package org.example.commonMethods;

import java.util.Objects;

public class Name implements Cloneable, Comparable<Name>{
    private String prefix;
    private String FirstName;
    private String LastName;

    public Name(String prefix, String firstName, String lastName){
        this.prefix = prefix;
        this.FirstName =firstName;
        this.LastName = lastName;

    }
    @Override
    protected Name clone() throws CloneNotSupportedException {
       return (Name)super.clone();
    }

    @Override
    public String toString() {
        return "Name { " + "prefix=" + prefix + " " + "firstname=" + FirstName + " lastname=" + LastName + " }";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + prefix.hashCode();
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + LastName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name name = (Name) obj;
        return Objects.equals(FirstName, name.FirstName) && Objects.equals(LastName, name.LastName) && Objects.equals(prefix, name.prefix);    }

    @Override
    public int compareTo(Name name) {
        int result = FirstName.compareTo(name.FirstName);
        if (result == 0) {
            result = prefix.compareTo(name.prefix);
            if (result == 0) {
                result = LastName.compareTo(name.LastName);
            }
        }
        return result;
    }


}
