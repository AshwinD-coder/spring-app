package org.example.ecom.user.usecase.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseResponse;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterResponse implements UseCaseResponse {
    private String username;
    private String message;
}
