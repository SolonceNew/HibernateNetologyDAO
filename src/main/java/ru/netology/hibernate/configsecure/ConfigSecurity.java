package ru.netology.hibernate.configsecure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan")
                .password("{noop}ivan")
                .roles("user")
                .and()
                .withUser("Olga")
                .password("{noop}olga")
                .roles("admin");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests().antMatchers("/by-name-and-surname").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();

    }
}
