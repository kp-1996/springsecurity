//package com.jwtautho.springsecurity.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Value(value = "${auth0.apiAudience}")
//    private String apiAudience;
//    @Value(value = "${auth0.issuer}")
//    private String issuer;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtWebSecurityConfigurer
//                .forRS256(apiAudience, issuer)a
//                .configure(http)
//                .cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,
//                        "/",
//                        "/v2/api-docs",           // swagger
//                        "/webjars/**",            // swagger-ui webjars
//                        "/swagger-resources/**",  // swagger-ui resources
//                        "/configuration/**",      // swagger configuration
//                        "/*.html",
//                        "/favicon.ico",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js")
//                .permitAll().anyRequest().authenticated();
//    }
//}