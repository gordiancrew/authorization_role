package com.kazantsev.authorization_role.config;

import com.kazantsev.authorization_role.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()


                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/addstage").hasRole("ADMIN")
                .antMatchers("/addimage").hasRole("ADMIN")
                .antMatchers("/addimage2").hasRole("ADMIN")
                .antMatchers("/delete").hasRole("ADMIN")
                .antMatchers("/deleteuser").hasRole("ADMIN")
                .antMatchers("/deletestage").hasRole("ADMIN")
                .antMatchers("/deleteloc").hasRole("ADMIN")
                .antMatchers("/deleteimage").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/newlocation").hasRole("USER")
                .antMatchers("/rule").hasRole("USER")
                .antMatchers("/quests").hasRole("USER")
                .antMatchers("/adminuser").hasAnyRole("ADMIN","USER")

                //Доступ разрешен всем пользователей
                .antMatchers("/").permitAll()
                .antMatchers("/infopage").permitAll()

               // .antMatchers("/creater").permitAll()
                .antMatchers("/deleter").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/addimage").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
               .loginPage("/login")

                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }
//
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "/styles/**", "/fonts/**",
                        "/images/**","/imgs/**");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }}
