package com.ibk.interbank.apiexchangerate.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateRequest {

    private Date date_change;

    @NotBlank(message = "El monto no puede estar en blanco")
    @NotNull(message = "El monto es obligatorio")
    private double amount;

    @NotBlank(message = "El monto de venta no puede estar en blanco")
    @NotNull(message = "El monto de venta es obligatorio")
    private double amount_sale;

    @NotBlank(message = "El monto de compra no puede estar en blanco")
    @NotNull(message = "El monto de compra  es obligatorio")
    private double amount_purchase;

    @NotBlank(message = "El id de la moneda no puede estar en blanco")
    @NotNull(message = "El id de la moneda  es obligatorio")
    private Long coin_id;

    @NotBlank(message = "El id del pais no puede estar en blanco")
    @NotNull(message = "El id del pais es obligatorio")
    private Long country_id;

}
