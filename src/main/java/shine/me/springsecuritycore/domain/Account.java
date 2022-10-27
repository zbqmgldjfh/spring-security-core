package shine.me.springsecuritycore.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long Id;

    private String username;
    private String password;
    private String email;
    private String role;

    public Account() {
    }
}
