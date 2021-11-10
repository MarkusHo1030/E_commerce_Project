package com.fsse.ecommerce.domain;

import com.fsse.ecommerce.domain.entity.UserEntity;

public class User {
    private Long uid;
    private String name;
    private String email;
    private String firebaseUid;

    public User(UserEntity entity) {
        this.uid = entity.getUid();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.firebaseUid = entity.getFirebaseUid();
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
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", firebaseUid='" + firebaseUid + '\'' +
                '}';
    }
}
