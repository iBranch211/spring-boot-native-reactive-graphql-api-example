package io.github.susimsek.springnativegraphqlexample.graphql.controller

import io.github.susimsek.springnativegraphqlexample.graphql.input.LoginInput
import io.github.susimsek.springnativegraphqlexample.graphql.type.Token
import io.github.susimsek.springnativegraphqlexample.service.AuthenticationService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono
import javax.validation.Valid

@Controller
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @MutationMapping
    fun login(@Argument @Valid input: LoginInput): Mono<Token> {
        return authenticationService.authorize(input)
    }
}