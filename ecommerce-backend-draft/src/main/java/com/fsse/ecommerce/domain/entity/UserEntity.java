package com.fsse.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "firebase_uid")
    private String firebaseUid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", firebaseUid='" + firebaseUid + '\'' +
                '}';
    }
}