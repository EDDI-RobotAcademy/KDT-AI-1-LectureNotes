package kr.eddi.demo.lectureClass.aggregateRoot.food.service;

import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegistRequest;

public interface FoodService {
    void register(FoodRegistRequest foodRegistRequest);
}
