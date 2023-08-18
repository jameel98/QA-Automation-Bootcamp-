package org.example.generalProgramming;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private static List<Player> mTeam;
    private static Utils mUtils;
    ArrayList<Integer> mGrades;
    ArrayList<Integer> mJersys;

    public Team(Position position1, int len1, Position position2, int len2, Position position3, int len3, Position position4, int len4, int rand) {
        mTeam = new ArrayList<>();
        mUtils = new Utils();
        mGrades = new ArrayList<>();
        mJersys = new ArrayList<>();


        generateRandomPlayer(position1, len1);
        generateRandomPlayer(position2, len2);
        generateRandomPlayer(position3, len3);
        generateRandomPlayer(position4, len4);

        // generate random players
        for (int i = 0; i < rand; i++) {
            int pos = mUtils.generateRandomNumber() % 3 + 1;
            switch (pos) {
                case 1:
                    generateRandomPlayer(Position.DEFENDER, 1);
                    break;
                case 2:
                    generateRandomPlayer(Position.MIDFIELDER, 1);
                    break;
                case 3:
                    generateRandomPlayer(Position.ATTACKER, 1);
                    break;
            }
        }
    }

    public void generateRandomPlayer(Position position, int counter) {
        while (counter > 0) {
            String name = mUtils.getRandomName();

            int grade = mUtils.generateRandomNumber();
            // check if grade already exist
            while (mGrades.contains(grade)){
                grade = mUtils.generateRandomNumber();
            }
            mGrades.add(grade);

            // check if number already exist
            int jerseyNumber = mUtils.generateRandomNumber();
            while (mJersys.contains(jerseyNumber)){
                jerseyNumber = mUtils.generateRandomNumber();
            }
            mJersys.add(jerseyNumber);

            Player player = new Player(name, grade, position, jerseyNumber);
            mTeam.add(player);

            counter--;
        }

    }

    /**
     * this method made initialize list for grades and list for jersys
     * to make the numbers unique
     */

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Player p :mTeam
             ) {
            s.append("name: ").append(p.getName()).append("\n").append("position: ").append(p.getPos()).append("\n").
                    append("Grade: ").append(p.getGrade()).append("\n").append("Jersey: ").append(p.getNumber()).append("\n");
        }
        return s.toString();
    }
}
