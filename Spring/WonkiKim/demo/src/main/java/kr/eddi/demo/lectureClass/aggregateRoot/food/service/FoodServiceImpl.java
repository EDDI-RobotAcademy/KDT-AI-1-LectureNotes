package kr.eddi.demo.lectureClass.aggregateRoot.food.service;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.*;
import kr.eddi.demo.lectureClass.aggregateRoot.food.repository.*;
import kr.eddi.demo.lectureClass.aggregateRoot.food.service.request.FoodRegistRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
    final FoodRepository foodRepository;
//    final FoodImageRepository foodImageRepository;
    final FoodCategoryRepository foodCategoryRepository;
    final FoodAmountRepository foodAmountRepository;

    final CategoryRepository categoryRepository;
    final AmountRepository amountRepository;

    @Override
    public void register(FoodRegistRequest foodRegistRequest) {
        //1. 식재료 엔티티 및 이미지 처리
        final Food food = foodRegistRequest.toFood();
        foodRepository.save(food);
        // 2. 수량 처리
        final Amount amount = amountRepository.findByAmountType(
                foodRegistRequest.getAmountType()
        );
        final  FoodAmount foodAmount = new FoodAmount(food, amount, foodRegistRequest.getFoodPrice(),
                foodRegistRequest.getCalories(),
                foodRegistRequest.getUnit(),
                foodRegistRequest.getMax(),
                foodRegistRequest.getMin());
        // 3. 카테고리 처리
        final Category category = categoryRepository.findByCategoryType(foodRegistRequest.getCategoryType());
        final FoodCategory foodCategory = new FoodCategory(food, category);
        foodCategoryRepository.save(foodCategory);
    }



}
