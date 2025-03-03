package com.ximple.library.config;

import com.ximple.library.config.filter.ContextCaptureFilter;
import com.ximple.library.config.filter.RequestTimingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class AppConfig {

    @Bean
    ContextCaptureFilter baseLoggingFilter() {
        return new ContextCaptureFilter();
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> contextCaptureFilter() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ContextCaptureFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> requestTimingFilter() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestTimingFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

}
