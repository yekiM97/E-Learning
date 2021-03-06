package com.myclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myclass.filter.AuthFilter;
import com.myclass.service.impl.LoginServiceImpl;

@Configuration
@EnableWebSecurity
@Order(value = 1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(loginServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
				"/configuration/security", "/swagger-ui.html", "/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors();

		http.csrf().disable().antMatcher("/api/admin/**").authorizeRequests()
				.antMatchers("/api/admin/login", "/api/admin/register").permitAll().antMatchers("/api/admin/**")
				.hasAnyRole("ADMIN").anyRequest().authenticated();

		http.addFilter(new AuthFilter(authenticationManager(), loginServiceImpl));

		// h??? th???ng s??? d???ng session th?? kh??ng c???n
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
}
