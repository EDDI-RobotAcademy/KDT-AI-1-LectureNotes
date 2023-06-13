package com.example.demo.evaluation.problem27_30.service;


import com.example.demo.evaluation.problem27_30.controller.OrderRequestForm;
import com.example.demo.evaluation.problem27_30.entity.SampleOrder;

import java.util.List;

public interface OrderService {
    SampleOrder order(OrderRequestForm orderRequestForm, Long accountId);
    List<SampleOrder> list(Long accountId);

}
