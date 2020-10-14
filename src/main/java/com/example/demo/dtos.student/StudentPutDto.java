package com.example.demo.dtos.student;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentPutDto {
    private UUID id;
    private String firstName;
    private String password;
}
