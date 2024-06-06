package com.iambstha.springldap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/public").permitAll()
                        .anyRequest().fullyAuthenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userSearchFilter("(uid={0})")
                .userSearchBase("dc=example,dc=com")
                .groupSearchFilter("uniqueMember={0}")
                .groupSearchBase("ou=mathematicians,dc=example,dc=com")
                .userDnPatterns("uid={0}")
                .contextSource()
                .url("ldap://ldap.forumsys.com:389")
                .managerDn("cn=read-only-admin,dc=example,dc=com")
                .managerPassword("password");
    }

}

