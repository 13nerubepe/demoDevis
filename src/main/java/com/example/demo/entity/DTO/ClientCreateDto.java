package com.example.demo.entity.DTO;

import com.example.demo.entity.Client;
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

    public static Client toEntity(ClientCreateDto clientCreateDto) {
        return Client.builder()
                .ville(clientCreateDto.getVille())
                .email(clientCreateDto.getEmail())
                .build();
    }

    public static ClientCreateDto toDto(Client client) {
        return ClientCreateDto.builder()
                .ville(client.getVille())
                .email(client.getEmail())
                .build();
    }
}
