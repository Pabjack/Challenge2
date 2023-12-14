package equipo7.challenge2.Security;

import equipo7.challenge2.Security.JWT.JWTUtils;
import equipo7.challenge2.Security.filters.JwtAuthenticationFilter;
import equipo7.challenge2.services.UserDetaillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class SecurityConfig {
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    UserDetaillServiceImpl userDetaillService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        return httpSecurity
                .csrf().disable() // Deshabilita la protección CSRF
                .authorizeHttpRequests(auth -> {
                    auth.antMatchers("/hello", "/productos/all", "/productos/add", "/swagger-ui/**",
                            "/v2/api-docs", "/v3/api-docs",
                            "/webjars/**",
                            "/swagger-resources/**", "/configuration/ui",
                            "/configuration/security", "/crearUsuario").permitAll();
                    auth.antMatchers("/admin", "/usuarios/all").hasRole("ADMINISTRADOR");
                    auth.antMatchers("/proveedor/products").hasRole("PROVEEDOR");
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetaillService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }
}