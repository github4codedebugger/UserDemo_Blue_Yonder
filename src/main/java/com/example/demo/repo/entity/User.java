package com.example.demo.repo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    private String uId;
    private String name;
    private String address;
}
