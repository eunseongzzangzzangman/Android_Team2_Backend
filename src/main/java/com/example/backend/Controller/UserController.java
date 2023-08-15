package com.example.backend.Controller;


import com.example.backend.Dto.User;
import com.example.backend.Response.ApiResponse;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/check")
    public ResponseEntity<String> check( @RequestBody User user) {


        String uemail = user.getUemail();

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("uemail: " + uemail);

        User existingUser = userService.getUserByUemail(uemail);

        System.out.println(existingUser);

        if (existingUser == null) {
            // 그런 이메일 없음
            return ResponseEntity.ok("ok!");
        } else {
            // 중복 이메일 있음
            return ResponseEntity.ok("no");
        }

    }


    @RequestMapping("/signup")
    public ResponseEntity<String> signUp( @RequestBody User user) {



        String uemail = user.getUemail();
        String upassword = user.getUpassword();
        String uname = user.getUname();
        String unickname = user.getUnickname();
        String uimg = user.getUimg();
        String role = user.getRole();


        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);
        System.out.println("uname: " + uname);
        System.out.println("unickname: " + unickname);
        System.out.println("uimg: " + uimg);
        System.out.println("role: " + role);



            User newUser = new User();
            newUser.setUemail(uemail);
            newUser.setUpassword(upassword);
            newUser.setUname(uname);
            newUser.setUnickname(unickname);
            newUser.setUimg(uimg);
            newUser.setRole(role);


            userService.saveUser(newUser);

            return ResponseEntity.ok("ok!");

    }


    @RequestMapping("/login")
    public ResponseEntity<ApiResponse<User>> login(@RequestBody User user) {

        ApiResponse<User> response = new ApiResponse<>();

        String uemail = user.getUemail();
        String upassword = user.getUpassword();

        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);

        User existingUser = userService.getUserByUemail(uemail);


        if (existingUser == null) {
            System.out.println("그런 이메일 없다");
            response.setSuccess(false);
            response.setData(null);
            response.setError("No such email");
            return ResponseEntity.ok(response);
        }

        else if (existingUser !=null && !existingUser.getUpassword().equals(upassword)) {
            System.out.println("이메일은 맞는데 비밀번호가 틀렸다.");
            response.setSuccess(false);
            response.setData(null);
            response.setError("Incorrect password");
            return ResponseEntity.ok(response);
        }

        System.out.println("이메일과 비밀번호 일치!! 아래에 유저정보 출력");
        System.out.println(existingUser);

        response.setSuccess(true);
        response.setData(existingUser);
        return ResponseEntity.ok(response);
    }




    @RequestMapping("/modify")
    public ResponseEntity<String> modify( @RequestBody User user) {



        String uemail = user.getUemail();
        String upassword = user.getUpassword();
        String uname = user.getUname();
        String unickname = user.getUnickname();
        String uimg = user.getUimg();

        User existingUser = userService.getUserByUemail(uemail);


        System.out.println("Received data:");
        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);
        System.out.println("uname: " + uname);
        System.out.println("unickname: " + unickname);
        System.out.println("uimg: " + uimg);


        if (existingUser != null) {
            // 업데이트할 값들로 사용자 데이터 갱신
            existingUser.setUpassword(upassword);
            existingUser.setUname(uname);
            existingUser.setUnickname(unickname);
            existingUser.setUimg(uimg);

            // 데이터베이스에 업데이트
            userService.saveUser(existingUser);

            // 성공적으로 업데이트가 완료되었음을 응답
            return ResponseEntity.ok("ok!");
        } else {
            // 해당 이메일에 해당하는 사용자가 없는 경우 에러 응답
            return ResponseEntity.badRequest().body("User not found.");
        }

    }


    @RequestMapping("/delete")
    public ResponseEntity<String> delete( @RequestBody User user) {



        String uemail = user.getUemail();
        String upassword = user.getUpassword();
        String uname = user.getUname();
        String unickname = user.getUnickname();
        String uimg = user.getUimg();

        // UserService를 통해 UserRepository에서 해당 이메일로 사용자를 찾음
        User existingUser = userService.getUserByUemail(uemail);

        System.out.println("Received data:");
        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);
        System.out.println("uname: " + uname);
        System.out.println("unickname: " + unickname);
        System.out.println("uimg: " + uimg);

        if (existingUser != null) {
            // 데이터베이스에서 사용자 데이터 삭제
            userService.deleteUser(existingUser);

            // 성공적으로 삭제가 완료되었음을 응답
            return ResponseEntity.ok("ok!");
        } else {
            // 해당 이메일에 해당하는 사용자가 없는 경우 에러 응답
            return ResponseEntity.badRequest().body("User not found.");
        }
    }




}