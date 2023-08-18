package createAndDestroyObjects.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> mTeam;
    ArrayList<Integer> mGrades;
    ArrayList<Integer> mJerseys;

    private NameGenerator mNameGenerator;
    private String mDataFile = "teamData.txt"; //file to save data in it at the end


    public Team(List<String> names) {
        mTeam = new ArrayList<>();
        mGrades = new ArrayList<>();
        mJerseys = new ArrayList<>();
        mNameGenerator = new NameGenerator(names);

    }

    /**
     * constructor to create team object by getting position and number for each position
     *
     * @param position1
     * @param len1
     * @param position2
     * @param len2
     * @param position3
     * @param len3
     * @param position4
     * @param len4
     * @param rand
     */
    public Team(List<String> name, Position position1, int len1, Position position2, int len2, Position position3, int len3, Position position4, int len4, int rand) {
        mTeam = new ArrayList<>();
        mGrades = new ArrayList<>();
        mJerseys = new ArrayList<>();
        mNameGenerator = new NameGenerator(name);

        generateRandomPlayer(position1, len1);
        generateRandomPlayer(position2, len2);
        generateRandomPlayer(position3, len3);
        generateRandomPlayer(position4, len4);

        // generate random players
        generateRandomPlayers(rand);
    }

    /**
     * The static factory methods that create a team given a specific formation.
     * A formation is the number of players each position has.
     * examples:
     * 1 - GK, 4 - Defense, 4 - Middlefiled, 2 - Attack
     * 1 - GK, 4 - Defense, 3 - Middlefiled, 3 - Attack
     *
     * @param numGoalkeepers
     * @param numDefenders
     * @param numMidfielders
     * @param numAttackers
     * @return team
     */
    public static Team createTeamWithFormation(List<String> names, int numGoalkeepers, int numDefenders, int numMidfielders, int numAttackers) {
        //validate team number correct and 1 goal keeper
        validateFormation(numGoalkeepers, numDefenders, numMidfielders, numAttackers);

        Team team = new Team(names);
        team.generateRandomPlayer(Position.GOALKEEPER, numGoalkeepers);
        team.generateRandomPlayer(Position.DEFENDER, numDefenders);
        team.generateRandomPlayer(Position.MIDFIELDER, numMidfielders);
        team.generateRandomPlayer(Position.ATTACKER, numAttackers);
        return team;

    }

    /**
     * validate function to make sure the team formation is correct
     * @param numGoalkeepers
     * @param numDefenders
     * @param numMidfielders
     * @param numAttackers
     */
    private static void validateFormation(int numGoalkeepers, int numDefenders, int numMidfielders, int numAttackers) {
        if (numAttackers + numDefenders + numGoalkeepers + numMidfielders != 11) {
            try {
                throw new IOException("wrong formation number must be 11 players in total");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (numGoalkeepers != 1) {
            try {
                throw new IOException("Goal keeper number must be 1");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (numAttackers < 2 || numDefenders < 2 || numMidfielders < 2) {
            try {
                throw new IOException("must have at least 2 players of each position except goal keeper");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * function to create team with random players number
     * @param name
     * @param numGoalkeepers
     * @param numDefenders
     * @param numMidfielders
     * @param numAttackers
     * @param numRandomPlayers
     * @return team
     */
    public static Team createTeamWithFormation(List<String> name,int numGoalkeepers, int numDefenders, int numMidfielders, int numAttackers, int numRandomPlayers) {
        Team team = createTeamWithFormation(name, numGoalkeepers, numDefenders, numMidfielders, numAttackers);
        team.generateRandomPlayers(numRandomPlayers);
        return team;
    }

    public void generateRandomPlayers(int numRandomPlayers) {
        for (int i = 0; i < numRandomPlayers; i++) {
            int pos = Utils.generateRandomNumber(3) + 1;
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

        for (int i = 0; i < counter; i++) {

            String name = mNameGenerator.generateRandomName();

            int grade = Utils.generateRandomNumber(100);
            mGrades.add(grade);

            // check if number already exist
            int jerseyNumber = Utils.generateRandomNumber(70);
            while (mJerseys.contains(jerseyNumber)) {
                jerseyNumber = Utils.generateRandomNumber(70);
            }
            mJerseys.add(jerseyNumber);

            Player player = new Player(name, grade, position, jerseyNumber);
            mTeam.add(player);

        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Player p : mTeam
        ) {
            s.append("name: ").append(p.getName()).append("\n").append("position: ").append(p.getPos()).append("\n").
                    append("Grade: ").append(p.getGrade()).append("\n").append("Jersey: ").append(p.getNumber()).append("\n");
        }
        try (FileWriter writer = new FileWriter(mDataFile)) {
            writer.write(s.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s.toString();
    }

    public List<Player> getmTeam() {
        return mTeam;
    }
}
