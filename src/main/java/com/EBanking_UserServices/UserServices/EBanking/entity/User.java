package com.EBanking_UserServices.UserServices.EBanking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
//@ToString
public class User {

    @Id
    private String userId;
    private int nic;
    private String fullName;
    private String email;
    private String address;
    private int contactNo;


    public User(String id) {
        this.userId=id;
    }

    public String getuserId() {
       return userId;
    }

    public String getFullName(){
        return fullName;
    }
    public int getContactNo(){
        return contactNo;
    }
 /*   public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", nic=" + nic +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                ", contactNo=" + "testing to string" +
                '}';
    }*/
}
