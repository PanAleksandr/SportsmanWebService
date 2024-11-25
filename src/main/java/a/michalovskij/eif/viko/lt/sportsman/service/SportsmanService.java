package a.michalovskij.eif.viko.lt.sportsman.service;

import a.michalovskij.eif.viko.lt.sportsman.model.Exercise;
import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.repository.ExerciseRepository;
import a.michalovskij.eif.viko.lt.sportsman.repository.SportsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SportsmanService {

    private final SportsmanRepository sportsmanRepository;
    private final ExerciseRepository exerciseRepository;

    // Injekcija per konstruktorą
    @Autowired
    public SportsmanService(SportsmanRepository sportsmanRepository, ExerciseRepository exerciseRepository) {
        this.sportsmanRepository = sportsmanRepository;
        this.exerciseRepository = exerciseRepository;
    }

    // Gauti visus sportininkus
    public List<Sportsman> getAllSportsmen() {
        return sportsmanRepository.findAll();  // Grąžiname visus sportininkus
    }

    // Gauti sportininką pagal ID
    public Optional<Sportsman> getSportsmanById(Long id) {
        return sportsmanRepository.findById(id);  // Grąžiname sportininką pagal ID
    }

    // Sukurti naują sportininką
    public Sportsman addSportsman(Sportsman sportsman) {
        // Nereikia tikrinti ID, nes jis bus generuojamas automatiškai
        return sportsmanRepository.save(sportsman);  // Išsaugome naują sportininką
    }

    // Gauti sportininko pratimus pagal ID
    public List<Exercise> getExercisesBySportsmanId(Long sportsmanId) {
        List<Exercise> exercises = exerciseRepository.findBySportsmanId(sportsmanId);
        if (exercises.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pratimai nerasti šiam sportininkui.");  // Jei nėra pratimų
        }
        return exercises;  // Grąžiname pratimus
    }

    // Atnaujinti sportininko informaciją
    public Sportsman updateSportsman(Long id, Sportsman sportsman) {
        Optional<Sportsman> existingSportsman = sportsmanRepository.findById(id);
        if (existingSportsman.isPresent()) {
            Sportsman updatedSportsman = existingSportsman.get();
            updatedSportsman.setName(sportsman.getName());
            updatedSportsman.setAge(sportsman.getAge());
            updatedSportsman.setProfession(sportsman.getProfession());
            updatedSportsman.setGender(sportsman.getGender());
            updatedSportsman.setHeight(sportsman.getHeight());
            updatedSportsman.setWeight(sportsman.getWeight());
            updatedSportsman.setProfessional(sportsman.isProfessional());

            return sportsmanRepository.save(updatedSportsman);  // Grąžiname atnaujintą sportininką
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportininkas su ID " + id + " nerastas.");  // Jei sportininkas nerastas
        }
    }

    // Ištrinti sportininką
    public void deleteSportsman(Long id) {
        Optional<Sportsman> sportsman = sportsmanRepository.findById(id);
        if (sportsman.isPresent()) {
            sportsmanRepository.deleteById(id);  // Ištriname sportininką iš duomenų bazės
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportininkas su ID " + id + " nerastas.");  // Jei sportininkas nerastas
        }
    }
}
