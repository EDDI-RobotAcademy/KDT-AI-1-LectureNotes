package kr.eddi.demo.lectureClass.sanrio.character.repository;

import kr.eddi.demo.lectureClass.sanrio.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
