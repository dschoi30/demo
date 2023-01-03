package com.example.demo.config;

import com.example.demo.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired UserService userService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().requestMatchers("/api/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/users/login")
                .defaultSuccessUrl("/")
                .usernameParameter("name")
                .failureUrl("/users/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                .logoutSuccessUrl("/")
        ;

        http.authorizeHttpRequests()
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers("/", "/users/**", "/item/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new BasicAuthenticationEntryPoint())
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
