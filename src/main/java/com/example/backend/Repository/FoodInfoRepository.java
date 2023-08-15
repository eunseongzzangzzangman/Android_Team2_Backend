package com.example.backend.Repository;

import com.example.backend.Entity.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodInfoRepository extends JpaRepository<FoodInfo,Long> {
    List<FoodInfo> findAllByCid(Long cid);

    List<FoodInfo> findTop5ByOrderByRstaravgDesc();

    FoodInfo findByRid(Long rid);
}
