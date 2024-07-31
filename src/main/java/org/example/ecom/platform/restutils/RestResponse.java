package org.example.ecom.platform.restutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {
    private String code;
    private String message;
    private List<String> errors;
    private T data;

    /**
     * @param data Object
     * @param <T>  Class
     * @return RestResponse of Success with Object data
     */
    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>("0", "SUCCESS", Collections.EMPTY_LIST, data);
    }

    public static <T> RestResponse<T> error(String code, String message) {
        return new RestResponse<>(code, message, Collections.EMPTY_LIST, null);
    }

    public static <T> RestResponse<T> error(String message) {
        return new RestResponse<>("400", message, Collections.EMPTY_LIST, null);
    }

    /**
     * @param errorMessage Error message to be sent in response , List of Errors
     * @param <T>          Class
     * @return RestResponse of Error with error message
     */
    public static <T> RestResponse<T> error(String errorMessage, List<String> errors) {
        return new RestResponse<>("400", errorMessage, errors, null);
    }
}
