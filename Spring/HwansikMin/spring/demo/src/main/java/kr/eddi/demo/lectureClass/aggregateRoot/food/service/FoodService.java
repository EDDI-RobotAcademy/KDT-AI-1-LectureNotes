package kr.eddi.demo.lectureClass.aggregateRoot.food.service;

import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;

public interface FoodService {
    void register (FoodRegisterRequest foodRegisterRequest);
}
