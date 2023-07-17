package sin12743.securityexample1.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
   /*
    public InMemoryUserDetailsManager
    userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("Simran")
                .password(passwordEncoder.encode("123"))
                .roles("USER")//ALWAYS UPPERCASE
                .build();

        UserDetails user2 = User.withUsername("Benipal")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "PICKLE")//ALWAYS UPPERCASE
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }*/


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests((auth)->
                auth
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/Multiple").hasRole("PICKLE")
                        .requestMatchers(HttpMethod.GET,"/h2-console/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin((formlogin)->
                formlogin
                        .loginPage("/logintem")
                        .failureUrl("/logintem?failed")
                        .permitAll()

                        )
                .logout((logout)->
                            logout
                                    .deleteCookies("remove")
                                    .invalidateHttpSession(true)
                                    .logoutUrl("/logout")
                                    .logoutSuccessUrl("/logintem?logout")
                                    .permitAll())
                .exceptionHandling((exceptionHandling)->
                        exceptionHandling
                                .accessDeniedPage("/accessdenied"));


        return http.build();

    }

    private UserDetailsServiceImpl userDetailsService;

@Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       PasswordEncoder passwordEncoder) throws Exception{
    AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    return  authenticationManagerBuilder.build();
}
}