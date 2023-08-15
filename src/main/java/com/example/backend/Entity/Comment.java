package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cmt")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cmt;

    private String cmtTime;

    private String reviewimg;

    private String nickname;

    private Long starpoint;

    private Long uid;

    private Long rid;

}
