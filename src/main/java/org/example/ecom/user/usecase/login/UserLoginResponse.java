package org.example.ecom.user.usecase.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse implements UseCaseResponse {
    private String username;
    private String message;
}
