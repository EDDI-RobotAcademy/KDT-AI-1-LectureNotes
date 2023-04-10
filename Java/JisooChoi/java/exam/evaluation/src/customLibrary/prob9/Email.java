package customLibrary.prob9;

public class Email {
    final String com = "@test.com";
    private String emailRandomName = "";

    public Email(){
        final int LENGTH_MAX = 8;
        final int LENGTH_MIN = 5;
        int emailRandomLength = (int)(Math.random() * LENGTH_MAX-LENGTH_MIN+1) + LENGTH_MIN;

        final int ALPHABET_MAX = 26;
        final int ALPHABET_MIN = 97;
        for(int i = 0; i < emailRandomLength; i++){
            emailRandomName += (char)((Math.random() * ALPHABET_MAX) + ALPHABET_MIN);
        }
        emailWebName(emailRandomName);
    }

    public void emailWebName(String emailName){
        String result = emailName.concat(this.com);
        System.out.println(result);
    }

}
