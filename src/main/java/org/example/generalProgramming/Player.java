package org.example.generalProgramming;

public class Player {

    private String mName;
    private int mGrade;
    private Position mPos;
    private int mNumber;

    public Player(String aName, int aGrade, Position position, int aNumber){
        this.setName(aName);
        this.setGrade(aGrade);
        this.setPos(position);
        this.setNumber(aNumber);
    }
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getGrade() {
        return mGrade;
    }

    public void setGrade(int mGrade) {
        this.mGrade = mGrade;
    }

    public Position getPos() {
        return mPos;
    }

    public void setPos(Position mPos) {
        this.mPos = mPos;
    }
    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int mNumber) {
        this.mNumber = mNumber;
    }

}
