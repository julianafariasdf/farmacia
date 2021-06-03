package br.com.teste.Farmacia.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
@SuppressWarnings("deprecation")
public class ResourceHandlerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Farmacia",
                "Desafio.", "Versão 1.0", "Juliana Farias",
                new Contact("Juliana Farias", "https://github.com/julianafariasdf/farmacia", "juliana.ferreira.farias@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/resources/webjars/");
    }

}
