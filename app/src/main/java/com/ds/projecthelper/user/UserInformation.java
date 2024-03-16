package com.ds.projecthelper.user;

import android.os.Build;
import android.util.Base64;

import java.time.LocalDateTime;

public class UserInformation {
    private String userName;
    private byte[] password;

    public UserInformation(String userName, byte[] password) {
        this.userName = userName;
        this.password = password;
    }

    public void setData(String userName, String password){
        this.userName = userName;
        this.password = Base64.decode(password, Base64.CRLF);
    }

    public String getUserName() {
        return userName;
    }

    public byte[] getPassword() {
        return password;
    }
}
