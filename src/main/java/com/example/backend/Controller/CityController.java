package com.example.backend.Controller;

import com.example.backend.Entity.City;
import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.CityService;
import com.example.backend.Service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/cityfindAll")
    public List<City> findAll() {
    //전체 리스트
        return cityService.findAll();
    }
}
