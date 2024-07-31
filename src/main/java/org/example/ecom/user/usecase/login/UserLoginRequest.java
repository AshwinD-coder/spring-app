package org.example.ecom.user.usecase.login;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Please enter username.")
    private String username;
    @NotBlank(message = "Please enter password.")
    private String password;
}
