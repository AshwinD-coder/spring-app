package org.example.ecom.user.resource;

import org.example.ecom.platform.restutils.RestResponse;
import org.example.ecom.user.usecase.login.UserLoginRequest;
import org.example.ecom.user.usecase.login.UserLoginUseCaseImpl;
import org.example.ecom.user.usecase.register.UserRegisterRequest;
import org.example.ecom.user.usecase.register.UserRegisterUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserRegisterUseCaseImpl userRegisterUseCase;
    private final UserLoginUseCaseImpl userLoginUseCase;

    @Autowired
    public UserResource(UserRegisterUseCaseImpl userRegisterUseCase, UserLoginUseCaseImpl userLoginUseCase) {
        this.userRegisterUseCase = userRegisterUseCase;
        this.userLoginUseCase = userLoginUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        var response = this.userRegisterUseCase.execute(userRegisterRequest);
        if (response.isPresent()) {
            return ResponseEntity.ok(RestResponse.success(response.get()));
        } else {
            return ResponseEntity.badRequest().body(RestResponse.error("Response not found"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        var response = this.userLoginUseCase.execute(userLoginRequest);
        if (response.isPresent()) {
            return ResponseEntity.ok(RestResponse.success(response.get()));
        } else throw new IllegalArgumentException("Response not found");

    }
}
