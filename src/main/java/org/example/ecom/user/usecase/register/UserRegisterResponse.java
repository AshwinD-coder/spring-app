package org.example.ecom.user.usecase.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.ecom.platform.usecase.UseCaseResponse;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterResponse implements UseCaseResponse {
    private String username;
    private String message;
}
