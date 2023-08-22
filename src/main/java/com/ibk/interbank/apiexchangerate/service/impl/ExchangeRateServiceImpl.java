package com.ibk.interbank.apiexchangerate.service.impl;

import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;
import com.ibk.interbank.apiexchangerate.exceptions.ResourceNotFoundException;
import com.ibk.interbank.apiexchangerate.repository.ExchangeRateRepository;
import com.ibk.interbank.apiexchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;


    @Override
    public ExchangeRate saveExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public List<ExchangeRate> all() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate byId(Long id) {
        return exchangeRateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tipo de cambio no encontrado con el id" + id));
    }

    @Override
    public ExchangeRate findByCoin(Long coin_id) {
        return exchangeRateRepository.findByCoin(coin_id).orElseThrow(() -> new ResourceNotFoundException("Tipo de cambio no encontrado con el id" + coin_id));
    }
}
