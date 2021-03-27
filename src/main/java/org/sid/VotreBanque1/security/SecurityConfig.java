package org.sid.VotreBanque1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("{noop}1234").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("user2").password("{noop}1234").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("admin1").password("{noop}1234").roles("USER","ADMIN");
    }
        
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
       // http.httpBasic();
        http.authorizeRequests().antMatchers("/operation", "/consulterCompte").hasRole("USER");
       http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
//       http.authorizeRequests().anyRequest().authenticated();
    }   
}
