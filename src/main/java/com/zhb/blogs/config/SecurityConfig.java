package com.zhb.blogs.config;

import com.zhb.blogs.pojo.User;
import com.zhb.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * @author: zh'b
 * @date: 2021/5/4 20:24
 * @description: //TODO 请完善注释信息
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = (String) authentication.getCredentials();
                User user = userService.findUserByUsername(username);
                if (user!=null){
                    if (!passwordEncoder().matches(password,user.getPassword())){
                        throw new BadCredentialsException("密码不正确!");
                    }
                }else {
                    throw new UsernameNotFoundException("账号不存在!");
                }
                return new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getRole());
            }

            @Override
            public boolean supports(Class<?> aClass) {
                return UsernamePasswordAuthenticationToken.class.equals(aClass);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN");
        http.formLogin()
                .loginProcessingUrl("/admin/login")
                .loginPage("/admin")
                .defaultSuccessUrl("/admin/blogs").permitAll();
        http.logout().logoutUrl("/admin/logout").logoutSuccessUrl("/").permitAll();
        /*http.rememberMe()
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(900)
                .userDetailsService(userDetailsService);//15分钟*/
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //tokenRepository.setCreateTableOnStartup(false);
        return tokenRepository;
    }

}
