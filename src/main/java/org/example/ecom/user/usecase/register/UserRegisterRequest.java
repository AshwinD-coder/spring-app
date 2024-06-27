package org.example.ecom.user.usecase.register;

import lombok.Getter;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseRequest;
import org.example.ecom.user.repository.UserType;

@Getter
@Setter
public class UserRegisterRequest implements UseCaseRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String mobileNumber;
    private UserType userType;
}
