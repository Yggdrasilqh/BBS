package com.yggdrasil;

import com.yggdrasil.Interceptor.LayoutGroupInterceptor;
import com.yggdrasil.Interceptor.LoginInterceptor;
import com.yggdrasil.Interceptor.ModifyLayoutInterceptor;
import com.yggdrasil.Interceptor.ModifyPostIntercepter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BbsApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor
				(new LoginInterceptor())
				.addPathPatterns("/login/**");
		registry.addInterceptor
				(new LayoutGroupInterceptor())
				.addPathPatterns("/login/post/**");
		registry.addInterceptor
				(new ModifyLayoutInterceptor())
				.addPathPatterns("/login/modifyLayout/**");
		registry.addInterceptor
				(new ModifyPostIntercepter())
				.addPathPatterns("/login/post/modify/**");
		//super.addInterceptors(registry);
	}
}
