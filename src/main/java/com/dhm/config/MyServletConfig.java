package com.dhm.config;

import com.dhm.Listener.MyListener;
import com.dhm.filter.MyFilter;
import com.dhm.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig{
    @Bean
public ServletListenerRegistrationBean myListener(){
         ServletListenerRegistrationBean<MyListener> registrationBean = new
                ServletListenerRegistrationBean<>(new MyListener());

        return registrationBean;}




        @Bean
    public FilterRegistrationBean myFilter() {
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       registrationBean.setFilter(new MyFilter());
       registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
       return registrationBean;}


       @Bean
       public ServletRegistrationBean servletRegistrationBean () {
       ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
           return servletRegistrationBean;
       }

       //嵌入式的servlet容器的定制器，用于修改servlet容器的配置
       @Bean
       public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer () {
           return new EmbeddedServletContainerCustomizer() {
               @Override
               public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                   //规则
                   configurableEmbeddedServletContainer.setPort(8888);
               }
           };
       }
   }
