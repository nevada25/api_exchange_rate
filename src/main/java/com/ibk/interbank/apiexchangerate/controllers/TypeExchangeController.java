package com.ibk.interbank.apiexchangerate.controllers;

import com.ibk.interbank.apiexchangerate.entity.Coin;
import com.ibk.interbank.apiexchangerate.entity.DTO.TypeExchangeRateRequest;
import com.ibk.interbank.apiexchangerate.entity.DTO.TypeExchangeRateResponse;
import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;
import com.ibk.interbank.apiexchangerate.response.ApiResponseUser;
import com.ibk.interbank.apiexchangerate.service.CoinService;
import com.ibk.interbank.apiexchangerate.service.CountryService;
import com.ibk.interbank.apiexchangerate.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/typeExchangeRate")
@Slf4j
public class TypeExchangeController {


    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private CoinService coinService;
    @Autowired
    private CountryService countryService;

    @PostMapping("/consult")
    public ResponseEntity<ApiResponseUser> consultTypeExchangeRate(@RequestBody TypeExchangeRateRequest typeExchangeRateRequest) {

        Coin origin = coinService.findByCodeCoin(typeExchangeRateRequest.getAmount_origin());
        if (origin == null) {
           return responseNotFound("La moneda de origin no esta registrado o fue eliminada");
        }
        log.info("origin-symbol:{} ", typeExchangeRateRequest.getAmount_origin());
        log.info("Destiny-symbol:{} ", typeExchangeRateRequest.getAmount_destiny());
        Coin destiny = coinService.findByCodeCoin(typeExchangeRateRequest.getAmount_destiny());
        if (destiny == null) {
           return responseNotFound("La moneda  de destino no esta registrado o fue eliminada");
        }

        log.info("Destiny:{} ", destiny);
        //ExchangeRate> exchangeOrigin = exchangeRateService.findByCoin(origin.get().getId());
        ExchangeRate exchangeDestiny = exchangeRateService.findByCoin(destiny.getId());


        BigDecimal amount = BigDecimal.valueOf(typeExchangeRateRequest.getAmount());
        BigDecimal amount_destiny = BigDecimal.valueOf(exchangeDestiny.getAmount_sale());
        BigDecimal totalAmount = amount.multiply(amount_destiny);

        TypeExchangeRateResponse typeExchangeRateResponse = new TypeExchangeRateResponse();
        typeExchangeRateResponse.setAmount(amount.doubleValue());
        typeExchangeRateResponse.setAmount_then_type_change(totalAmount.doubleValue());
        typeExchangeRateResponse.setAmount_origin_simbol(origin.getCode_coin());
        typeExchangeRateResponse.setAmount_destiny_simbol(destiny.getCode_coin());
        typeExchangeRateResponse.setType_change(exchangeDestiny);

        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("El cambio de moneda se realizo correctamente")
                .status(HttpStatus.OK)
                .data(typeExchangeRateResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private ResponseEntity<ApiResponseUser> responseNotFound(String message) {
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(false)
                .message(message)
                .status(HttpStatus.NOT_FOUND)
                .data("")
                .build();
     return    ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
