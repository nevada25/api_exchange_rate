package com.ibk.interbank.apiexchangerate.service;

import com.ibk.interbank.apiexchangerate.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    
    Country saveCountry(Country Country);
    
    List<Country> all();

    Country byId(Long id);
}
