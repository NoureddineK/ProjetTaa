package myApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("master")).roles("ADMIN",
				"USER");
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin();
		http.csrf().disable().httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/person").permitAll()
				.antMatchers(HttpMethod.GET, "/place").permitAll().antMatchers(HttpMethod.POST, "/sport").permitAll()
				.antMatchers(HttpMethod.GET, "/person").permitAll().antMatchers(HttpMethod.POST, "/place").permitAll()
				.antMatchers(HttpMethod.GET, "/weather").permitAll().antMatchers(HttpMethod.POST, "/weather").permitAll()
				.antMatchers(HttpMethod.GET, "/sport").permitAll().antMatchers(HttpMethod.POST, "/admin/*")
				.authenticated().and();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
