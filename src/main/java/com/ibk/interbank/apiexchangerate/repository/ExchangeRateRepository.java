package com.ibk.interbank.apiexchangerate.repository;

import com.ibk.interbank.apiexchangerate.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM exchange_rates where coin_id=:coin_id")
    Optional<ExchangeRate> findByCoin(Long coin_id);

}
