package org.example.ecom.user.usecase.register;

import org.example.ecom.platform.exception.AppException;
import org.example.ecom.platform.exception.AppExceptionType;
import org.example.ecom.platform.security.SecurityUtils;
import org.example.ecom.platform.usecase.UseCase;
import org.example.ecom.user.repository.UserEntity;
import org.example.ecom.user.repository.UserRepository;
import org.example.ecom.user.usecase.adapter.converter.UserEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegisterUseCaseImpl implements UseCase<UserRegisterRequest, UserRegisterResponse> {
    private final UserRepository userRepository;

    @Autowired
    public UserRegisterUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserRegisterResponse> execute(UserRegisterRequest request) {
        UserEntity user = UserEntityConverter.convert(request);
        this.validateUser(user);
        user.setPassword(SecurityUtils.hashPassword(user.getPassword(), user.getUsername()));
        this.userRepository.save(user);
        return Optional.of(new UserRegisterResponse(user.getUsername(), "User registered successfully"));
    }

    private void validateUser(UserEntity user) {
        this.userRepository.findByUsername(user.getUsername()).ifPresent(userByUsername -> {
            throw new AppException(AppExceptionType.DUPLICATE_USERNAME);
        });
    }
}
