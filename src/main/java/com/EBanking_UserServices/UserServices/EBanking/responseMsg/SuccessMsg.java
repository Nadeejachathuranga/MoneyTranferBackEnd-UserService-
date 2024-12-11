package com.EBanking_UserServices.UserServices.EBanking.responseMsg;

import com.EBanking_UserServices.UserServices.EBanking.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class SuccessMsg implements ResponseMsg {
    private String msg;
    public UserDto userdto;

    public SuccessMsg(String msg, UserDto userDto) {
        this.msg=msg;
        this.userdto=userDto;
    }
}
