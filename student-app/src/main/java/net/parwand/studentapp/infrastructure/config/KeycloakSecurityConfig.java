package net.parwand.studentapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@EnableWebSecurity
@Configuration
public class KeycloakSecurityConfig {

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/student")
                .hasAnyRole("USER", "ROLE_user", "user")
                .requestMatchers("/manage-student")
                .hasAnyAuthority("SCOPE_profile")
                .anyRequest()
                .permitAll();
        http.oauth2Login()
                .and()
                .logout()
                .logoutSuccessUrl("/login");
        http.csrf().disable().cors().disable();
        return http.build();
    }
}