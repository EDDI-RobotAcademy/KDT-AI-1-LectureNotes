package kr.eddi.demo.config;

import jakarta.annotation.PostConstruct;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Amount;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Category;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import kr.eddi.demo.lectureClass.aggregateRoot.food.repository.AmountRepository;
import kr.eddi.demo.lectureClass.aggregateRoot.food.repository.CategoryRepository;
import kr.eddi.demo.lectureClass.refactorAccount.entity.Role;
import kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType;
import kr.eddi.demo.lectureClass.refactorAccount.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j // Lombok을 사용하여 로그(Log) 인스턴스를 자동으로 생성합니다.
@Component // 이 클래스를 스프링 컨테이너에서 관리되는 Bean으로 등록합니다.
@RequiredArgsConstructor // 초기화되지 않은 final 필드를 인자로 받는 생성자를 자동으로 생성합니다.
public class DBInitializer {

    private final CategoryRepository categoryRepository; // CategoryRepository 인스턴스를 주입 받습니다.
    private final AmountRepository amountRepository; // AmountRepository 인스턴스를 주입 받습니다.
    private final RoleRepository roleRepository; // RoleRepository 인스턴스를 주입 받습니다.

    // 스프링 빈 생성 후 초기화 작업을 수행합니다.
    @PostConstruct
    private void init () {
        log.debug("initializer 시작!");

        initCategoryTypes(); // CategoryTypes 초기화 메소드를 호출합니다.
        initAmountTypes(); // AmountTypes 초기화 메소드를 호출합니다.
        initAccountRoleTypes(); // AccountRoleTypes 초기화 메소드를 호출합니다.

        log.debug("initializer 종료!"); // 초기화 종료 메시지를 출력합니다.
    }

    // 데이터베이스에 Account RoleTypes를 초기화합니다.
    private void initAccountRoleTypes() {
        try {
            final Set<RoleType> roles = // 현재 가지고 있는 롤 이름들을 받아옵니다.
                    roleRepository.findAll().stream()
                            .map(Role::getRoleType)
                            .collect(Collectors.toSet());

            for (RoleType type: RoleType.values()) {
                if (!roles.contains(type)) {
                    final Role role = new Role(type);
                    roleRepository.save(role); // 없는 롤 이름이면 해당 롤을 저장합니다.
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    // 데이터베이스에 AmountTypes를 초기화합니다.
    private void initAmountTypes () {
        try {
            final Set<AmountType> amounts = // 현재 가지고 있는 AmountType들을 받아옵니다.
                    amountRepository.findAll().stream()
                            .map(Amount::getAmountType)
                            .collect(Collectors.toSet());

            for (AmountType type: AmountType.values()) {
                if (!amounts.contains(type)) {
                    final Amount amount = new Amount(type);
                    amountRepository.save(amount); // 없는 AmountType이면 해당 Amount를 저장합니다.
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    // 데이터베이스에 CategoryTypes를 초기화합니다.
    private void initCategoryTypes () {
        try {
            final Set<CategoryType> categories = // 현재 가지고 있는 CategoryType들을 받아옵니다.
                    categoryRepository.findAll().stream()
                            .map(Category::getCategoryType)
                            .collect(Collectors.toSet());

            for (CategoryType type: CategoryType.values()) {
                if (!categories.contains(type)) {
                    final Category category = new Category(type);
                    categoryRepository.save(category); // 없는 CategoryType이면 해당 Category를 저장합니다.
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
