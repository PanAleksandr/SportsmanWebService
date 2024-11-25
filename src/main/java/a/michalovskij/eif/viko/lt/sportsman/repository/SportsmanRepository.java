package a.michalovskij.eif.viko.lt.sportsman.repository;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository "Sportsman" objektų saugojimą ir paiešką
public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
    //  leidžia atlikti operacijas su Sportsman objektais,
    // JpaRepository suteik metodus automatiškai
}
