package tp.config;

import tp.security.JwtAuthenticationFilter;
import tp.security.MyNoAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//necessary for @PreAuthorize("hasRole('ADMIN or ...')")
public class BasicMemoryWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
	

	@Autowired
    private MyNoAuthenticationEntryPoint unauthorizedHandler;
	

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
	  .withUser("user1").password(passwordEncoder.encode("pwduser1")).roles("USER").and()
	  .withUser("admin1").password(passwordEncoder.encode("pwdadmin1")).roles("ADMIN","USER").and()
	  .withUser("publisher1").password(passwordEncoder.encode("pwdpublisher1")).roles("PUBLISHER","USER").and()
	  .withUser("user2").password(passwordEncoder.encode("pwduser2")).roles("USER").and()
	  .withUser("admin2").password(passwordEncoder.encode("pwdadmin2")).roles("ADMIN").and()
	  .withUser("publisher2").password(passwordEncoder.encode("pwdpublisher2")).roles("PUBLISHER"); 
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
		// Disable CSRF protection since tokens are immune to it
		.csrf().disable()
		// If the user is not authenticated, returns 401
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		// This is a stateless application, disable sessions
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		// Custom filter for authenticating users using tokens
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
		// Disable resource caching
		.headers().cacheControl();
    	
    	http
    	 .authorizeRequests()
    	    .antMatchers("/",
                 "/favicon.ico",
                 "/**/*.png",
                 "/**/*.gif",
                 "/**/*.svg",
                 "/**/*.jpg",
                 "/**/*.html",
                 "/**/*.css",
                 "/**/*.js").permitAll()
	 		   .antMatchers("/rest/login-api/public/auth").permitAll()
	 		   .antMatchers("/rest/api-compte/public/**").permitAll()
	 		   //.anyRequest().permitAll()
	 		   .anyRequest().authenticated()
	 		   //.anyRequest().hasRole("ADMIN")
	 		   .and().cors();
	 			//.and().httpBasic()
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
