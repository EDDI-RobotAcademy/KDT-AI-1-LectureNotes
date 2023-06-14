package kr.eddi.demo.lectureClass.aggregateRoot.food.service;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Food;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;

public interface FoodService {
    void register(FoodRegisterRequest foodRegisterRequest);
}
