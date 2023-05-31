package com.example.demo.problem;

public class problem9 {

    // Domain Service를 사용하는 이유에 대해 기술하세요.
    /*
        DDD는 Domain Entity로만 구현하게 되면 목적성이 불분명해지고 모호성이 발생하게 된다.
        실제 Entity는 객체에 해당하며 이 Entity에 모든 매서드를 작성하게 되면 Entity 자체의 목적성이 불명확해진다.
        DB에 저장하는 작업은 Repository로 분리하고, Entity 자신이 직접 수행하기 모호한 녀석들을 모두 Service로 빼서
        사용하면 재사용성이 올라간다.
    */
}
