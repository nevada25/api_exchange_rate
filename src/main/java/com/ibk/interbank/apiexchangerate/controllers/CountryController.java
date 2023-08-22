package com.ibk.interbank.apiexchangerate.controllers;

import com.ibk.interbank.apiexchangerate.entity.Coin;
import com.ibk.interbank.apiexchangerate.entity.Country;
import com.ibk.interbank.apiexchangerate.response.ApiResponseUser;
import com.ibk.interbank.apiexchangerate.service.CoinService;
import com.ibk.interbank.apiexchangerate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<Country> users = countryService.all();
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Se Estan mostrando todos los paises correctamente")
                .status(HttpStatus.OK)
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponseUser> saveCountry(@RequestBody Country country) {
        Country userRequest = countryService.saveCountry(country);
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("El pais se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(userRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
