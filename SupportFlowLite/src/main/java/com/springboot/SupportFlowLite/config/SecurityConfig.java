package com.springboot.SupportFlowLite.config;

import com.springboot.SupportFlowLite.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserService userService;
//    @Bean
//    public UserDetailsService users() {
//        UserDetails user1 = User.builder()
//                .username("harry")
//                .password("{noop}harry@123")
//                .authorities("CUSTOMER")
//                .build();
//        UserDetails user2 = User.builder()
//                .username("ronald")
//                .password("{noop}ronald@123")
//                .authorities("EXECUTIVE")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public SecurityFilterChain approvalsSecurityFilterChain(HttpSecurity http) throws Exception {
          http
                  .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/customer/add").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/ticket/add").hasAuthority("CUSTOMER")

                        .requestMatchers(HttpMethod.GET, "/api/ticket/all/for-customer").hasAuthority("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/api/ticket/all/for-executive").hasAuthority("EXECUTIVE")


                        .requestMatchers(HttpMethod.POST, "/api/ticket/assign/{executiveId}/{ticketId}").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
                )

                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
