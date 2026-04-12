package com.example.GoCabs.dto.request;

import com.example.GoCabs.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class customerRequest {
    private String name;

    private String email;

    private Integer age;

    private Gender gender;
}
