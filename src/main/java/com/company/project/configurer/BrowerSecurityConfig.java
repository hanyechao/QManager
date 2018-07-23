package com.company.project.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.formLogin() // 定义当需要用户登录时候，转到的登录页面。
		 .loginPage("/login") // 设置登录页面
		 .loginProcessingUrl("/user/detail") // 自定义的登录接口
		 .and().authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
		 .antMatchers("/login","/").permitAll() // 设置所有人都可以访问登录页面
		 .anyRequest() // 任何请求,登录后可以访问
		 .authenticated().and().csrf().disable(); // 关闭csrf防护

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 解决静态资源被拦截的问题
		web.ignoring().antMatchers("/static/**");
	}
}
