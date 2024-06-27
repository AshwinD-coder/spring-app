package org.example.ecom.platform.restutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse <T>{
    private String code;
    private String message;
    private T data ;

    /**
     * @param data Object
     *
     * @param <T> Class
     * @return RestResponse of Success with Object data
     */
    public static <T> RestResponse<T> success(T data){
        return new RestResponse<>("0","SUCCESS",data);
    }

    /**
     * @param errorMessage Error message to be sent in response
     *
     * @param <T> Class
     * @return RestResponse of Error with error message
     */
    public static <T> RestResponse<T> error(String errorMessage){
        return new RestResponse<>("400",errorMessage,null);
    }
}
