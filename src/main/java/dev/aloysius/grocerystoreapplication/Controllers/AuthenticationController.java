package dev.aloysius.grocerystoreapplication.Controllers;

import dev.aloysius.grocerystoreapplication.Domains.ApplicationUsers;
import dev.aloysius.grocerystoreapplication.Domains.AuthenticationRequest;
import dev.aloysius.grocerystoreapplication.Domains.Customers;
import dev.aloysius.grocerystoreapplication.Domains.DTO.UserProfileDTO;
import dev.aloysius.grocerystoreapplication.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Customers applicationUsers){
        return authenticationService.register(applicationUsers);

    }

    @PostMapping("/authenticate")
    public String getToken(@RequestBody AuthenticationRequest request){
        return authenticationService.authenticate(request);
    }

    @GetMapping("/profile")
    public UserProfileDTO myProfile(){
        return authenticationService.myProfile();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
