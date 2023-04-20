package kr.eddi.demo.problem4;

import lombok.RequiredArgsConstructor;


public class LoginResponseForm {
    final private String email;
    final private Character character;
    final String message;
    boolean isSuccess = false;

    public LoginResponseForm(String email, Character character, int messageType) {
        this.email = email;
        this.character = character;

        final int SUCCESS = 0;
        final int WRONG_PASSWORD = 1;
        final int WRONG_ID = 2;

        switch (messageType) {
            case (SUCCESS) -> {message = "SUCCSS LOGIN";
                isSuccess = true;}
            case (WRONG_PASSWORD) -> message = "WRONG_PASSWORD";
            case (WRONG_ID) -> message = "WRONG ID";
            default -> message = "ERROE";
        }

    }
}
