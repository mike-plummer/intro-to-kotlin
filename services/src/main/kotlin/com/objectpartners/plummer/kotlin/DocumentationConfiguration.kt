package com.objectpartners.plummer.kotlin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@springfox.documentation.swagger2.annotations.EnableSwagger2
@org.springframework.context.annotation.Configuration
open class DocumentationConfiguration {

    @org.springframework.context.annotation.Bean
    open fun docket(): springfox.documentation.spring.web.plugins.Docket {
        return springfox.documentation.spring.web.plugins.Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
                .apiInfo((springfox.documentation.builders.ApiInfoBuilder()
                        .description("Kotlin example app")
                        .title("Intro to Kotlin")
                        .license("MIT")
                        .build())
                )
                .select()
                .build()
    }
}
