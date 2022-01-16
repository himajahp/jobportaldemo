//package com.example.jobportal.security;
//
//import com.example.jobportal.service.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
//        authprovider.setUserDetailsService(userDetailsService());
//        authprovider.setPasswordEncoder(passwordEncoder());
//        return authprovider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
//                .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR").antMatchers("/edit/**")
//                .hasAnyAuthority("ADMIN", "EDITOR").antMatchers("/delete/**").hasAuthority("ADMIN")
//                .antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().formLogin().permitAll()
//                .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403");
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
//}
