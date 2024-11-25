package a.michalovskij.eif.viko.lt.sportsman.model;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SportsmanTest {

    private Sportsman sportsman;

    @BeforeEach
    public void setUp() {
        // Initializing a Sportsman object before each test
        sportsman = new Sportsman();
    }

    @Test
    public void testSetAndGetName() {
        sportsman.setName("John Doe");
        assertEquals("John Doe", sportsman.getName());
    }

    @Test
    public void testSetAndGetAge() {
        sportsman.setAge(25);
        assertEquals(25, sportsman.getAge());
    }

    @Test
    public void testSetAndGetGender() {
        sportsman.setGender("Male");
        assertEquals("Male", sportsman.getGender());
    }

    @Test
    public void testSetAndGetHeight() {
        sportsman.setHeight(180.5);
        assertEquals(180.5, sportsman.getHeight());
    }

    @Test
    public void testSetAndGetWeight() {
        sportsman.setWeight(75.0);
        assertEquals(75.0, sportsman.getWeight());
    }

    @Test
    public void testSetAndGetProfessionalStatus() {
        sportsman.setProfessional(true);
        assertTrue(sportsman.isProfessional());
    }

    @Test
    public void testSetAndGetProfession() {
        sportsman.setProfession("Athlete");
        assertEquals("Athlete", sportsman.getProfession());
    }

    @Test
    public void testToString() {
        sportsman.setId(1L);
        sportsman.setName("John Doe");
        sportsman.setAge(25);
        sportsman.setHeight(180.5);
        sportsman.setWeight(75.0);
        sportsman.setProfession("Athlete");

        String expectedToString = "Sportsman{id=1, name='John Doe', age=25y.o., height=180.5cm, weight=75.0kg, profession='Athlete'}";
        assertEquals(expectedToString, sportsman.toString());
    }

    @Test
    public void testDefaultValues() {
        // Testing if the default values are set as expected for the object
        assertNull(sportsman.getName());
        assertEquals(0, sportsman.getAge());
        assertNull(sportsman.getGender());
        assertEquals(0.0, sportsman.getHeight());
        assertEquals(0.0, sportsman.getWeight());
        assertFalse(sportsman.isProfessional());
        assertNull(sportsman.getProfession());
    }

    @Test
    public void testSetExercises() {
        // You can add more specific tests based on the exercises
        // For now, it's an empty list of exercises
        sportsman.setExercises(null);
        assertNull(sportsman.getExercises());
    }
}
