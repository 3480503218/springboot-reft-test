package com.dhm;

import com.dhm.compoment.MyLocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringbootReftTestApplication {
@Bean
public ViewResolver viewResolver(){
    return new myViewResolver();
}
public static class myViewResolver implements ViewResolver{

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return null;
    }


}


    public static void main(String[] args) {
        SpringApplication.run(SpringbootReftTestApplication.class, args);
    }

}
