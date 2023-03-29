package com.VeterinariaXYZ.VeterinariaXYZ;

import com.VeterinariaXYZ.VeterinariaXYZ.security.filter.AwsCognitoJwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AwsCognitoJwtAuthFilter awsCognitoJwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl().and()
                .contentSecurityPolicy("default-src 'self'; script-src 'self'; object-src 'self'; frame-ancestors 'self'; form-action 'self';")
                .and()
                .frameOptions()
                .deny();
        http.csrf().disable().authorizeRequests().antMatchers("**/health").permitAll().and().authorizeRequests()
                .and().authorizeRequests().antMatchers("/api/**")
                //.authenticated()
                .permitAll().anyRequest().permitAll();
      //  http.addFilterBefore(awsCognitoJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().ignoringAntMatchers("**/health").disable();

    }
}