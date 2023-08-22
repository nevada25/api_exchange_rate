package com.ibk.interbank.apiexchangerate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private String userId;
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 200)
    private String password;

    @Column(name = "email", unique = true,length = 50)
    @Email(message = "Email no valido")
    private String email;

    @Column(nullable = false,columnDefinition = "TINYINT")
    private boolean locked;

    @Column(nullable = false,columnDefinition = "TINYINT")
    private boolean disabled;


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<UserRole> roles;

}
