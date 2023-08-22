package com.ibk.interbank.apiexchangerate.service.impl;

import com.ibk.interbank.apiexchangerate.entity.Coin;
import com.ibk.interbank.apiexchangerate.exceptions.ResourceNotFoundException;
import com.ibk.interbank.apiexchangerate.repository.CoinRepository;
import com.ibk.interbank.apiexchangerate.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinServiceImpl implements CoinService {


    @Autowired
    private CoinRepository coinRepository;

    @Override
    public Coin saveCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public List<Coin> all() {
        return (List<Coin>) coinRepository.findAll();
    }

    @Override
    public Coin byId(Long id) {
        return coinRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Moneda no encontrado con el id" + id));
    }

    @Override
    public Coin findByCodeCoin(String code) {
        return coinRepository.findByCodeCoin(code);
    }
}
