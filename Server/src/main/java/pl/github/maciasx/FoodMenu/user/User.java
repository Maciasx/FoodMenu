package pl.github.maciasx.FoodMenu.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.github.maciasx.FoodMenu.model.Sex;

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

    private Double weight;

    @Enumerated(EnumType.STRING)
    private Sex sex;

}
