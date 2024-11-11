package a.michalovskij.eif.viko.lt.sportsman.service;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.repository.SportsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportsmanService {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    // Возвращает всех спортсменов
    public List<Sportsman> getAllSportsmen() {
        return sportsmanRepository.findAll();
    }

    // Возвращает спортсмена по ID
    public Optional<Sportsman> getSportsmanById(Long id) {
        return sportsmanRepository.findById(id);
    }

    // Добавляет нового спортсмена
    public Sportsman addSportsman(Sportsman sportsman) {
        return sportsmanRepository.save(sportsman);
    }

    // Обновляет информацию о спортсмене
    public Sportsman updateSportsman(Long id, Sportsman sportsman) {
        if (sportsmanRepository.existsById(id)) {
            sportsman.setId(id);
            return sportsmanRepository.save(sportsman);
        }
        throw new RuntimeException("Sportsman not found with id " + id);
    }

    // Удаляет спортсмена по ID
    public void deleteSportsman(Long id) {
        if (sportsmanRepository.existsById(id)) {
            sportsmanRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sportsman not found with id " + id);
        }
    }
}
