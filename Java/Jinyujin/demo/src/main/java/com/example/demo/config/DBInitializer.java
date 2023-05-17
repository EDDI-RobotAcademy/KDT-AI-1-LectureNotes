package com.example.demo.config;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Amount;
import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.repository.AmountRepository;
import com.example.demo.lectureClass.aggregateRoot.food.repository.CategoryRepository;
import com.example.demo.lectureClass.fetchType.account.entity.Role;
import com.example.demo.lectureClass.fetchType.account.entity.RoleType;
import com.example.demo.lectureClass.fetchType.account.repository.RoleRepository;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeLecture;
import com.example.demo.lectureClass.testCode.lectureWithStudent.repository.LecturePracticeRepository;
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
    private final LecturePracticeRepository lectureRepository;

    @PostConstruct   // 스프링이 처음에 구동되기 시작하는 시점에 초기화하도록
    private void init () {
        log.debug("initializer 시작!");

        initCategoryTypes();
        initAmountTypes();

        initRoleTypes();

        initLectureTypes();

        log.debug("initializer 종료!");
    }

    private void initLectureTypes() {
        try {
            final Set<LectureType> lectures =
                    lectureRepository.findAll().stream()
                            .map(PracticeLecture::getLectureType)
                            .collect(Collectors.toSet());

            for (LectureType type: LectureType.values()) {
                if (!lectures.contains(type)) {
                    final PracticeLecture lecture = new PracticeLecture(type);
                    lectureRepository.save(lecture);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void initRoleTypes() {
        try {
            final Set<RoleType> roles =
                    roleRepository.findAll().stream()
                            .map(Role::getRoleType)
                            .collect(Collectors.toSet());

            for (RoleType type: RoleType.values()) {
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
        // AmountType이라는 Enum 클래스에 없는 값이 있다면 새로운 Enum 값을 생성하고 저장하도록 함
        try {
            final Set<AmountType> amounts =
                    amountRepository.findAll().stream()
                            // stream 객체로 다 찾아와라
                            .map(Amount::getAmountType)
                            // Amount 중에서 AmountType 필드만 추출
                            .collect(Collectors.toSet());
                            // set객체로 변환
                            // -> 여기에는 이미 존재하는 AmountType 값을 저장하고 있음

            for (AmountType type: AmountType.values()) {
                // AmountType.values() - enum에 있는 값 싹 가져옴
                if (!amounts.contains(type)) {
                    // contains를 통해 이미 Set객체에 이미 해당 값이 포함되어 있는지 확인
                    final Amount amount = new Amount(type);
                    amountRepository.save(amount);
                    // 포함되어 있지 않다면 새로운 Amount 객체를 생성하고 저장
                }
            }
            // 이 for문 자체가 가지는 최고의 장점은?
            // 양의 단위 수에 Kg을 추가하고 싶다면 amountType enum에 KG만 추가하면 된다
            // 카테고리에도 치킨을 추가하고 싶다면 카테고리Type enum에 CHICKEN만 추가하면 된다
            // 확장성 측면, 비용 측면에서 모두 장점
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

// DB에 아무것도 없는데 repository에서 찾아올 수 있었던 것은
// 여기에서 초기화해줬기 때문에
