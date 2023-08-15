package com.example.backend.Dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String uemail;
    private String upassword;
    private String uname;
    private String unickname;
    private String uimg;
    private String role;


}
