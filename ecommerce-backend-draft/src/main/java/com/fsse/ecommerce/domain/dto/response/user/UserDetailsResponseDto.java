package com.fsse.ecommerce.domain.dto.response.user;

import com.fsse.ecommerce.domain.User;
import com.google.firebase.auth.FirebaseToken;

public class UserDetailsResponseDto {
    private Long uid;
    private String name;
    private String email;
    private String firebaseUid;

    public UserDetailsResponseDto(User user) {
        this.uid = user.getUid();
        this.name = user.getName();
        this.email = user.getEmail();
        this.firebaseUid = user.getFirebaseUid();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    @Override
    public String toString() {
        return "UserDetailsResponseDto{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", firebaseUid='" + firebaseUid + '\'' +
                '}';
    }
}