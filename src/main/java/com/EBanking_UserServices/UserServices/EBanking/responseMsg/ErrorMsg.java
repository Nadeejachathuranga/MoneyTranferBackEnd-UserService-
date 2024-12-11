package com.EBanking_UserServices.UserServices.EBanking.responseMsg;

import lombok.Getter;

@Getter
public class ErrorMsg implements ResponseMsg{
 private String errorMsg;

    public ErrorMsg(String errorMsg) {
        this.errorMsg=errorMsg;
    }
}
