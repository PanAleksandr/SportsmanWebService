package a.michalovskij.eif.viko.lt.sportsman.controller;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@CrossOrigin(origins = "http://localhost:3000")  // Leidžiame pasiekti iš vietinio serverio
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    // Gauti pratimus pagal sportininko ID
    @GetMapping("/{sportsmanId}")
    @Cacheable(value = "exercises", key = "#sportsmanId")  // Talpinti pratimus pagal sportininko ID
    public ResponseEntity<List<Exercise>> getExercises(@PathVariable Long sportsmanId) {
        List<Exercise> exercises = exerciseService.getExercisesBySportsmanId(sportsmanId);
        if (exercises.isEmpty()) {
            return ResponseEntity.notFound().build();  // Grąžiname 404, jei nerandame pratimų
        }
        return ResponseEntity.ok(exercises);  // Grąžiname 200 OK su pratimais
    }

    // Sukurti naują pratimą
    @PostMapping
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
        Exercise createdExercise = exerciseService.addExercise(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExercise);  // Grąžiname 201 statusą, kai pratimas sukuriamas
    }

}
