package org.example.ecom.user.usecase.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest implements UseCaseRequest {
    private String username;
    private String password;
}
