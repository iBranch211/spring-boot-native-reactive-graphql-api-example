package io.github.susimsek.springnativegraphqlexample.repository

import io.github.susimsek.springnativegraphqlexample.domain.User
import io.github.susimsek.springnativegraphqlexample.graphql.input.UserFilter
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Flux

interface UserRepositoryOverride {
    fun findAllByFilter(filter: UserFilter?, pageable: Pageable): Flux<User>
}
