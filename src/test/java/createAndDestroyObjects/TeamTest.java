package createAndDestroyObjects;

import createAndDestroyObjects.java.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @BeforeEach
    void setUp() {
        System.out.println("new test started");

    }

    @AfterEach
    void setEnd(){
        System.out.println("test ended");
    }

    @Test
    void testCreateTeamWithFormation() {
        // Arrange
        List<String> names = Arrays.asList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11");
        int numGoalkeepers = 1;
        int numDefenders = 4;
        int numMidfielders = 4;
        int numAttackers = 2;

        // Act
        Team team = Team.createTeamWithFormation(names, numGoalkeepers, numDefenders, numMidfielders, numAttackers);

        // Assert
        assertNotNull(team);
        assertEquals(11, team.getmTeam().size());

    }

    @Test
    void testCreateTeamWithInvalidFormation() {
        // Arrange
        List<String> names = Arrays.asList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11");
        int numGoalkeepers = 1;
        int numDefenders = 3; // Invalid formation, less than 4 defenders
        int numMidfielders = 4;
        int numAttackers = 3;

        // Act & Assert
        assertThrows(RuntimeException.class, () -> Team.createTeamWithFormation(names, numGoalkeepers, numDefenders, numMidfielders, numAttackers));
    }

    @Test
    void testGenerateRandomPlayers() {
        // Arrange
        List<String> names = Arrays.asList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11");
        Team team = new Team(names);
        int numRandomPlayers = 5;

        // Act
        team.generateRandomPlayers(numRandomPlayers);

        // Assert
        assertEquals(5, team.getmTeam().size());
    }

    @Test
    void testToString() {
        // Arrange
        List<String> names = Arrays.asList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11");
        Team team = Team.createTeamWithFormation(names, 1, 4, 4, 2);

        // Act
        String teamString = team.toString();

        // Assert
        assertNotNull(teamString);
        assertTrue(teamString.contains("name: "));
        assertTrue(teamString.contains("position: "));
        assertTrue(teamString.contains("Grade: "));
        assertTrue(teamString.contains("Jersey: "));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4, 4, 2",
            "1, 4, 3, 3",
            "1, 3, 4, 3"
    })
    void testCreateTeamWithDifferentFormations(int numGoalkeepers, int numDefenders, int numMidfielders, int numAttackers) {
        // Arrange
        List<String> names = Arrays.asList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11");

        // Act
        Team team = Team.createTeamWithFormation(names, numGoalkeepers, numDefenders, numMidfielders, numAttackers);

        // Assert
        assertNotNull(team);
        assertEquals(11, team.getmTeam().size());
    }

}
