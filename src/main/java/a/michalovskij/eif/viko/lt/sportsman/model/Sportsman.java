package a.michalovskij.eif.viko.lt.sportsman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Sportsman extends RepresentationModel<Sportsman> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;

    @JsonProperty("isProfessional")
    private boolean isProfessional;

    private String profession;

    @OneToMany(mappedBy = "sportsman")
    @JsonIgnore
    private List<Exercise> exercises;

    // get set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setProfessional(boolean professional) {
        isProfessional = professional;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +"y.o." +
                ", height=" + height + "cm" +
                ", weight=" + weight + "kg" +
                ", profession='" + profession + '\'' +
                '}';
    }
}
