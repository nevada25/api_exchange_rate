package com.ibk.interbank.apiexchangerate.entity.DTO;


import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeExchangeRateResponse {
    private double amount;
    private double amount_then_type_change;
    private String amount_origin_simbol;
    private String amount_destiny_simbol;
    private ExchangeRate type_change;
}
