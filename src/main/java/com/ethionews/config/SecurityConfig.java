package com.ethionews.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ethionews.dao.UserDao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		// authenticationMgr.inMemoryAuthentication().withUser("journaldev").password("jd@123").authorities("ROLE_EVENT");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		authenticationMgr.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getAllUserRoles").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/getAllUsers").access("hasRole('ROLE_ADMIN')").antMatchers("/getAllVideos")
				.access("hasRole('ROLE_VIDEO')").antMatchers("/getAllMedias").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/recordCrawel").access("hasRole('ROLE_ADMIN')").antMatchers("/getAllSubscribers")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/getAllContacts").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/getAllEvents").access("hasRole('ROLE_USER')").and().formLogin().loginPage("/userLogin")
				.defaultSuccessUrl("/getAllEvents").failureUrl("/userLogin?error").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/userLogin?logout").and()
				.exceptionHandling().accessDeniedPage("/accessDenied").and().sessionManagement().maximumSessions(1)
				.expiredUrl("/sessionExpired");

	}
}