package org.example.ecom.platform.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AppExceptionType {
    USER_NOT_FOUND("001", "User not found!"),
    USER_ALREADY_EXIST("002", "User already exist!"),
    DUPLICATE_USERNAME("003", "Username already exist!"),
    RESPONSE_NOT_FOUND("004", "Response not found!"),
    DUPLICATE_EMAIL("005", "Email already exist!"),
    INVALID_CREDENTIALS("006", "Invalid credentials!"),
    ;
    private String code;
    private String message;


}
