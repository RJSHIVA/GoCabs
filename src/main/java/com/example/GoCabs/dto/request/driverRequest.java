package com.example.GoCabs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class driverRequest {
    private String name;
    private String email;
    private Integer age;
}
