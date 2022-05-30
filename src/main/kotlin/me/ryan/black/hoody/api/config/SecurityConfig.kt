package me.ryan.black.hoody.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeHttpRequests()
            .mvcMatchers("/info").permitAll()
            .mvcMatchers(HttpMethod.POST, "/v1/admin").permitAll()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
        http.formLogin()
        http.httpBasic()
    }


}