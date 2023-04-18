package kr.eddi.demo.lectureClass.vue.problem3.controller;

import kr.eddi.demo.lectureClass.vue.problem3.controller.form.BuyFruitResponseForm;
import kr.eddi.demo.lectureClass.vue.problem3.fruitShop.FruitShopManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("fruit-shop")
public class VueProblem3Controller {

    @GetMapping("buy-apple")
    public BuyFruitResponseForm buyAppleShop() {
        log.info("buy-apple()");

        FruitShopManager fruitShopManager = new FruitShopManager();
        log.info("fruitShopManager: "+fruitShopManager);

        int buySumCost = fruitShopManager.getFruit().getApple().appleBuyCost();
        log.info("buySumCost: "+buySumCost);

        BuyFruitResponseForm buyFruitResponseForm = new BuyFruitResponseForm(
                buySumCost,
                fruitShopManager.getFruit().getApple().getName()
        );

        log.info("buyFruitResponseForm: "+buyFruitResponseForm);
        return buyFruitResponseForm;
    }

    @GetMapping("buy-waterMelon")
    public BuyFruitResponseForm buyWaterMelonShop() {
        log.info("buy-waterMelon()");

        FruitShopManager fruitShopManager = new FruitShopManager();
        log.info("fruitShopManager: "+fruitShopManager);

        int buySumCost = fruitShopManager.getFruit().getWaterMelon().waterMelonBuyCost();
        log.info("buySumCost: "+buySumCost);

        BuyFruitResponseForm buyFruitResponseForm = new BuyFruitResponseForm(
                buySumCost,
                fruitShopManager.getFruit().getWaterMelon().getName()
        );

        log.info("buyFruitResponseForm: "+buyFruitResponseForm);
        return buyFruitResponseForm;
    }

}
