package com.luxhouse.main.config;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luxhouse.main.domain.Users;
import com.luxhouse.main.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder pe;

	UserService userService;

	// Cung cap data login
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Users user = userService.findByUsername(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream().map(er -> er.getRoles().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found !");
			}
		});

	}
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/order/**").authenticated()
		.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
		.antMatchers("/rest/authorities").hasAnyRole("DIRE")
		.anyRequest().permitAll();
		
		http.formLogin()
		.loginPage("/security/login/form")
		.loginProcessingUrl("/security/login")
		.defaultSuccessUrl("/security/login/success", false)
		.failureUrl("/security/login/error");
		
		http.rememberMe()
		.tokenValiditySeconds(86400);
		
		http.exceptionHandling()
		.accessDeniedPage("/security/unauthoried");
		
		http.logout()
		.logoutUrl("/security/logoff")
		.logoutSuccessUrl("/security/logoff/success");
	}
	
	
	// Ma Hoa password
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Xuat RESTapi tu domain khac
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
}
