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

    // repository 6개 필요
     final FoodRepository foodRepository;
     final FoodImageRepository foodImageRepository;
     final FoodCategoryRepository foodCategoryRepository;
     final FoodAmountRepository foodAmountRepository;
     final CategoryRepository categoryRepository;
     final AmountRepository amountRepository;

    @Override
    public void register(FoodRegisterRequest foodRegisterRequest) {
        // 1. 식재료 Entity 및 Image 처리
        final Food food = foodRegisterRequest.toFood();
        foodRepository.save(food);

        // 2. 수량 처리
        final Amount amount = amountRepository.findByAmountType(
                foodRegisterRequest.getAmountType()).get();
        // 수량 가져왔으면 이걸 가지고 나머지 값들을 처리해줘야 함
        final FoodAmount foodAmount =
                new FoodAmount(food, amount,
                        foodRegisterRequest.getFoodPrice(),
                        foodRegisterRequest.getFoodCalorie(),
                        foodRegisterRequest.getUnit(),
                        foodRegisterRequest.getMax(),
                        foodRegisterRequest.getMin());
        foodAmountRepository.save(foodAmount);

        // 3. 카테고리 처리
        final Category category = categoryRepository.findByCategoryType(
                foodRegisterRequest.getCategoryType());
                // amoutType이랑 다른 점이 뭐길래 amout에만 get()을 붙여주는 거지?
                // 일단 get()이 붙어야 하는 이유는 Optional -> 있는지 없는지 확인하기 위해서
        final FoodCategory foodCategory =
                new FoodCategory(food, category);
        foodCategoryRepository.save(foodCategory);
    }
}
