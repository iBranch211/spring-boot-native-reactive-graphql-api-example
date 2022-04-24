package io.github.susimsek.springnativegraphqlexample.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("security-matcher")
@ConstructorBinding
data class SecurityMatcherProperties (
    var ignorePatterns: MutableList<String> = mutableListOf(),
    var permitAllPatterns: MutableList<String> = mutableListOf()
) {

}