package a.michalovskij.eif.viko.lt.sportsman.controller;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sportsmen")
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @GetMapping
    public List<Sportsman> getAllSportsmen() {
        return sportsmanService.getAllSportsmen();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sportsman> getSportsmanById(@PathVariable Long id) {
        Optional<Sportsman> sportsman = sportsmanService.getSportsmanById(id);
        if (sportsman.isPresent()) {
            return new ResponseEntity<>(sportsman.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Возвращаем статус 404, если не найден
        }
    }

    @PostMapping
    public ResponseEntity<Sportsman> createSportsman(@Valid @RequestBody Sportsman sportsman) {
        Sportsman createdSportsman = sportsmanService.addSportsman(sportsman);
        return new ResponseEntity<>(createdSportsman, HttpStatus.CREATED);  // Возвращаем статус 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sportsman> updateSportsman(@PathVariable Long id, @Valid @RequestBody Sportsman sportsman) {
        Optional<Sportsman> existingSportsman = sportsmanService.getSportsmanById(id);
        if (existingSportsman.isPresent()) {
            Sportsman updatedSportsman = sportsmanService.updateSportsman(id, sportsman);
            return new ResponseEntity<>(updatedSportsman, HttpStatus.OK);  // Статус 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Статус 404, если не найден
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSportsman(@PathVariable Long id) {
        Optional<Sportsman> sportsman = sportsmanService.getSportsmanById(id);
        if (sportsman.isPresent()) {
            sportsmanService.deleteSportsman(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Статус 204 при успешном удалении
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Статус 404, если не найден
        }
    }
}
