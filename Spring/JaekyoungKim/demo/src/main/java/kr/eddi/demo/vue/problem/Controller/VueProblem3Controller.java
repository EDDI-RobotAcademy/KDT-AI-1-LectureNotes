package kr.eddi.demo.vue.problem.Controller;

import kr.eddi.demo.vue.problem.Controller.form.OrderedFruitsListForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/fruits-test")
public class VueProblem3Controller {

    @GetMapping("test")
    public String helloTest () {
        return "Hello, I'm alive!";
    }

    @PostMapping("/calculate")
    // 가격을 더해서 보낼거기 때문에 Integer형으로 생성합니다.
    public Integer calculateOrderedFruitsList (@RequestBody OrderedFruitsListForm orderedFruitsListForm) {
        //리퀘스트 바디는 정보를 받을 형식을 뜻합니다.
        //저쪽에서 보내는 데이터가 리스트를 잘게 나눠어서 보내기때문에
        // 사과 이름 사과 가격 수박 이름 수박 가격 이렇게 나누어진 리스트 폼으로 받습니다.

        log.info("calculateOrderedFruitsList(): " + orderedFruitsListForm);

        final int APPLE_COST = 2000;
        //사과 가격은 2000
        //수박 가격은 10000
        final int WATERMELON_COST = 10000;

        //사과 가격 과 사과 갯수 곱한 것과 수박 가격과 수박 갯수 곱한것 더해서 리턴 함
        return orderedFruitsListForm.getAppleCount() * APPLE_COST +
                orderedFruitsListForm.getWatermelonCount() * WATERMELON_COST;
    }
}