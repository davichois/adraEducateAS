package com.adra.educate.security;

import com.adra.educate.auth.CustomAuthenticationFilter;
import com.adra.educate.auth.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/auth");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/api/adra-educate/auth").permitAll().and().cors().configurationSource(corsConfigurationSource());;

        // SOCIO
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/adra-educate/**").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/adra-educate/pedidosOracion").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/adra-educate/pedidosOracion").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/adra-educate/pedidosOracion").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/adra-educate/pedidosOracion").hasAnyAuthority("ROL_SOCIO");


        // ADMIN
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/adra-educate/**").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/adra-educate/**").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/adra-educate/**").hasAnyAuthority("ROL_SOCIO");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/adra-educate/**").hasAnyAuthority("ROL_SOCIO");

        // ASESOR BI

        //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        /*
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(false);
        //config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        config.setAllowedHeaders(Arrays.asList("Content-Type"));
        //config.setAllowedHeaders(Arrays.asList("*"));
         */
        config.setAllowCredentials(false); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("application/json;charset=utf-8");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
