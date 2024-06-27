package org.example.ecom.user.usecase.login;

import org.example.ecom.platform.security.SecurityUtils;
import org.example.ecom.platform.usecase.UseCase;
import org.example.ecom.user.repository.UserEntity;
import org.example.ecom.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginUseCaseImpl implements UseCase<UserLoginRequest,UserLoginResponse> {
    private final UserRepository userRepository;

    @Autowired
    public UserLoginUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserLoginResponse> execute(UserLoginRequest request) {
        Optional<UserEntity> userByUsername = this.userRepository.findByUsername(request.getUsername());
        if(userByUsername.isPresent()) {
            String userId = userByUsername.get().getId().toString();
            boolean passwordValid = SecurityUtils.isPasswordValid(request.getPassword(), request.getUsername(), userByUsername.get().getPassword());
            if(passwordValid) {
                return Optional.of(new UserLoginResponse(request.getUsername(), "Logged in successfully"));
            }
            else
                throw new IllegalArgumentException("Invalid credentials");
        }
        else
            throw new IllegalArgumentException("Invalid credentials");
    }
}
