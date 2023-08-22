package com.ibk.interbank.apiexchangerate.service;

import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateService {

    ExchangeRate saveExchangeRate(ExchangeRate ExchangeRate);


    List<ExchangeRate> all();

    ExchangeRate byId(Long id);


    ExchangeRate findByCoin(Long coin_id);
}
