
package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;
    private String userName;
    private String email;

    public UserDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}