package com.skorupa.simplerestapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.skorupa.simplerestapi.security.PasswordConfig.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/swagger-ui").permitAll();
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll().anyRequest()
                .authenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("aaa")).roles("ADMIN");
    }
}
