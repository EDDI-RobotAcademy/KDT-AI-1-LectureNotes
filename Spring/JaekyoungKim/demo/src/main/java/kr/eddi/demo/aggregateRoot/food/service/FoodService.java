package kr.eddi.demo.aggregateRoot.food.service;

import kr.eddi.demo.aggregateRoot.food.service.request.FoodRegisterRequest;


public interface FoodService {
    void register (FoodRegisterRequest foodRegisterRequest);
}