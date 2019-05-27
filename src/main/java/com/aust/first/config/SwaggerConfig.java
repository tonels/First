package com.aust.first.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact("tonels", "ls.tonels.com", "tonels");
//        return new ApiInfo(
//                "Swagger学习文档",
//                "这是学习swagger时生成的文档信息",
//                "v1.0",
//                "http://localhost:8080",
//                contact,
//                "ss",
//                "ssUrl",
//                new ArrayList<>()
//                );
//    }
@Bean
public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.aust.first.controller"))
            .build();
}

}
