package a.michalovskij.eif.viko.lt.sportsman.service;

import a.michalovskij.eif.viko.lt.sportsman.model.Sportsman;
import a.michalovskij.eif.viko.lt.sportsman.repository.SportsmanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SportsmanServiceTest {

    @Mock
    private SportsmanRepository sportsmanRepository;

    @InjectMocks
    private SportsmanService sportsmanService;

    private Sportsman sportsman1;
    private Sportsman sportsman2;

    @BeforeEach
    public void setUp() {
        // Sukuriame sportininkus, kurie bus naudojami testuose
        sportsman1 = new Sportsman();
        sportsman1.setId(1L);
        sportsman1.setName("Mantas");
        sportsman1.setAge(25);
        sportsman1.setHeight(180);
        sportsman1.setWeight(75);
        sportsman1.setProfession("Boksininkas");

        sportsman2 = new Sportsman();
        sportsman2.setId(2L);
        sportsman2.setName("Aiste");
        sportsman2.setAge(28);
        sportsman2.setHeight(165);
        sportsman2.setWeight(60);
        sportsman2.setProfession("Bėgikė");
    }

    @Test
    public void testGetAllSportsmen() {
        List<Sportsman> sportsmenList = Arrays.asList(sportsman1, sportsman2);

        // Simuliuojame, kad findAll() grąžins sportininkų sąrašą
        when(sportsmanRepository.findAll()).thenReturn(sportsmenList);

        List<Sportsman> result = sportsmanService.getAllSportsmen();
        assertEquals(2, result.size());
        assertEquals("Mantas", result.get(0).getName());
    }
}
