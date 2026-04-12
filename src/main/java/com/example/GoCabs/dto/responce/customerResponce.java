package com.example.GoCabs.dto.responce;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class customerResponce {
    private String name;

    private String email;

    private Integer age;
}
