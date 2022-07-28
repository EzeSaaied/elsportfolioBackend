package com.argprograma.elsportfolio.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UsuarioDetailsService implements UserDetailsService  {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, String> usuarios = Map.of(
                "ezelopezsaaied", "USER",
                "ezelopezsaaiedADM", "ADMIN"
        );
        var rol = usuarios.get(username);
        if (rol != null) {
            User.UserBuilder userBuilder = User.withUsername(username);
            // "TestPassword123" => [BCrypt] => $2a$12$fz7GYN7jKKtlYlPkMCicF.ODe3CQt2BCq/HynypIpVrSnnfLZoIRm
            String encryptedPassword = "$2a$12$fz7GYN7jKKtlYlPkMCicF.ODe3CQt2BCq/HynypIpVrSnnfLZoIRm";
            userBuilder.password(encryptedPassword).roles(rol);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}

