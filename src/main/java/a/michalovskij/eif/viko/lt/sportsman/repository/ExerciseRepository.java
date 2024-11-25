package a.michalovskij.eif.viko.lt.sportsman.repository;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//atsakingas už "Exercise" objektų saugojimą ir paiešką
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    //rastų visus pratimus, susijusius su konkrečiu sportininku pagal jo ID
    List<Exercise> findBySportsmanId(Long sportsmanId);
    // Šis metodas leidžia gauti pratimus, susijusius su konkrečiu sportininku pagal sportininko ID
}
