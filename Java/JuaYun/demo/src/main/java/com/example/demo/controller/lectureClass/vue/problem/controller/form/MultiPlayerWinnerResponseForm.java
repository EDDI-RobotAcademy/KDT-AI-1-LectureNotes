package com.example.demo.controller.lectureClass.vue.problem.controller.form;

import com.example.demo.controller.lectureClass.vue.problem.player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class MultiPlayerWinnerResponseForm {
    // 승자판정은 마지막에
    // 1주사위 굴리기
    // 2세개굴리기
    // 3조건설정
    // 4세부조건설정하면서 합산값설정하기
    // 5마지막이 승자판정
    // 6플레이어 이름설정

    final private String winnerName;
    final private List<Player> playerList;
}
