package a.michalovskij.eif.viko.lt.sportsman.controller;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sportsmen")
@CrossOrigin(origins = "http://localhost:3000")  // Leidžiame pasiekti iš vietinio serverio
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    // Gauti visus sportininkus
    @GetMapping
    public ResponseEntity<List<Sportsman>> getAllSportsmen() {
        List<Sportsman> sportsmen = sportsmanService.getAllSportsmen();
        if (sportsmen.isEmpty()) {
            return ResponseEntity.noContent().build();  // Jei nėra sportininkų, grąžiname 204 statusą
        }
        return ResponseEntity.ok(sportsmen); // Grąžiname 200 statusą su sąrašu
    }

    // Gauti sportininką pagal ID
    @GetMapping("/{id}")
    public ResponseEntity<Sportsman> getSportsmanById(@PathVariable Long id) {
        Optional<Sportsman> sportsman = sportsmanService.getSportsmanById(id);
        return sportsman.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Sukurti naują sportininką
    @PostMapping
    public ResponseEntity<Sportsman> createSportsman(@RequestBody Sportsman sportsman) {
        try {
            Sportsman createdSportsman = sportsmanService.addSportsman(sportsman);
            return ResponseEntity.status(201).body(createdSportsman);  // Grąžiname 201 statusą, kai sportininkas sukuriamas
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);  // Grąžiname klaidos statusą, jei sportininkas negali būti sukurtas
        }
    }

    // Atnaujinti sportininko informaciją
    @PutMapping("/{id}")
    public ResponseEntity<Sportsman> updateSportsman(@PathVariable Long id, @RequestBody Sportsman sportsman) {
        Optional<Sportsman> existingSportsman = sportsmanService.getSportsmanById(id);
        if (existingSportsman.isPresent()) {
            Sportsman updatedSportsman = sportsmanService.updateSportsman(id, sportsman);
            return ResponseEntity.ok(updatedSportsman); // Grąžiname 200 statusą su atnaujintu sportininku
        } else {
            return ResponseEntity.notFound().build();  // Grąžiname 404 statusą, jei sportininkas nerastas
        }
    }

    // Ištrinti sportininką pagal ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSportsman(@PathVariable Long id) {
        Optional<Sportsman> sportsman = sportsmanService.getSportsmanById(id);
        if (sportsman.isPresent()) {
            sportsmanService.deleteSportsman(id);
            return ResponseEntity.noContent().build();  // Grąžiname 204 statusą, jei sportininkas ištrinamas
        } else {
            return ResponseEntity.notFound().build();  // Grąžiname 404 statusą, jei sportininkas nerastas
        }
    }

}
