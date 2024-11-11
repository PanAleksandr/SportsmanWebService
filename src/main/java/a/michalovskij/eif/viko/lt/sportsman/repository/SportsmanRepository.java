package a.michalovskij.eif.viko.lt.sportsman.repository;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
    // Здесь можно добавлять дополнительные методы, если необходимо
}
