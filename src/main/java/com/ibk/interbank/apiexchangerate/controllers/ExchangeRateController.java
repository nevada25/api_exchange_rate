package com.ibk.interbank.apiexchangerate.controllers;

import com.ibk.interbank.apiexchangerate.entity.Coin;
import com.ibk.interbank.apiexchangerate.entity.Country;
import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;
import com.ibk.interbank.apiexchangerate.entity.ExchangeRateRequest;
import com.ibk.interbank.apiexchangerate.response.ApiResponseUser;
import com.ibk.interbank.apiexchangerate.service.CoinService;
import com.ibk.interbank.apiexchangerate.service.CountryService;
import com.ibk.interbank.apiexchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchangeRates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private CoinService coinService;
    @Autowired
    private CountryService countryService;




    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<ExchangeRate> users = exchangeRateService.all();
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Se Estan mostrando todos los cambios correctamente")
                .status(HttpStatus.OK)
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponseUser> saveExchange(@RequestBody ExchangeRateRequest exchangeRateRequest) {
        Coin coinById = coinService.byId(exchangeRateRequest.getCoin_id());
        if (coinById==null) {
            responseNotFound("La moneda no esta registrado o fue eliminada");
        }
        Country countryById = countryService.byId(exchangeRateRequest.getCountry_id());
        if (countryById==null) {
            responseNotFound("La pais no esta registrado o fue eliminada");
        }

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setAmount(exchangeRateRequest.getAmount());
        exchangeRate.setAmount_sale(exchangeRateRequest.getAmount_sale());
        exchangeRate.setAmount_purchase(exchangeRateRequest.getAmount_purchase());
        exchangeRate.setDate_change(exchangeRateRequest.getDate_change());
        exchangeRate.setCoin(coinById);
        exchangeRate.setCountry(countryById);
        exchangeRateService.saveExchangeRate(exchangeRate);

        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("La moneda se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(exchangeRate)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }






    @PutMapping("/{exchangeId}")
    public ResponseEntity<ApiResponseUser> updateExchange(@RequestBody ExchangeRateRequest exchangeRateRequest, @PathVariable Long exchangeId) {
        Coin coinById = coinService.byId(exchangeRateRequest.getCoin_id());
        if (coinById==null) {
            responseNotFound("La moneda no esta registrado o fue eliminada");
        }
        Country countryById = countryService.byId(exchangeRateRequest.getCountry_id());
        if (countryById==null) {
            responseNotFound("La pais no esta registrado o fue eliminada");
        }


        ExchangeRate exchangeRateByID = exchangeRateService.byId(exchangeId);
        exchangeRateByID.setAmount(exchangeRateRequest.getAmount());
        exchangeRateByID.setAmount_sale(exchangeRateRequest.getAmount_sale());
        exchangeRateByID.setAmount_purchase(exchangeRateRequest.getAmount_purchase());
        ExchangeRate userRequest = exchangeRateService.saveExchangeRate(exchangeRateByID);
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("La moneda se ha modificado correctamente")
                .status(HttpStatus.OK)
                .data(userRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    private ResponseEntity<ApiResponseUser> responseNotFound(String message) {
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(false)
                .message(message)
                .status(HttpStatus.NOT_FOUND)
                .data("")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
