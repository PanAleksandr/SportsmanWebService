package a.michalovskij.eif.viko.lt.sportsman.service;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    // Gauti visus pratimus
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();  // Grąžiname visus pratimus
    }

    // Sukurti naują pratimą
    public Exercise addExercise(Exercise exercise) {
        // Tikriname, ar yra sportininkas ir ar jis turi ID
        if (exercise.getSportsman() == null || exercise.getSportsman().getId() == null) {
            throw new RuntimeException("Sportininkas turi būti pateiktas");  // Jei sportininkas nėra pateiktas, išmetame klaidą
        }
        return exerciseRepository.save(exercise);  // Išsaugome naują pratimą
    }

    // Gauti pratimus pagal sportininko ID
    public List<Exercise> getExercisesBySportsmanId(Long sportsmanId) {
        List<Exercise> exercises = exerciseRepository.findBySportsmanId(sportsmanId);
        if (exercises.isEmpty()) {
            // Jei pratimų nėra, galime tiesiog grąžinti tuščią sąrašą arba išmesti klaidą
            return exercises;  // Grąžiname tuščią sąrašą vietoj klaidos metimo
        }
        return exercises;  // Grąžiname pratimus
    }

    // Papildomi metodai darbui su pratimais gali būti pridėti čia
}
