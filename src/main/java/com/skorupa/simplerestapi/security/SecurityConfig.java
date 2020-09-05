package com.skorupa.simplerestapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


import javax.annotation.Resource;

import static com.skorupa.simplerestapi.security.PasswordConfig.passwordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;



    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/createuser","/verify-user**","/verify-user?code=**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**", "/swagger-ui");

//        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").authenticated().and().httpBasic().and().cors().disable();
        http.csrf().disable().
                authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
                .and().httpBasic();
//        http.authorizeRequests().antMatchers("/swagger-ui").permitAll();
//        http.csrf().disable()
//                .authorizeRequests().anyRequest().authenticated().and().authenticationProvider(authenticationProvider());
//                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").authenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider());

//        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("aaa")).roles("ADMIN");
    }
}
