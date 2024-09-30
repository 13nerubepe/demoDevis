package com.example.demo.entity.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientCreateDto {
    private String nom;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String ville;
    private String grade;
}
