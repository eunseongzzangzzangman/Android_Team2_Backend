package com.example.backend.Repository;

import com.example.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUemail(String uemail);


}