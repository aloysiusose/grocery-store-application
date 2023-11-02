package dev.aloysius.grocerystoreapplication.Controllers;

import dev.aloysius.grocerystoreapplication.Domains.ApplicationUsers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AuthenticationController {

    @PostMapping("/register")
    public void registerUser(@RequestBody ApplicationUsers applicationUsers){

    }

    @PostMapping("/authenticate")
    public String getToken(){
        return null;
    }
}
