package kr.eddi.demo.controller;

import kr.eddi.demo.controller.character.Character;
import kr.eddi.demo.controller.form.*;
import kr.eddi.demo.controller.product.ProductOrder;
import kr.eddi.demo.homework.GameManager;
import kr.eddi.demo.lectureClass.vue.controller.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/homework")
public class HomeworkController {
    String str;
    int apple = 0;
    int watermelon = 0;

    int apple2 = 0;
    int watermelon2 = 0;

    List<Character> characterList = new ArrayList<>();

    @GetMapping("/win-condition-is-even")
    public StringBuilder winConditionIsEVEN(){
        final int MIN = 1;
        final int MAX = 6;
        final int EVEN_CHECK = 2;

        final int firstNumber = CustomRandom.generateNumber(MIN,MAX);
        final int secondNumber = CustomRandom.generateNumber(MIN,MAX);

        final int sum = firstNumber + secondNumber;

        StringBuilder sb = new StringBuilder();
        sb.append("첫번째 주사위: ").append(firstNumber)
                .append(" 두번째 주사위: ").append(secondNumber)
                .append(" 합 : ").append(sum);
        if(sum % EVEN_CHECK ==0){
            sb.append(" 승리");
            return sb;
        }
        sb.append(" 패배");
        return sb;
    }

    @GetMapping("/dice-game")
    public String diceGame(){
        GameManager gameManager = new GameManager();

        gameManager.playGame();

        return String.valueOf(gameManager.printPlayerList()) +" 승자 : "+ String.valueOf(gameManager.checking());
    }

    @PostMapping("/send-hello")
    public void receiveHello(@RequestBody String hello){
        log.info("received data: " + hello);
        this.str = hello.substring(hello.indexOf(":\"")+2,hello.indexOf("}")-1);;

        System.out.println(str);
    }

    @GetMapping("/get-message")
    public String receiveTest(){
        return str;
    }

    @PostMapping("buy-apple")
    public void buyApple(){
        apple++;
    }

    @PostMapping("buy-watermelon")
    public void buyWatermelon(){
        watermelon++;
    }

    @PostMapping("buy-fruit")
    public void buyApple2(@RequestBody BuyFruitForm buyFruitForm){
        this.apple2 = buyFruitForm.getApple2();
        this.watermelon2 = buyFruitForm.getWatermelon2();
    }

    @GetMapping("get-buy-list")
    public BuyListDataForm getBuyList(){
        int buyPriceSum = (apple * 2000) + (watermelon * 10000);
        BuyListDataForm buyListDataForm = new BuyListDataForm(apple, watermelon, buyPriceSum);

        return buyListDataForm;
    }

    @GetMapping("get-buy-list2")
    public BuyListDataForm getBuyList2(){
        int buyPriceSum = (apple2 * 2000) + (watermelon2 * 10000);
        BuyListDataForm buyListDataForm2 = new BuyListDataForm(apple2, watermelon2, buyPriceSum);

        return buyListDataForm2;
    }

    @PostMapping("create-character")
    public boolean createCharacter(@RequestBody CharacterInfoForm characterInfoForm){
        for(int i=0; i<characterList.size(); i++){
            if(Objects.equals(characterList.get(i).getUser_email(), characterInfoForm.getUser_email())){
                return false;
            }
        }
        characterList.add(
                new Character(characterInfoForm.getUser_email(), characterInfoForm.getUser_password()));
        System.out.println(characterList);
        return true;
    }

    @GetMapping("get-character-status")
    public CharacterStatusForm getCharacterInfo(@RequestParam(value = "playerIdx") String playerIdx){

        int playerIndex = Integer.parseInt(playerIdx)-1;

        String user_email = characterList.get(playerIndex).getUser_email();
        int strength = characterList.get(playerIndex).getStrength();
        int dexterity = characterList.get(playerIndex).getDexterity();
        int intellect = characterList.get(playerIndex).getIntellect();

        CharacterStatusForm characterStatusForm = new CharacterStatusForm(user_email, strength, dexterity, intellect);
        System.out.println(characterStatusForm);

        return characterStatusForm;
    }

    Map<Integer, ProductOrder> productOrderMap = new HashMap<>();

    @PostMapping("product-order")
    public void productOrder(@RequestBody ProductOrderInfo productOrderInfo){

        ProductOrder productOrder = new ProductOrder(
                productOrderInfo.getOrderNumber(), productOrderInfo.getCustomerName(), productOrderInfo.getCustomerAddress()
                , productOrderInfo.getCustomerPhoneNumber(), productOrderInfo.getTotalPrice());

        productOrderMap.put(productOrderInfo.getOrderNumber(), productOrder);
    }

    @PostMapping("/find-product-order")
    public ProductOrder findProductOrder(@RequestBody FindProductOrderInfo findProductOrderInfo){

        return productOrderMap.get(findProductOrderInfo.getFindOrderInfoNumber());

    }
}
