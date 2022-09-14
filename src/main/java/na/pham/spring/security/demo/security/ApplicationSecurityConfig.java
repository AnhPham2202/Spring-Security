package na.pham.spring.security.demo.security;

import na.pham.spring.security.demo.enums.UserRoleEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/*", "/js/*","/logout")
                .permitAll()
                .antMatchers("/api/**").hasRole((UserRoleEnums.ADMIN_ROLE.name()))
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority(UserRoleEnums.ADMIN_ROLE.name())
                .antMatchers(HttpMethod.PUT,"/api/**").hasAuthority(UserRoleEnums.ADMIN_ROLE.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(UserRoleEnums.ADMIN_ROLE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails na = User.builder()
                .username("napham")
                .password(passwordEncoder.encode("password"))
                .roles(UserRoleEnums.STUDENT_ROLE.name())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(UserRoleEnums.ADMIN_ROLE.name())
                .build();

        return new InMemoryUserDetailsManager(
                na,
                admin
        );
    }
}
