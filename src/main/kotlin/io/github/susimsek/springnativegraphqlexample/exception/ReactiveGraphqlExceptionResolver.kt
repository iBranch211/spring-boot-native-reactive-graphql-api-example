package io.github.susimsek.springnativegraphqlexample.exception

import org.springframework.graphql.execution.DataFetcherExceptionResolver
import graphql.schema.DataFetchingEnvironment
import reactor.core.publisher.Mono
import graphql.GraphQLError
import io.github.susimsek.tournamentbackend.exception.ResourceNotFoundException
import graphql.GraphqlErrorBuilder
import io.github.susimsek.tournamentbackend.exception.ResourceAlreadyExistsException
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class ReactiveGraphqlExceptionResolver : DataFetcherExceptionResolver {
    override fun resolveException(
        ex: Throwable,
        env: DataFetchingEnvironment
    ): Mono<List<GraphQLError>> {
        return when (ex) {
            is ResourceNotFoundException -> {
                val error = GraphqlErrorBuilder.newError(env)
                    .message(ex.message).errorType(ErrorType.NOT_FOUND).build()
                Mono.just(listOf(error))
            }
            is ResourceAlreadyExistsException -> {
                val error = GraphqlErrorBuilder.newError(env)
                    .message(ex.message).errorType(ErrorType.BAD_REQUEST).build()
                Mono.just(listOf(error))
            }
            else -> {
                Mono.empty()
            }
        }
    }
}