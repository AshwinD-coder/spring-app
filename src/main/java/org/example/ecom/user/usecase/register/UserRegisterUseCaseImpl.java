package org.example.ecom.user.usecase.register;

import org.example.ecom.platform.security.SecurityUtils;
import org.example.ecom.platform.usecase.UseCase;
import org.example.ecom.user.repository.UserEntity;
import org.example.ecom.user.repository.UserRepository;
import org.example.ecom.user.usecase.adapter.converter.UserEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserRegisterUseCaseImpl implements UseCase<UserRegisterRequest,UserRegisterResponse> {
    private final UserRepository userRepository;

    @Autowired
    public UserRegisterUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserRegisterResponse> execute(UserRegisterRequest request) {
        String username = request.getFirstName().concat(String.valueOf(new Random().nextInt(100000)));
        UserEntity user = UserEntityConverter.convert(request);
        user.setUsername(username);
        user.setPassword(SecurityUtils.hashPassword(user.getPassword(),username));
        this.userRepository.save(user);
        return Optional.of(new UserRegisterResponse(username,"User registered successfully"));
    }
}
