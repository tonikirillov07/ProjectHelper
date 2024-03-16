package com.ds.projecthelper.util;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ds.projecthelper.Constants;

import java.util.Base64;
import java.util.Random;

public abstract class Util extends Constants {
    @Nullable
    public static byte[] createRandomPassword(){
        String characters = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklmnbvcxz=-/()|";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < DEFAULT_PASSWORD_LENGTH; i++) {
            stringBuilder.append(characters.toCharArray()[new Random().nextInt(characters.length())]);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encode(stringBuilder.toString().getBytes());
        }

        return null;
    }
}
