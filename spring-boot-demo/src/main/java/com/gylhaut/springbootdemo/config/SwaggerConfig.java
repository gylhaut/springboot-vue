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
                //如果不想将所有的接口都通过swagger管理的话，
                // 可以将RequestHandlerSelectors.any()修改为RequestHandlerSelectors.basePackage()
                .apis(RequestHandlerSelectors
                        .basePackage("com.gylhaut.springbootdemo.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("gylhaut",
                "https://www.gylhaut.com",
                "gyhaut@qq.com");
        return new ApiInfoBuilder()
                //标题
                .title("项目API接口")
                //简介
                .description("接口描述")
                //作者个人信息
                .contact(contact)
                //服务条款
                .termsOfServiceUrl("")
                .license("The Apache License")
                .licenseUrl("wwww.baidu.com")
                //版本
                .version("1.0.0")
                .build();
    }
}