package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "foodinfo")
public class FoodInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String rtitle;
    private String rcity;
    private Double rlat;
    private Double rlng;
    private String rtel;
    private String rmainimg;
    private String rinfo;
    private Long rtotalstar;
    private Double rstaravg;
    private Long rcount;
    private Long cid;
}
