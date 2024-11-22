package com.example.spring_security_sample.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig() {

    @Bean
    fun defaultSecurityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests {
            it.requestMatchers("/public").permitAll()
                .requestMatchers("/private").hasAnyRole("ADMIN")
                .requestMatchers("/me").authenticated()
        }
        return httpSecurity.build()
    }
}