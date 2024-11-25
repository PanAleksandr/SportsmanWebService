package a.michalovskij.eif.viko.lt.sportsman;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.service.SportsmanService;
import a.michalovskij.eif.viko.lt.sportsman.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("a.michalovskij.eif.viko.lt.sportsman.repository")  // Nurodome paketus su repository
public class SportsmanWebServiceApplication implements CommandLineRunner {

    @Autowired
    private SportsmanService sportsmanService;

    @Autowired
    private ExerciseService exerciseService;

    public static void main(String[] args) {
        SpringApplication.run(SportsmanWebServiceApplication.class, args);  // Paleidžiame aplikaciją
    }

    @Override
    public void run(String... args) throws Exception {
        // Gauname visus sportininkus ir išvedame į konsolę
        List<Sportsman> sportsmen = sportsmanService.getAllSportsmen();
        System.out.println("list of sportsman :");
        for (Sportsman sportsman : sportsmen) {
            System.out.println(sportsman);  // Išvedame sportininką
        }

        // Gauname visus pratimus ir išvedame į konsolę
        List<Exercise> exercises = exerciseService.getAllExercises();
        System.out.println("\nlist of exercise:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);  // Išvedame pratimą
        }
    }
}
