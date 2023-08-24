package com.appkobo.campusnavi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolDto {
    private Long id;
    private String name;
    private String city;
    private String prefecture;
}
