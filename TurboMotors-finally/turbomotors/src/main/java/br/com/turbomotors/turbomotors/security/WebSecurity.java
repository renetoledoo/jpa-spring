package br.com.turbomotors.turbomotors.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementarUserDetailsService acao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/TurboStyle/***").permitAll()
                .antMatchers("/TurboStyle/img/**").permitAll()
                .antMatchers("/web/painel").authenticated()
                .anyRequest().permitAll()
            .and()
            .formLogin().permitAll()
                .loginPage("/login")
                .defaultSuccessUrl("/web/painel")
                .failureUrl("/login-incorreto")
            .and()
            .logout()
                .logoutSuccessUrl("/login")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // System.out.println("ACAO >  =  " + acao);
        auth.userDetailsService(acao)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

}
