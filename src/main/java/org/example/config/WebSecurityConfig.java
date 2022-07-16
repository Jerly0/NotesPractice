package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withDefaultPasswordEncoder().username("jerl.y").password("1234").roles("user").build());
            return manager;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

            http
                    .csrf().disable()
                    .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                    .formLogin(Customizer.withDefaults());

            return http.build();
        }

    }


