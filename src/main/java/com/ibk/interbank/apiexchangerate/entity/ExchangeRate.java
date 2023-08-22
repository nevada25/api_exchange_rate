package com.ibk.interbank.apiexchangerate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "exchange_rates")
public class ExchangeRate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date_change;

    private double amount;

    private double amount_sale;

    private double amount_purchase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coin_id",referencedColumnName = "id")
    private Coin coin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;

}

