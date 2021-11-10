package com.fsse.ecommerce.service.impl;

import com.fsse.ecommerce.domain.User;
import com.fsse.ecommerce.domain.entity.UserEntity;
import com.fsse.ecommerce.repository.UserRepository;
import com.fsse.ecommerce.service.UserService;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByFirebaseUid(String firebaseUid) {
        UserEntity entity = userRepository.findFirstByFirebaseUid(firebaseUid);
        if (entity != null) {
            return new User(entity);
        }
        return null;
    }

    @Override
    public User createUser(FirebaseToken firebaseToken) {
        UserEntity entity = new UserEntity();
        entity.setName(firebaseToken.getName());
        entity.setEmail(firebaseToken.getEmail());
        entity.setFirebaseUid(firebaseToken.getUid());

        entity = userRepository.save(entity);
        return new User(entity);
    }

    @Override
    public UserEntity getUserEntityByUid(long uid) {
        Optional<UserEntity> entityOpt = userRepository.findById(uid);
        if (entityOpt.isPresent()) {
            return entityOpt.get();
        }
        return null;
    }
}
