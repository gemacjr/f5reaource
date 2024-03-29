package com.swift.f5resource;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        // How can I use the entitlements array for authorization?
        // The output is -> Your entitlements: [ "TLC.Boss", "TLC.User", "Day.User" ]
        
        return String.format("Your entitlements: %s", jwt.getClaims().get("entitlements"));
    }

    @GetMapping("/message")
    public String message(){
        return "secret message";
    }

    @PostMapping("/message")
    public String createMessage(@RequestBody String message){
        return String.format("message was created. Content: %s", message);
    }
}

