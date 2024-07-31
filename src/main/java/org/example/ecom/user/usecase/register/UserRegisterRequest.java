package org.example.ecom.user.usecase.register;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseRequest;
import org.example.ecom.user.repository.UserType;


@Getter
@Setter
public class UserRegisterRequest implements UseCaseRequest {
    @NotBlank(message = "Username cannot be null, blank or empty")
    private String username;
    @NotBlank(message = "First Name cannot be null, blank or empty")
    private String firstName;
    @NotBlank(message = "Last Name cannot be null, blank or empty")
    private String lastName;
    @NotBlank(message = "Email cannot be null, blank or empty")
    private String email;
    private String password;
    private String confirmPassword;
    private String mobileNumber;
    private UserType userType;
}
