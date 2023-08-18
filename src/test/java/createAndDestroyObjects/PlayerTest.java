package createAndDestroyObjects;

import org.example.createAndDestroyObjects.Player;
import org.example.createAndDestroyObjects.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @BeforeEach
    void setUp() {
        System.out.println("new test started");
        Player player = Player.createGoalKeeper("Pop",90 , 1);

    }

    @AfterEach
    void setEnd(){
        System.out.println("test ended");
    }

    @Test
    void testPlayerConstructor() {
        // Arrange
        String name = "John Doe";
        int grade = 5;
        Position position = Position.GOALKEEPER;
        int number = 10;

        // Act
        Player player = new Player(name, grade, position, number);

        // Assert
        assertEquals(name, player.getName());
        assertEquals(grade, player.getGrade());
        assertEquals(position, player.getPos());
        assertEquals(number, player.getNumber());
    }

    @Test
    void testPlayerConstructorWithInvalidGrade() {
        // Arrange
        String name = "John Doe";
        int grade = -1; // Negative grade, which should not be allowed
        Position position = Position.DEFENDER;
        int number = 4;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Player(name, grade, position, number));
    }

    @Test
    void testCreateGoalKeeper() {
        // Arrange
        String name = "Jane Smith";
        int grade = 6;
        int number = 1;

        // Act
        Player goalkeeper = Player.createGoalKeeper(name, grade, number);

        // Assert
        assertEquals(name, goalkeeper.getName());
        assertEquals(grade, goalkeeper.getGrade());
        assertEquals(Position.GOALKEEPER, goalkeeper.getPos());
        assertEquals(number, goalkeeper.getNumber());
    }
    @Test
    void testCreateDefenderWithInvalidNumber() {
        // Arrange
        int number = 0; // Invalid number, which should not be allowed

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Player.createDefender("alice", 33, number));
    }

    @Test
    void testCreateAttacker(){
        // Act & Assert
        assertEquals( Player.createAttacker("kamal", 12, 1).getPos(), Position.ATTACKER);
    }

    @Test
    void testCreateMidfielder(){
        // Act & Assert
        assertEquals(Player.createMidfielder("qww", 34, 1).getPos(), Position.MIDFIELDER);
    }


    @ParameterizedTest
    @CsvSource({
            "David Beckham, 7, 23, MIDFIELDER",
            "Cristiano Ronaldo, 10, 7, ATTACKER",
            "Paolo Maldini, 9, 3, DEFENDER"
    })
    void testCreatePlayerWithDifferentPositions(String name, int grade, int number, Position position) {
        // Act
        Player player = new Player(name, grade, position, number);

        // Assert
        assertEquals(name, player.getName());
        assertEquals(grade, player.getGrade());
        assertEquals(position, player.getPos());
        assertEquals(number, player.getNumber());
    }



}
