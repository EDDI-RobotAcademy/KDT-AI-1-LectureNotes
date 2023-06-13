package kr.eddi.demo.lectureClass.sanrio.character.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer number;
    private String imagePath;

    public Character(String name, Integer number, String imagePath) {
        this.name = name;
        this.number = number;
        this.imagePath = imagePath;
    }
}
