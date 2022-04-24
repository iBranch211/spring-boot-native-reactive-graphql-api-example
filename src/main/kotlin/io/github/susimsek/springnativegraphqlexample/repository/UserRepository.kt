package io.github.susimsek.springnativegraphqlexample.repository

import io.github.susimsek.springnativegraphqlexample.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveMongoRepository<User, String>, UserRepositoryOverride {
    fun findOneByEmailIgnoreCase(email: String?): Mono<User>

    fun findOneByUsername(login: String): Mono<User>

    override fun count(): Mono<Long>

    fun findAllByIdIn(id: MutableSet<String>?): Flux<User>
}
