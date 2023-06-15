package com.tutoSpringWS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    // Endpoint level authorization
    /* ---- Matchers: definen criterios sobre el recurso al cual queremos acceder
    *  1. AnyRequest (cualquier peticion)
    *  2. RequestMatchers (cumplir con requisito sobre la url)
    *  3. RequestMatchers with HttpMethod
    */

    /* ---- Authorization rules:
    *  1. PermitAll
    *  2. DenyAll (recurso no disponible sin importar quien lo solicite)
    *             si es un usuario autenticado, dá 403 Forbidden, no autorizado.
    *             si es un usuario invalido, dá 401 Unauthorized.
    *  3. Authenticated (recurso disponible para cualquier usuario autenticado)
    *  4. HasRole (un role seria una combindacion de authorities, ej: user, admin, dba)
    *  5. HasAuthority (admin, read, write)
    *  6. Access (SpEL) - Spring Expression Language
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        return http
                .httpBasic(withDefaults())
                .authorizeHttpRequests(
//                        auth -> auth.anyRequest().hasAnyAuthority("READ")
                auth -> {
                    auth.requestMatchers("/proyecto/admin").hasAuthority("ADMIN");
                    auth.requestMatchers("/proyecto/dba").hasAuthority("WRITE");
                    auth.requestMatchers("/proyecto/saludo/*").hasAuthority("READ");
                })
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(
//                User.withUsername("user")
//                        .password(passwordEncoder().encode("password123"))
//                        .authorities("read")
//                        .build(),
//                User.withUsername("admin")
//                        .password(passwordEncoder().encode("password123"))
//                        .authorities("read", "write")
//                        .build()
//        );
//        return inMemoryUserDetailsManager;
//    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
