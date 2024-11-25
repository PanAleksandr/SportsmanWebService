package a.michalovskij.eif.viko.lt.sportsman.service;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.repository.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    private Exercise exercise;
    private Sportsman sportsman;

    @BeforeEach
    public void setUp() {
        // Sukuriame sportininką prieš kiekvieną testą
        sportsman = new Sportsman();
        sportsman.setId(1L);
        sportsman.setName("Mantas Jankauskas");
        sportsman.setAge(25);
        sportsman.setProfession("Boksininkas");

        // Sukuriame pratimą su sportininku
        exercise = new Exercise();
        exercise.setId(1L);
        exercise.setName("Push-Up");
        exercise.setReps(20);  // Naudojame reps, kaip apibrėžta klasėje
        exercise.setSets(3);  // Nustatome sets
        exercise.setSportsman(sportsman);  // Priskiriame sportininką
    }

    @Test
    public void testAddExercise() {
        // Nustatome elgseną: jei pridedame naują pratimą
        when(exerciseRepository.save(any(Exercise.class))).thenReturn(exercise);

        // Testuojame pratimų kūrimą
        Exercise createdExercise = exerciseService.addExercise(exercise);

        assertNotNull(createdExercise);
        assertEquals("Push-Up", createdExercise.getName());
        assertEquals(20, createdExercise.getReps());  // Patikriname reps
        assertEquals(3, createdExercise.getSets());  // Patikriname sets
        assertEquals("Mantas Jankauskas", createdExercise.getSportsman().getName());  // Patikriname sportininko vardą
        verify(exerciseRepository, times(1)).save(exercise);  // Patikriname, ar buvo iškviestas save metodas
    }

    @Test
    public void testAddExerciseWithoutSportsman() {
        // Tikriname, kad pratimų kūrimas nepavyks, jei sportininkas nėra pateiktas
        exercise.setSportsman(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            exerciseService.addExercise(exercise);
        });
        assertEquals("Sportininkas turi būti pateiktas", exception.getMessage());
    }

    @Test
    public void testGetExercisesBySportsmanId() {
        // Nustatome elgseną: jei yra pratimų sportininkui
        when(exerciseRepository.findBySportsmanId(1L)).thenReturn(Arrays.asList(exercise));

        // Testuojame pratimų gavimą pagal sportininko ID
        List<Exercise> exercises = exerciseService.getExercisesBySportsmanId(1L);

        assertNotNull(exercises);
        assertFalse(exercises.isEmpty());
        assertEquals(1, exercises.size());  // Tikimės, kad grąžintas sąrašas turės 1 pratimą
    }

    @Test
    public void testGetExercisesBySportsmanIdNotFound() {
        // Testuojame, kad jei nėra pratimų sportininkui, grąžiname tuščią sąrašą
        when(exerciseRepository.findBySportsmanId(1L)).thenReturn(Arrays.asList());

        List<Exercise> exercises = exerciseService.getExercisesBySportsmanId(1L);

        assertTrue(exercises.isEmpty());  // Tikimės, kad sąrašas bus tuščias
    }
}
