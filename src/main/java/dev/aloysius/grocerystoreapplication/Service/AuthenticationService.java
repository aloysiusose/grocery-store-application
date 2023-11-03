package dev.aloysius.grocerystoreapplication.Service;

import dev.aloysius.grocerystoreapplication.Domains.ApplicationUsers;
import dev.aloysius.grocerystoreapplication.Domains.AuthenticationRequest;
import dev.aloysius.grocerystoreapplication.Domains.Customers;
import dev.aloysius.grocerystoreapplication.Repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationProvider authProvider;
    private final JwtEncoder jwtEncoder;
    private final CustomersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(Customers applicationUsers) {
        if (isPresent(applicationUsers)) {
            return "user already exists";
        }
        applicationUsers.setPassword(passwordEncoder.encode(applicationUsers.getPassword()));
        usersRepository.save(applicationUsers);
        return "Account created";
    }

    private boolean isPresent(Customers applicationUsers) {
        return usersRepository.findByUsername(applicationUsers.getUsername()).isPresent();
    }

    public String authenticate(AuthenticationRequest request) {
        Authentication authenticate = authProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.
                setAuthentication(authenticate);

        return generateToken(authenticate);

    }

    private String generateToken(Authentication authentication){
        String scope = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        Instant now = Instant.now();;

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .subject(authentication.getName())
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .claim("scope", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }



}
