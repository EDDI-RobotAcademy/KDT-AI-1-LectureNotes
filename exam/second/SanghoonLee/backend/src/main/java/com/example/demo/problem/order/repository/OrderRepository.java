package com.example.demo.problem.order.repository;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.order.entity.Orders;
import com.example.demo.problem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    // @Query("select distinct p from Product p join fetch p.productImagesList pi " +
    //            "where p.id in (select o.product.id from Orders o where o.account = :account)")
    //@Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.productImagesList pi JOIN Orders o WHERE o.account = :account")

    //@Query("select o.product from Orders o join fetch Product p join fetch ProductImages pi where o.account = :account")

    // SELECT p.id, p.product_details, p.product_name, p.product_price FROM product p
    // JOIN orders o ON p.id = o.product_id
    // JOIN account a ON o.account_account_id = a.account_id
    // WHERE a.account_id = '2';
    @Query(value = "SELECT p.id, p.product_details, p.product_name, p.product_price FROM product p " +
            "JOIN orders o ON p.id = o.product_id " +
            "JOIN account a ON o.account_account_id = a.account_id " +
            "WHERE a.account_id = :accountId", nativeQuery = true)
    List<Object[]> findAllProductInfoByAccount(Long accountId);
}
