package kr.eddi.demo.lectureClass.vue.problem.controller;


import kr.eddi.demo.lectureClass.vue.problem.controller.form.FruitNumber;
import kr.eddi.demo.lectureClass.vue.problem.entity.FruitSale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/apple-watermelon")
public class FruitController {

    @GetMapping("sales")
    public void appleWatermelonSales(){
        
    }

    @PostMapping("/number")
    public void appleWatermelonNumber(@RequestBody FruitNumber fruitNumber){
        log.info("received data: " + fruitNumber);
        FruitSale fruitSale = new FruitSale(fruitNumber);

    }
}
