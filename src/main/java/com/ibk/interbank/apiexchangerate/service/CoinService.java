package com.ibk.interbank.apiexchangerate.service;

import com.ibk.interbank.apiexchangerate.entity.Coin;

import java.util.List;
import java.util.Optional;

public interface CoinService {
    Coin saveCoin(Coin coin);


    List<Coin> all();

    Coin byId(Long id);

    Coin findByCodeCoin(String code);
}
