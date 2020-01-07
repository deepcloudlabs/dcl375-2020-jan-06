package com.example.world.dao.inmemory;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import com.example.world.dao.WorldDao;
import com.example.world.domain.City;
import com.example.world.domain.Country;

@Named
@ApplicationScoped
@Alternative
public class OracleWorldDao implements WorldDao {

	@Override
	public Country findCountryByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country removeCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country addCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAllContinents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City findCityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City removeCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City addCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City updateCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findAllCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findCitiesByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
