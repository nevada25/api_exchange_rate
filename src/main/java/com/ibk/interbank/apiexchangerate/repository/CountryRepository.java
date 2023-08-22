package com.ibk.interbank.apiexchangerate.repository;

import com.ibk.interbank.apiexchangerate.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country, Long> {
}
