package com.example.demo.security;

import com.example.demo.User.UserService;
import com.example.demo.jwt.UserNameAndPasswordAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new UserNameAndPasswordAuthenticationFilter(authenticationManager()))
                .authorizeRequests()
                    .antMatchers("/", "/api/v*/registration/**").permitAll()
                /////////////////////////////////////////////////////////////////////////
                //example from another project
//                  .antMatchers("/api/**").hasRole(ADMIN.name())
//                  .antMatchers("/api//**").hasRole(ADMIN.name())
//                  .antMatchers("/api/v1/student/write/").hasRole(ADMIN.name())
//                  .antMatchers("/api/v1/course/**").hasRole(ADMIN.name())
//                  .antMatchers("/api/v1/course/write/").hasRole(ADMIN.name())
//                  .antMatchers(HttpMethod.POST,"/manager/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                  .antMatchers(HttpMethod.DELETE, "/manager/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                  .antMatchers(HttpMethod.PUT, "/manager/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                  .antMatchers(HttpMethod.GET,"/manager/api/**").hasAnyRole(ADMIN.name(), STUDENT.name())
                .anyRequest()
                .authenticated();
                /*.and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/courses")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))// TODO: 09.06.2021 jast for .csrf().disable()
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                .and()
                    .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("someKey")
                .and()
                    .httpBasic();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
