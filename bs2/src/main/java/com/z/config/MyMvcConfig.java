package com.z.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.z.common.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 列举不需要验证登录状态的接口
 * @author zfx
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login",
                        "/user/reg",
                        "/product/index",
                        "/category/**",
                        "/**"
                )
                .excludePathPatterns("/static/**");
    }

    @Bean
    public Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    @Bean
    public Snowflake getSnowflake() {
        return IdUtil.getSnowflake(1, 11);
    }
}