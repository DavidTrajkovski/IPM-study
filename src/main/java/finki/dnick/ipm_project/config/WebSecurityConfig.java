package finki.dnick.ipm_project.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomEmailPasswordAuthenticationProvider customEmailPasswordAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/welcome", "/register", "/**.jpg", "/**.JPG", "/**.png", "/**.gif", "/**.css"/*, "/courses**", "/tests**", "/users/export/pdf", "/my-profile", "/professional-help"*/).permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/")
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login?error=BadCredentials")
                .and()
                    .logout().logoutSuccessUrl("/login?success=true")
                    .clearAuthentication(true).invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customEmailPasswordAuthenticationProvider);
    }
}