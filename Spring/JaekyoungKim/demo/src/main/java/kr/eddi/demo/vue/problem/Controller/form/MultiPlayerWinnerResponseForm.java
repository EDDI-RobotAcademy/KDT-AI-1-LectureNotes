package kr.eddi.demo.vue.problem.Controller.form;



import kr.eddi.demo.vue.problem.player.Player;
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