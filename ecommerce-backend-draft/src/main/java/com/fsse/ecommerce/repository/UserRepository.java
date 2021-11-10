package com.fsse.ecommerce.repository;

import com.fsse.ecommerce.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findFirstByFirebaseUid(String firebaseUid);
}
