package com.ibk.interbank.apiexchangerate.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El codigo no puede estar en blanco")
    @NotNull(message = "El codigo es obligatorio")
    private String code_coin;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @NotNull(message = "El nombre es obligatorio")
    private String name_coin;


}
