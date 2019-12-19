package com.gylhaut.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //声明这是一个注解类
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.gylhaut.springbootdemo.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("gylhaut",
                "https://www.gylhaut.com",
                "gyhaut@qq.com");
        return new ApiInfoBuilder()
                .title("项目API接口")
                .description("接口描述")
                .contact(contact)
                .license("The Apache License")
                .licenseUrl("wwww.baidu.com")
                .version("1.1.0")
                .build();
    }
}