package io.github.susimsek.springnativegraphqlexample.security

import io.github.susimsek.springnativegraphqlexample.domain.User
import io.github.susimsek.springnativegraphqlexample.exception.UserNotActivatedException
import io.github.susimsek.springnativegraphqlexample.repository.UserRepository
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator
import org.slf4j.LoggerFactory
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.Locale

@Component("userDetailsService")
class DomainUserDetailsService(private val userRepository: UserRepository) : ReactiveUserDetailsService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun findByUsername(login: String): Mono<UserDetails> {
        log.debug("Authenticating $login")

        if (EmailValidator().isValid(login, null)) {
            return userRepository.findOneByEmailIgnoreCase(login)
                .switchIfEmpty(
                    Mono.error(
                        UsernameNotFoundException("User with email $login was not found in the database")
                    )
                )
                .map { createSpringSecurityUser(login, it) }
        }

        val lowercaseLogin = login.lowercase(Locale.ENGLISH)
        return userRepository.findOneByUsername(lowercaseLogin)
            .switchIfEmpty(Mono.error(UsernameNotFoundException("User $lowercaseLogin was not found in the database")))
            .map { createSpringSecurityUser(lowercaseLogin, it) }
    }

    private fun createSpringSecurityUser(lowercaseLogin: String, user: User):
            org.springframework.security.core.userdetails.User {
        if (user.activated == null || user.activated == false) {
            throw UserNotActivatedException("User $lowercaseLogin was not activated")
        }
        val grantedAuthorities = mutableSetOf(SimpleGrantedAuthority(USER))
        return org.springframework.security.core.userdetails.User(
            user.id,
            user.password,
            grantedAuthorities
        )
    }
}
