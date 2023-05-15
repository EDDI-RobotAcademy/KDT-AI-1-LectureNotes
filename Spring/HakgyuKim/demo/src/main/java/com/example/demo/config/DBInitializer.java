package com.example.demo.config;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Amount;
import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.repository.AmountRepository;
import com.example.demo.lectureClass.aggregateRoot.food.repository.CategoryRepository;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRole;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaAccountRoleType;
import com.example.demo.lectureClass.homework.jUnitBank3.entity.HomeworkJpaRole;
import com.example.demo.lectureClass.homework.jUnitBank3.repository.HomeworkJpaAccountRoleRepository;
import com.example.demo.lectureClass.homework.jUnitBank3.repository.HomeworkJpaRoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DBInitializer {

    final private CategoryRepository categoryRepository;
    final private AmountRepository amountRepository;
    final private HomeworkJpaRoleRepository roleRepository;

    @PostConstruct
    private void init () {
        log.debug("initializer 시작!");

        initCategoryTypes();
        initAmountTypes();
        initRoleTypes();

        log.debug("initializer 종료!");
    }

    private void initAmountTypes () {
        try {
            final Set<AmountType> amounts =
                    amountRepository.findAll().stream()
                            .map(Amount::getAmountType).collect(Collectors.toSet());

            for (AmountType type: AmountType.values()) {
                if (!amounts.contains(type)) {
                    final Amount amount = new Amount(type);
                    amountRepository.save(amount);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void initCategoryTypes () {
        try {
            final Set<CategoryType> categories =
                    categoryRepository.findAll().stream()
                            .map(Category::getCategoryType)
                            .collect(Collectors.toSet());

            for (CategoryType type: CategoryType.values()) {
                if (!categories.contains(type)) {
                    final Category category = new Category(type);
                    categoryRepository.save(category);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void initRoleTypes () {
        try {
            final Set<HomeworkJpaAccountRoleType> roles =
                    roleRepository.findAll().stream()
                            .map(HomeworkJpaRole::getRoleType)
                            .collect(Collectors.toSet());

            for (HomeworkJpaAccountRoleType type: HomeworkJpaAccountRoleType.values()) {
                if (!roles.contains(type)) {
                    final HomeworkJpaRole homeworkJpaRole = new HomeworkJpaRole(type);
                    roleRepository.save(homeworkJpaRole);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
