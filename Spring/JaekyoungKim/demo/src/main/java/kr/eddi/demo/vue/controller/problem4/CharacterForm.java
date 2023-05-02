package kr.eddi.demo.vue.controller.problem4;

import kr.eddi.demo.utility.CustomRandom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@RequiredArgsConstructor
@Getter
@ToString
public class CharacterForm {
   final private String myId;
   final private List<Integer> statusList;



}
