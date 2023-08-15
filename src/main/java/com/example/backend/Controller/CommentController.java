package com.example.backend.Controller;

import com.example.backend.Entity.Comment;
import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.CommentService;
import com.example.backend.Service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    @Autowired
    FoodInfoService foodInfoService;
    @Autowired
    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @RequestMapping("/comments")
    public ResponseEntity<String> postComment(@RequestBody Comment comment) {

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("getCmt: " + comment.getCmt());
        System.out.println("getUid: " + comment.getUid());
        System.out.println("getId: " + comment.getId());
        System.out.println("getCmtTime: " + comment.getCmtTime());
        System.out.println("getNickname: " + comment.getNickname());
        System.out.println("getRid: " + comment.getRid());
        System.out.println("getStarpoint: " + comment.getStarpoint());
        Long rid = comment.getRid();
        Long rcount = foodInfoService.getonerest(rid).getRcount()+1;
        Long rtotalstar=foodInfoService.getonerest(rid).getRtotalstar()+comment.getStarpoint();
        //몫
        Double rstaravg1 = (double) (rtotalstar/rcount);
        // 소수점 아래 1자리까지 표현
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedResult = decimalFormat.format(rstaravg1);
        System.out.println(formattedResult);
        System.out.println(rcount);
        System.out.println(rtotalstar);

        FoodInfo foodInfo = foodInfoService.getonerest(rid);

        foodInfo.setRcount(rcount);
        foodInfo.setRtotalstar(rtotalstar);
        foodInfo.setRstaravg(Double.parseDouble(formattedResult));
        foodInfoService.save(foodInfo);


        commentService.saveComment(comment);


        return ResponseEntity.ok("ok!");
    }
    @PostMapping("/postReviewMod")
    //인서트
    public void postReviewMod(@RequestBody Comment comment){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!22222222222233333333");
        System.out.println("getCmt: " + comment.getId());
        System.out.println("getCmt: " + comment.getCmt());
        System.out.println("getUid: " + comment.getUid());
        System.out.println("getCmtTime: " + comment.getCmtTime());
        System.out.println("getNickname: " + comment.getNickname());
        System.out.println("getRid: " + comment.getRid());
        System.out.println("getStarpoint: " + comment.getStarpoint());
        commentService.saveComment(comment);
    }
    @PostMapping("/delreview")
    //인서트
    public void delreview(@RequestParam("id") String id){
        Long reviewid =Long.valueOf(id);
        commentService.delete(reviewid);
    }
    @GetMapping("/getReviewOne")
    public Comment getReviewOne(@RequestParam("uid") String uid,@RequestParam("rid") String rid) {
        //전체 리스트
        Long uuid =Long.valueOf(uid);
        Long rrid =Long.valueOf(rid);
        System.out.println("1111111111111@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+uid);
        System.out.println("111111111111@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+rid);
        return commentService.getReviewOne(uuid,rrid);
    }
    @GetMapping("/getReviewList")
    public List<Comment> findAllByUidAndRid(@RequestParam("uid") String uid,@RequestParam("rid") String rid) {
        //전체 리스트
        Long uuid =Long.valueOf(uid);
        Long rrid =Long.valueOf(rid);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+uid);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+rid);
        return commentService.findAllByUidAndRid(uuid,rrid);
    }

}