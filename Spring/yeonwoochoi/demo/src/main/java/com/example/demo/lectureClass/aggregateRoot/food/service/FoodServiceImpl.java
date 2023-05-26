package com.example.demo.lectureClass.aggregateRoot.food.service;

import com.example.demo.lectureClass.aggregateRoot.food.entity.*;
import com.example.demo.lectureClass.aggregateRoot.food.repository.*;
import com.example.demo.lectureClass.aggregateRoot.food.service.request.FoodRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    final FoodRepository foodRepository;
    final FoodImgeRepository foodImgeRepository;
    final FoodCategoryRepository foodCategoryRepository;
    final FoodAmountRepository foodAmountRepository;
    final CategoryRepository categoryRepository;
    final AmountRepository amountRepository;

    @Override
    public void register(FoodRegisterRequest request) {
        // 1. 식재료 Entity 및 Image 처리
        final Food food = request.toFood();
        foodRepository.save(food);
        // 2. 수량 처리
        final Amount amount = amountRepository.findByAmountType(
                request.getAmountType()).get();
        final FoodAmount foodAmount =
                new FoodAmount(
                        food, amount,
                        request.getFoodPrice(),
                        request.getFoodCalorie(),
                        request.getUnit(),
                        request.getMax(),
                        request.getMin());

        foodAmountRepository.save(foodAmount);
        // 3. 카테고리 처리
        final Category category = categoryRepository.findByCategoryType(
                request.getCategoryType());
        final FoodCategory foodCategory =
                new FoodCategory(food, category);

        foodCategoryRepository.save(foodCategory);
    }
}

