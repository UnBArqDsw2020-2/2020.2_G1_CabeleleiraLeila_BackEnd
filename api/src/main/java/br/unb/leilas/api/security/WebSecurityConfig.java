package br.unb.leilas.api.security;

import br.unb.leilas.api.services.JwtUserDetailsService;
// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//   @Autowired
//   private JwtTokenProvider jwtTokenProvider;

//   @Override
//   protected void configure(HttpSecurity http) throws Exception {

//     // Disable CSRF (cross site request forgery)
//     http.csrf().disable();

//     // No session will be created or used by spring security
//     http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//     // Entry points
//     http.authorizeRequests()//
//         .antMatchers("/users/signin").permitAll()//
//         .antMatchers("/users/signup").permitAll()//
//         .antMatchers("/h2-console/**/**").permitAll()
//         .antMatchers("/swagger-ui/**").permitAll()
//         // .antMatchers("/v2/api-docs/").permitAll()

//         // Disallow everything else..
//         .anyRequest().authenticated().and().

//         exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()

//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//     // If a user try to access a resource without having enough permissions
//     http.exceptionHandling().accessDeniedPage("/login");

//     // Apply JWT
//     http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

//     // Optional, if you want to test the API from a browser
//     // http.httpBasic();
//   }

//   @Override
//   public void configure(WebSecurity web) throws Exception {
//     // Allow swagger to be accessed without authentication
//     web.ignoring().antMatchers("/v2/api-docs")//
//         .antMatchers("/swagger-resources/**")//
//         .antMatchers("/swagger-ui.html")//
//         .antMatchers("/swagger-ui/index.html")
//         .antMatchers("/configuration/**")//
//         .antMatchers("/webjars/**")//
//         .antMatchers("/public")

//         // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
//         .and()
//         .ignoring()
//         .antMatchers("/h2-console/**/**");;
//   }

//   @Bean
//   public PasswordEncoder passwordEncoder() {
//     return new BCryptPasswordEncoder(12);
//   }

//   @Override
//   @Bean
//   public AuthenticationManager authenticationManagerBean() throws Exception {
//     return super.authenticationManagerBean();
//   }

// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import br.unb.leilas.api.services.JwtUserDetailsService;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Autowired
  private JwtUserDetailsService jwtUserDetailsService;

  @Autowired
  private JwtRequestFilter jwtRequestFilter;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
    throws Exception {
    auth
      .userDetailsService(jwtUserDetailsService)
      .passwordEncoder(passwordEncoder());
  }

  @Bean
  public JwtAuthenticationEntryPoint jwtAuthenticationEntryPointBean()
    throws Exception {
    return new JwtAuthenticationEntryPoint();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .cors()
      .and()
      .csrf()
      .disable()
      .authorizeRequests()
      .antMatchers("/authenticate", "/user")
      .permitAll()
      .antMatchers("/users/signin")
      .permitAll() //
      .antMatchers("/users/signup")
      .permitAll() //
      .antMatchers("/pessoa/**")
      .permitAll() //
      .antMatchers(HttpMethod.GET, "/servicos")
      .permitAll() //
      .antMatchers("/h2-console/**/**")
      .permitAll()
      .antMatchers("/swagger-ui/**")
      .permitAll()
      .antMatchers("/v2/api-docs/")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .exceptionHandling()
      .authenticationEntryPoint(jwtAuthenticationEntryPoint)
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    httpSecurity.addFilterBefore(
      jwtRequestFilter,
      UsernamePasswordAuthenticationFilter.class
    );
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    web
      .ignoring()
      .antMatchers("/v2/api-docs") //
      .antMatchers("/swagger-resources/**") //
      .antMatchers("/swagger-ui.html") //
      .antMatchers("/swagger-ui/index.html")
      .antMatchers("/configuration/**") //
      .antMatchers("/webjars/**") //
      .antMatchers("/public")
      // Un-secure H2 Database (for testing purposes, H2 console shouldn't be
      // unprotected in production)
      .and()
      .ignoring()
      .antMatchers("/h2-console/**/**");
  }
}
