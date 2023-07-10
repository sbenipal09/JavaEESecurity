package sin12743.securityexample1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
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

        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder ;
    }
}