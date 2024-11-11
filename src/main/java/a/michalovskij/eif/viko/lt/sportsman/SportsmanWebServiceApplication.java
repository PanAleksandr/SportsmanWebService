package a.michalovskij.eif.viko.lt.sportsman;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.service.SportsmanService;
import a.michalovskij.eif.viko.lt.sportsman.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SportsmanWebServiceApplication implements CommandLineRunner {

    @Autowired
    private SportsmanService sportsmanService;

    @Autowired
    private ExerciseService exerciseService;

    public static void main(String[] args) {
        SpringApplication.run(SportsmanWebServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Получение всех спортсменов и вывод в консоль
        List<Sportsman> sportsmen = sportsmanService.getAllSportsmen();
        System.out.println("list of sportsman :");
        for (Sportsman sportsman : sportsmen) {
            System.out.println(sportsman);
        }

        // Получение всех упражнений и вывод в консоль
        List<Exercise> exercises = exerciseService.getAllExercises();
        System.out.println("\nlist of exercise:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }
}
