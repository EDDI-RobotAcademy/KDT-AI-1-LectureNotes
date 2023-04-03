package turnBasedGame.controller;

import turnBasedGame.gameManagement.GameMaster;

public class GameController {
    public static void main(String[] args) {
        new GameMaster().GameStart();
    }
}

/*
필요한 것
캐릭터(플레이어)
    완력, 민첩, 재주, 지능, 체력
    스킬 2개(광역, 단일)
    + 평타도 넣자
몬스터
    그냥 샌드백으로
    + ㄴㄴ 얘네도 때리게

한번 때리고 -> 한대 맞고 -> 머리수 체크

승패 조건 검사
죽거나 다잡거나
ㅇㅋ
===========================================
게임 캐릭터는 상태 정보를 가집니다.
완력, 민첩, 재주, 지능 수치를 가지고 있습니다.
캐릭터가 사용할 수 있는 스킬은 단일 타겟팅 공격, 광역 타겟팅 공격
몬스터 두 마리를 배치해서 캐릭터와
매 루프마다 공방을 주고 받도록 만들어보세요.
 */