package pl.github.maciasx.FoodMenu.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.github.maciasx.FoodMenu.model.Sex;
import pl.github.maciasx.FoodMenu.model.UserRole;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "login")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Integer age;

    private Double height;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(String username,
                String email,
                String password,
                Integer age,
                Double height,
                Sex sex,
                UserRole userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.userRole = userRole;
    }

    public User(String username, String email, String password, UserRole userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

}
