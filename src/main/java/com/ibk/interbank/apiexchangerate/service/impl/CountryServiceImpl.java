package com.ibk.interbank.apiexchangerate.service.impl;

import com.ibk.interbank.apiexchangerate.entity.Country;
import com.ibk.interbank.apiexchangerate.exceptions.ResourceNotFoundException;
import com.ibk.interbank.apiexchangerate.repository.CountryRepository;
import com.ibk.interbank.apiexchangerate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {


    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> all() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country byId(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pais no encontrado con el id" + id));
    }
}
