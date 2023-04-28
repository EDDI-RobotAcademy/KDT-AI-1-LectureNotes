//package kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter;
//
//import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
//import lombok.Getter;
//import lombok.ToString;
//
//@ToString
//@Getter
//public class CharacterStatus {
//
//    private String selectedGender;
//    private int strength;
//    private int dexterity;
//    private int intelligence;
//    private int characterId;
//
//    public CharacterStatus(String gender, int characterId) {
//        final int STATUS_MIN = 1;
//        final int STATUS_MAX = 10;
//
//        this.selectedGender = gender;
//        this.strength = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
//        this.dexterity = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
//        this.intelligence = CustomRandom.generateNumber(STATUS_MIN, STATUS_MAX);
//        this.characterId = characterId;
//    }
//}
