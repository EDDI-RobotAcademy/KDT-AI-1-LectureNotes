package com.example.demo.evaluation.problem21_26.service;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.entity.AccountRole;
import com.example.demo.evaluation.problem10_14_17_20.entity.RoleType;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRepository;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRoleRepository;
import com.example.demo.evaluation.problem10_14_17_20.repository.RoleRepository;
import com.example.demo.evaluation.problem21_26.controller.form.ProductRegisterRequestForm;
import com.example.demo.evaluation.problem21_26.entity.Product;
import com.example.demo.evaluation.problem21_26.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.evaluation.problem10_14_17_20.entity.RoleType.BUSINESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;
    final private AccountRepository accountRepository;
    final private AccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;
    Boolean isBusinessAccount = false;
    @Override
    public Product register(ProductRegisterRequestForm productRegisterRequestForm) {
        final RoleType roleType = BUSINESS;

        Optional<Account> maybeAccount = accountRepository.findByEmail(productRegisterRequestForm.getEmail());

        Optional<AccountRole> maybeAccountRole = accountRoleRepository.findByAccount(maybeAccount);

        log.info("maybeAccountRole.get().getRole().getRoleType(): " + maybeAccountRole.get().getRole().getRoleType().toString());
        if(roleType == maybeAccountRole.get().getRole().getRoleType()) {
            isBusinessAccount = true;
        }

        if(isBusinessAccount){
            Optional<Product> maybeProduct =
                    productRepository.findByProductName(productRegisterRequestForm.getProductName());

            if(maybeProduct.isPresent()) {
                log.info("이미 등록된 상품입니다.");
                return null;
            }

            final Product product =
                    new Product(
                            productRegisterRequestForm.getEmail(),
                            productRegisterRequestForm.getProductName(),
                            productRegisterRequestForm.getProductPrice());

            productRepository.save(product);

            return product;
        }
        return null;
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Product read(Long id) {
        Optional<Product> maybeProduct = productRepository.findById(id);

        if (maybeProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
        log.info("뭘까: " + maybeProduct.get().getId());
        return maybeProduct.get();
    }
}
