package com.iambstha.springldap.resource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestResource {

    @GetMapping("/public")
    public String getPublic() {
        return "Hello from a public user!!!";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello user!!!";
    }

}
