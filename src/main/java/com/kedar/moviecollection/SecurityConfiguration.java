package com.kedar.moviecollection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/","/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/login", "/register","/home").permitAll()
            .antMatchers("/movies/list").hasRole("USER")
            .antMatchers("/movies/edit/**", "/movies/cast", "/movies/new/**", "/movies/update/**", "/movies/delete/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/movies/list", true)
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
}
