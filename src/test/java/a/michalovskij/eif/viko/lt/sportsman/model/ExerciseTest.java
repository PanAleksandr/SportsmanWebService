package a.michalovskij.eif.viko.lt.sportsman.model;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {

    private Exercise exercise;
    private Sportsman sportsman;

    @BeforeEach
    public void setUp() {
        // Initialize the Exercise and Sportsman objects before each test
        sportsman = new Sportsman();
        sportsman.setName("John Doe");

        exercise = new Exercise();
    }

    @Test
    public void testSetAndGetId() {
        exercise.setId(1L);
        assertEquals(1L, exercise.getId());
    }

    @Test
    public void testSetAndGetName() {
        exercise.setName("Push Up");
        assertEquals("Push Up", exercise.getName());
    }

    @Test
    public void testSetAndGetReps() {
        exercise.setReps(15);
        assertEquals(15, exercise.getReps());
    }

    @Test
    public void testSetAndGetSets() {
        exercise.setSets(3);
        assertEquals(3, exercise.getSets());
    }

    @Test
    public void testSetAndGetSportsman() {
        exercise.setSportsman(sportsman);
        assertEquals(sportsman, exercise.getSportsman());
    }

    @Test
    public void testToString() {
        exercise.setId(1L);
        exercise.setName("Push Up");
        exercise.setReps(15);
        exercise.setSets(3);
        exercise.setSportsman(sportsman);

        String expectedToString = "Exercise{id=1, name='Push Up', reps=15, sets=3, sportsman=John Doe}";
        assertEquals(expectedToString, exercise.toString());
    }

    @Test
    public void testDefaultValues() {
        // Test if default values are set correctly for an empty Exercise object
        assertNull(exercise.getName());
        assertEquals(0, exercise.getReps());
        assertEquals(0, exercise.getSets());
        assertNull(exercise.getSportsman());
    }
}
