package equipo7.challenge2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http

            .authorizeHttpRequests(authRequest ->
                    authRequest
                    .requestMatchers().denyAll().antMatchers("/auth/**")
                    .authenticated()
            ).formLogin(withDefaults())
            .build();
}
}
