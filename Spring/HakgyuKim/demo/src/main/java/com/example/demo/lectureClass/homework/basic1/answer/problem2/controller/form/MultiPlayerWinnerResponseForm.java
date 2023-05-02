package com.example.demo.lectureClass.homework.basic1.answer.problem2.controller.form;

import com.example.demo.lectureClass.homework.basic1.answer.problem2.player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class MultiPlayerWinnerResponseForm {
    final private String winnerName;
    final private List<Player> playerList;
}
