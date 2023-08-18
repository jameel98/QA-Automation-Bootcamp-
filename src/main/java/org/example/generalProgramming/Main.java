package org.example.generalProgramming;

public class Main {

    public static void main(String[] args) {
      Team mTeam = new Team(Position.GOALKEEPER, 1, Position.ATTACKER, 2, Position.DEFENDER, 2,
              Position.MIDFIELDER, 2,3);

      System.out.println(mTeam.toString());
    }
}

