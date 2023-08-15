package com.example.backend.Service;

import com.example.backend.Entity.City;
import com.example.backend.Entity.FoodInfo;
import com.example.backend.Repository.CityRepository;
import com.example.backend.Repository.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(){

        return cityRepository.findAll();
    }
}
