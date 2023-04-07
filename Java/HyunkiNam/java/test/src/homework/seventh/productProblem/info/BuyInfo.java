package homework.seventh.productProblem.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyInfo {

    Map<String, List<Integer>> buyInfoMap = new HashMap<>();

    public BuyInfo(){
    }

    public void inputBuyInfo(String productName, int memberId){
        List<Integer> memberIdList = new ArrayList<>();

        if(buyInfoMap.containsKey(productName)){
            memberIdList = buyInfoMap.get(productName);
            memberIdList.add(memberId);
        }else {
            memberIdList.add(memberId);
        }
        buyInfoMap.put(productName,memberIdList);
    }


    public Map<String, List<Integer>> getBuyInfoMap() {
        return buyInfoMap;
    }

    @Override
    public String toString() {
        return "BuyInfo{" +
                "buyInfoMap=" + buyInfoMap +
                '}';
    }
}
