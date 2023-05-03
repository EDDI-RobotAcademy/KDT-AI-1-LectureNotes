package kr.eddi.demo.vue;

import kr.eddi.demo.vue.controller.form.FruitsForm;
import kr.eddi.demo.vue.controller.form.MyDataForm;
import kr.eddi.demo.vue.controller.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/my-test")
public class MyController {


//
//
//   static int aAmount=fruitsForm.getAppleAmount();
//    static int gAmount=fruitsForm.getGrapeAmount();

    @PostMapping("/my-page")
    //public void myPage(@RequestBody MyDataForm myDataForm){
    public void myPage(@RequestBody MyDataForm myDataForm) {

        log.info("my data: "+myDataForm);
    }
}
//    @PostMapping("/fruits-test")
//    public Integer myFruits(@RequestBody FruitsForm fruitsForm) {
//        log.info("my data: "+fruitsForm);
//        int applePrice=2000*fruitsForm.getAppleAmount();
//        int grapePrice=3000*fruitsForm.getGrapeAmount();
//        Integer allFruitsPrice= (Integer) (applePrice+grapePrice);
//        return allFruitsPrice;
//
//    }


