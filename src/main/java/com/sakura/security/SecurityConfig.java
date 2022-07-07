package com.sakura.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig
{
    // @Bean
    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public WebSecurityCustomizer customizer()
    {
        return web ->
                web.ignoring()
                   .antMatchers("/images/**", "/css/**", "/js/**", "/fonts/**", "/favicon.*");
    }
    
    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")
            .failureUrl("/login.html?error")
            .defaultSuccessUrl("/success.html");
        http.logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login.html?logout");
        http.exceptionHandling().accessDeniedPage("/403.html");
        return http.build();
    }
}
