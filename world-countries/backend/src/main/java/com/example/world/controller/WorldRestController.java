package com.example.world.controller;

import com.example.world.dao.CountryDao;
import com.example.world.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collection;

import static java.util.Objects.isNull;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@RestController
@RequestScope
@CrossOrigin
public class WorldRestController {
    private CountryDao countryDao;

    public WorldRestController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    // GET http://localhost:7070/world/api/continents
    @GetMapping("continents")
    public Collection<String> getContinents() {
        return countryDao.getAllContinents();
    }

    // GET http://localhost:7070/world/api/countries?continent=Asia
    @GetMapping("countries")
    public Collection<Country> getCountriesByContinent(@RequestParam(value = "continent", required = false) String continent) {
        if (isNull(continent))
            return countryDao.findAllCountries();
        return countryDao.findCountriesByContinent(continent);
    }
}
