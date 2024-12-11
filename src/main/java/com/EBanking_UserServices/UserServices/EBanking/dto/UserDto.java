package com.EBanking_UserServices.UserServices.EBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    public String userId;
    private int nic;
    private String fullName;
    private String email;
    private String address;
    private int contactNo;

    public UserDto(String id) {
        this.userId = id;
    }

    public void setUserId(String newId) {
        this.userId=newId;
    }
}
