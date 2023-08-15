package com.example.backend.Service;

import com.example.backend.Entity.FoodInfo;
import com.example.backend.Repository.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodInfoService {

    @Autowired
    private FoodInfoRepository foodInfoRepository;

    public List<FoodInfo> findAll(){

        return foodInfoRepository.findAll();
    }
    public FoodInfo getonerest(Long rid){

        return foodInfoRepository.findByRid(rid);
    }
    public List<FoodInfo> getFoodstarmaxList(){

        return foodInfoRepository.findTop5ByOrderByRstaravgDesc();
    }
    public List<FoodInfo> SearchList(String cid){
        Long ccid = Long.valueOf(cid);
        return foodInfoRepository.findAllByCid(ccid);
    }
    public FoodInfo getFoodone(String rid){
        Long rrid = Long.valueOf(rid);
        return foodInfoRepository.findByRid(rrid);
    }
    public void save(FoodInfo foodInfo){
        foodInfoRepository.save(foodInfo);
    }

    public void delete(Long rid){
        foodInfoRepository.deleteById(rid);
    }
}
