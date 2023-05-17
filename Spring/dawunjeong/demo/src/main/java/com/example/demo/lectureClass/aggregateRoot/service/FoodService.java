package com.example.demo.lectureClass.aggregateRoot.service;

import com.example.demo.lectureClass.aggregateRoot.service.request.FoodRegisterRequest;

public interface FoodService {

    void register(FoodRegisterRequest foodRegisterRequest);
}
