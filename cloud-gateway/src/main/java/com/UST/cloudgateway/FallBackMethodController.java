package com.UST.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FallBackMethodController {
    @GetMapping("/userServiceFallBackMethod")
    public String userServiceFallBackMethod(){
        return "Out of service";
    }
    @GetMapping("/departmentServiceFallBackMethod")
    public String departmentServiceFallBackMethod(){
        return "Out of service";
    }

}
