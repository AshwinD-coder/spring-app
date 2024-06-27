package org.example.ecom;

import org.example.ecom.platform.restutils.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping()
public class PingResource {
    @GetMapping("/ping")
    public RestResponse<String> ping() {
        RestResponse<String> pingResponse = new RestResponse<>();
        pingResponse.setCode("0");
        pingResponse.setMessage("System is up and running ...");
        return pingResponse;
    }
}
