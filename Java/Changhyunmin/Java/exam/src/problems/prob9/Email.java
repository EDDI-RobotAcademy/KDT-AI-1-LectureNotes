package problems.prob9;

import customLibrary.CustomRandom;

class Email {
    int MIN = 4;
    int MAX = 8;
    int tmpSring = 0;


    public void RandomEM(){
        for (int i = 0; i < 4; i++){
            int emailLength = CustomRandom.generateNumber(MIN, MAX);
            for (int j = 0; j < emailLength; j++) {
                tmpSring += (char) CustomRandom.generateNumber('a', 'z');
            }
        }
        System.out.println(tmpSring + "@test.com");
    }
}

