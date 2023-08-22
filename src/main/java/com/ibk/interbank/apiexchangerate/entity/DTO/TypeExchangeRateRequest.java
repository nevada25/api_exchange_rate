package com.ibk.interbank.apiexchangerate.entity.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeExchangeRateRequest {

    @NotBlank(message = "El monto no puede estar en blanco")
    @NotNull(message = "El monto es obligatorio")
    private double amount;

    @NotBlank(message = "La moneda no puede estar en blanco")
    @NotNull(message = "La moneda es obligatorio")
    private String amount_origin;

    @NotBlank(message = "La moneda de destino no puede estar en blanco")
    @NotNull(message = "La moneda de destino es obligatorio")
    private String amount_destiny;


}
