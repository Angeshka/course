package com.kursach.config;

import com.kursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//базовый класс для  настройки безопасность веб-приложений, используя Spring Security
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //метод настраивает доступ к ресурсам веб-приложения, в том числе определяет, какие URL-адреса требуют аутентификации и авторизации, а какие нет
        http
                .csrf().disable()
                //Отключает CSRF-защиту, которая защищает приложение от атак межсайтовой подделки запросов
                .authorizeRequests()
                .antMatchers("/", "/img/**", "/css/**", "/js/**", "/index", "/reg").permitAll()
                .anyRequest()
                .authenticated()
                //Переход к настройке авторизации запросов. antMatchers() указывает, какие URL-адреса должны быть доступны для всех без авторизации,
                // а все остальные запросы должны быть аутентифицированы (authenticated()).
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/catalog-page")
                //Переход к настройке аутентификации. loginPage() указывает страницу для входа в систему, а defaultSuccessUrl()
                // устанавливает URL-адрес для перенаправления после успешного входа в систему.
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                //Настройка выхода из системы. logoutRequestMatcher() определяет URL-адрес для выхода из системы,
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                //очищают данные, связанные с текущей сессией и аутентификацией.
                .logoutSuccessUrl("/login");
        // а logoutSuccessUrl() устанавливает URL-адрес для перенаправления после выхода из системы.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //метод настраивает аутентификацию пользователей
        auth
                .userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
