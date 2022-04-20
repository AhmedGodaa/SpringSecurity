package net.godaa.SpringSecurity.security;

//import net.godaa.SpringSecurity.models.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired

    PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ahmed = User.builder().username("ahmed").password(encoder.encode("password")).roles("USER").build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(encoder.encode("password123"))
                .roles("ADMIN") // ROLE_ADMIN
                .build();

        UserDetails tomUser = User.builder()
                .username("tom")
                .password(encoder.encode("password123"))
                .roles("ADMIN") // ROLE_ADMINISTRATE
                .build();

        return new InMemoryUserDetailsManager(ahmed,lindaUser,tomUser);
    }
}
