package com.ibk.interbank.apiexchangerate.repository;

import com.ibk.interbank.apiexchangerate.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository  extends JpaRepository<Coin, Long> {


    @Query(nativeQuery = true,value = "SELECT * FROM coins where code_coin=:code")
    Coin findByCodeCoin(String code);

}
