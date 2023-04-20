package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Account {
    final private String email;
    final private String password;
    final private int id;

    private Character character;
    private static int idGenerator=0;
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        this.id = idGenerator++;
        this.character = new Character();
    }
}
