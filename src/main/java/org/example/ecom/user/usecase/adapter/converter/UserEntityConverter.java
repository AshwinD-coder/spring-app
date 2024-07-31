package org.example.ecom.user.usecase.adapter.converter;

import org.example.ecom.user.repository.UserEntity;
import org.example.ecom.user.usecase.register.UserRegisterRequest;

public class UserEntityConverter {
    public static UserEntity convert(UserRegisterRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setMobileNumber(request.getMobileNumber());
        userEntity.setUserType(request.getUserType());
        return userEntity;
    }
}
