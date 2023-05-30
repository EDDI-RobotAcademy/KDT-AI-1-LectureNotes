package com.example.demo.config;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Amount;
import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.repository.AmountRepository;
import com.example.demo.lectureClass.aggregateRoot.food.repository.CategoryRepository;
import com.example.demo.lectureClass.refactorAccount.entity.Role;
import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import com.example.demo.lectureClass.refactorAccount.repository.RoleRepository;
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

    private final CategoryRepository categoryRepository;
    private final AmountRepository amountRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    private void init () {
        log.debug("initializer 시작!");

        initCategoryTypes();
        initAmountTypes();

        initAccountRoleTypes();

        log.debug("initializer 종료!");
    }

    private void initAccountRoleTypes() {
        try {
            final Set<RoleType> roles =
                    roleRepository.findAll().stream()
                            .map(Role::getRoleType)
                            .collect(Collectors.toSet());

            for (RoleType type : RoleType.values()) {
                if (!roles.contains(type)) {
                    final Role role = new Role(type);
                    roleRepository.save(role);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    private void initAmountTypes () {
        try {
            final Set<AmountType> amounts =
                    amountRepository.findAll().stream()
                            .map(Amount::getAmountType)
                            .collect(Collectors.toSet());

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
}
