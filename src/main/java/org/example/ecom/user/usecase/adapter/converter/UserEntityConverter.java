package org.example.ecom.user.usecase.adapter.converter;

import lombok.NoArgsConstructor;
import org.example.ecom.platform.security.SecurityUtils;
import org.example.ecom.user.repository.UserEntity;
import org.example.ecom.user.usecase.register.UserRegisterRequest;

import java.util.UUID;

@NoArgsConstructor
public class UserEntityConverter {
    public static UserEntity convert(UserRegisterRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setMobileNumber(request.getMobileNumber());
        userEntity.setUserType(request.getUserType());
        return userEntity;
    }
}
