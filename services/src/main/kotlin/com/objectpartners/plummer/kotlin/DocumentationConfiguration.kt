package com.objectpartners.plummer.kotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
open class DocumentationConfiguration {

    @Bean
    open fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo((
                        ApiInfoBuilder()
                        .description("Kotlin example app")
                        .title("Intro to Kotlin")
                        .license("MIT")
                        .build())
                )
                .select()
                .build()
    }
}
