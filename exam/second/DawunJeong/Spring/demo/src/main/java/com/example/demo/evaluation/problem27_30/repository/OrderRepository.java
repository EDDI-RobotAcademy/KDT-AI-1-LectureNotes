package com.example.demo.evaluation.problem27_30.repository;


import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem27_30.entity.SampleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<SampleOrder, Long> {

    List<SampleOrder> findAllByAccount(Optional<Account> maybeAccount);
}
