package com.alvin.common;

import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title       : SwaggerConfig.java 
 * @Company		: 永硕
 * @Package     : com.alvin.common 
 * @Description : TODO(swagger 配置) 
 * @author      : fxd
 * @date        : 2019-4-23 下午4:03:18 
 * @version     : 版本 3.0
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages={"com.scan.controller"})
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport{

	@Bean
	public Docket customDocket(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo())
				.select()
                //扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.xia.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
	}
	
	private ApiInfo apiinfo(){
		 return new ApiInfoBuilder()
         .title("API")//标题
         .description("")//描述
         .version("1.0.0")//版本
         .build();
	}
}
