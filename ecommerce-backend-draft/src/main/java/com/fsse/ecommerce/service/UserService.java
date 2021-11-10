package com.fsse.ecommerce.service;

import com.fsse.ecommerce.domain.User;
import com.fsse.ecommerce.domain.entity.UserEntity;
import com.google.firebase.auth.FirebaseToken;

public interface UserService {
    User getUserByFirebaseUid(String firebaseUid);
    User createUser(FirebaseToken firebaseToken);
    UserEntity getUserEntityByUid(long uid);
}
