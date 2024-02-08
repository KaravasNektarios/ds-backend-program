package gr.hua.dit.ds.projectDSBackend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean (AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(unauthorizedHandler))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/signin",
                                "/api/auth/signup",
                                "/api/farmers/newFarmer"
                        ).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS,
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/v2/api-docs/**",
                                "/swagger-ui/**"
                        ).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS,
                                "/api/requests/newRequest",
                                "/api/products/deleteProductById/**",
                                "/api/products/newProduct",
                                "/api/products/deleteRegionById/**",
                                "/api/products/newProduct",
                                "/api/requests/deleteRequestById/**"
                        ).hasRole("USER")
                        .requestMatchers(
                                "/api/auth/farmers",
                                "/api/auth/farmers/**",
                                "/api/auth/supervisors/**",
                                "/api/auth/supervisors",
                                "/api/farmers/deleteFarmerById/**",
                                "/api/supervisors/deleteSupervisorById/**",
                                "/api/supervisors/newSupervisor",
                                "/api/auth/signupadmin"
                        ).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}