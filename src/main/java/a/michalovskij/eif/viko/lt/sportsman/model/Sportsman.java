package a.michalovskij.eif.viko.lt.sportsman.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // Импортируйте для использования @JsonIgnore
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sportsman") // Указываем имя таблицы
public class Sportsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String profession;
    private double height;
    private double weight;
    private boolean isProfessional;
    private String gender;

    @JsonIgnore // Игнорируем это поле при сериализации
    @OneToMany(mappedBy = "sportsman", cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    // Геттеры и сеттеры
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public void setProfessional(boolean isProfessional) {
        this.isProfessional = isProfessional;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", isProfessional=" + isProfessional +
                ", profession='" + profession + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sportsman)) return false;
        Sportsman sportsman = (Sportsman) o;
        return id != null && id.equals(sportsman.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setIsProfessional(boolean isProfessional) {
        this.isProfessional = isProfessional;
    }

}