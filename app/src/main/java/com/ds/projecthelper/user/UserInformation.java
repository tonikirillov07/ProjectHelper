package com.ds.projecthelper.user;

import android.os.Build;
import android.util.Base64;

import java.time.LocalDateTime;

public class UserInformation {
    private String userName;
    private byte[] password;
    private String dateOfRegistration;

    public void setData(String userName, String password){
        this.userName = userName;
        this.password = Base64.decode(password, Base64.CRLF);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.dateOfRegistration = LocalDateTime.now().toString();
        }
    }

    public String getUserName() {
        return userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }
}
