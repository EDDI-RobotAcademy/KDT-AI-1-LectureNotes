package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class GameManager {
    List<Character> characterList = new ArrayList<>();
    List<Enemy> enemyList = new ArrayList<>();

    public GameManager () {

    }

    public void addEnemy () {
        final int EnemyCount = 3;

        for(int i = 0; i < EnemyCount; i++) {
            enemyList.add(new Enemy());
        }
    }
}
