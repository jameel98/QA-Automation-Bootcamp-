package org.example.commonMethods;

import java.util.Objects;

public class PhoneNumber implements Comparable<PhoneNumber>, Cloneable{
    private String AreaCode;
    private int Number;

    public PhoneNumber(String areaCode, int number){
        this.AreaCode = areaCode;
        this.Number = number;
    }
    @Override
    protected PhoneNumber clone() throws CloneNotSupportedException {
       return (PhoneNumber) super.clone();
    }

    @Override
    public String toString()
    {
        return "{ " + "area code=" + AreaCode + " " + "number=" + Number + "}";
    }

    @Override
    public int hashCode()
    {   int result = 1;
        result = 31 * result + AreaCode.hashCode();
        result = 31 * result + Number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PhoneNumber)) return false;
        PhoneNumber phoneNumber = (PhoneNumber) obj;
        return Objects.equals(AreaCode, phoneNumber.AreaCode) && Objects.equals(Number, phoneNumber.Number);
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        int result = AreaCode.compareTo(phoneNumber.AreaCode);
        if (result == 0) {
            return Integer.compare(Number, phoneNumber.Number);
        }
        return result;
    }
}
