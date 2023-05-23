package fr.mns.loctraining.security;

import fr.mns.loctraining.domain.repository.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

// Classe de configuration pour Spring Security
// Annotation EnableWebSecurity permet d'indiquer à Spring que cette configuration est à ajouter aux configs WebSecurity
@EnableWebSecurity
// Annotation EnableMethdeSecurity permet d'enable/disable certaines méthodes de sécurités (pre/post, secured, jsr250) ici par défaut seulement pre/post est enable (voir https://www.baeldung.com/spring-security-method-security)
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailService(userRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http.cors().configurationSource(httpServletRequest -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.applyPermitDefaultValues();
                    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
                    corsConfiguration.setAllowedHeaders(
                            Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin"));
                    return corsConfiguration;
                }).and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/connexion", "/inscription", "/**").permitAll()
                .requestMatchers("/admin/**").hasAnyRole("administrateur")
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
