package kr.eddi.demo.vue.controller;

import kr.eddi.demo.vue.controller.form.FishForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fish-test")
public class FishController {

    @PostMapping("/fish-price")
    public FishForm howMuch (@RequestBody FishForm fishForm){
       log.info(String.valueOf(fishForm));
       int highFishPrice=3000* fishForm.getHighFish();
       int threeFishPrice=2000*fishForm.getThreeFish();
       FishForm fishPrice= new FishForm(highFishPrice,threeFishPrice);

       return fishPrice;
    }


}
