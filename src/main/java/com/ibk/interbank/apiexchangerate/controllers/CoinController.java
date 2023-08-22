package com.ibk.interbank.apiexchangerate.controllers;


import com.ibk.interbank.apiexchangerate.entity.Coin;
import com.ibk.interbank.apiexchangerate.response.ApiResponseUser;
import com.ibk.interbank.apiexchangerate.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;


    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<Coin> users = coinService.all();
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Se Estan mostrando todos los monedas correctamente")
                .status(HttpStatus.OK)
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponseUser> saveUser(@RequestBody Coin coin) {
        Coin userRequest = coinService.saveCoin(coin);
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("La moneda se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(userRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
