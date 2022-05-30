package me.ryan.black.hoody.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests()
            .mvcMatchers("/info").permitAll()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
        http.formLogin()
        http.httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("ryan").password("{noop}123").roles("USER")
            .and()
            .withUser("admin").password("{noop}123").roles("ADMIN")
    }
}