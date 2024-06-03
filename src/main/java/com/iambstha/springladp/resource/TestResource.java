package com.iambstha.springladp.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping("/any")
    public String getIfAny() {
        return "Hello any authenticated user!!!";
    }

    @GetMapping("/user")
    @RolesAllowed("USER")
    public String getIfUser() {
        return "Hello user!!!";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getIfAdmin() {
        return "Hello admin!!!";
    }

}
