package com.ds.projecthelper.user;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ds.projecthelper.ShowAlerts;
import com.ds.projecthelper.util.IOnAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class UserController {
    private final FirebaseAuth firebaseAuth;
    private static UserController instance = null;

    private UserController() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static synchronized UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }

        return instance;
    }

    public static boolean isSignedIn(){
        return getInstance().getFirebaseAuth().getCurrentUser() != null;
    }

    public static void createUser(String email, String password, IOnAction onSuccessfulAction, Context context){
        getInstance().getFirebaseAuth().createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()) onSuccessfulAction.onAction(); else ShowAlerts.showDialog(context, Objects.requireNonNull(task.getException()), true);
        });
    }

    public static void logOut(){
        getInstance().getFirebaseAuth().signOut();
    }

    @NonNull
    public static UserInformation getUserInformation(){
        FirebaseUser firebaseUser = getInstance().getFirebaseAuth().getCurrentUser();

        assert firebaseUser != null;
        return new UserInformation(firebaseUser.getEmail(), Objects.requireNonNull(firebaseUser.getUid()).getBytes());
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }
}
