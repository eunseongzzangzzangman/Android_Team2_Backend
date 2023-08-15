package com.example.backend.Controller;

import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodInfoController {

    @Autowired
    FoodInfoService foodInfoService;

    @Autowired
    public FoodInfoController(FoodInfoService foodInfoService) {
        this.foodInfoService = foodInfoService;
    }


    @GetMapping("/foodfindAll")
    public List<FoodInfo> findAll() {
    //전체 리스트
        return foodInfoService.findAll();
    }
    @GetMapping("/getFoodstarmaxList")
    public List<FoodInfo> getFoodstarmaxList() {
        //전체 리스트
        return foodInfoService.getFoodstarmaxList();
    }
    @GetMapping("/getFoodone")
    public FoodInfo getFoodone(@RequestParam("rid") String rid) {
        //전체 리스트
        return foodInfoService.getFoodone(rid);
    }
    @GetMapping("/getSearchList")
    public List<FoodInfo> SearchList(@RequestParam("cid") String cid) {
        //전체 리스트
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+cid);
        return foodInfoService.SearchList(cid);
    }
    @PostMapping("/postFoodInfo")
    //인서트
    public void postFoodInfo(@RequestBody FoodInfo foodInfo){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(foodInfo.getRmainimg());
        foodInfoService.save(foodInfo);
    }

    @PostMapping("/postFoodInfodelete")
    public ResponseEntity<String> postFoodInfodelete(@RequestBody FoodInfo foodInfo){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(foodInfo.getRid());
        Long rid = foodInfo.getRid();
        foodInfoService.delete(rid);

        String message = "삭제되었습니다.";
        return ResponseEntity.ok(message);
    }
}
