package com.appkobo.campusnavi.dto;

import com.appkobo.campusnavi.model.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String token;
    private String username;
    private String email;
    private School school;
}
