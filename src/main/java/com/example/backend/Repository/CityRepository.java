package com.example.backend.Repository;

import com.example.backend.Entity.City;
import com.example.backend.Entity.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
