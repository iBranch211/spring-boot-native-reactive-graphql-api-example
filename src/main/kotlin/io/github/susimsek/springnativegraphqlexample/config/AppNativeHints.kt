package io.github.susimsek.springnativegraphqlexample.config

import io.github.susimsek.springnativegraphqlexample.domain.Post
import io.github.susimsek.springnativegraphqlexample.domain.User
import io.github.susimsek.springnativegraphqlexample.graphql.enumerated.OrderType
import io.github.susimsek.springnativegraphqlexample.graphql.enumerated.PostOrderField
import io.github.susimsek.springnativegraphqlexample.graphql.enumerated.PostStatus
import io.github.susimsek.springnativegraphqlexample.graphql.enumerated.UserOrderField
import io.github.susimsek.springnativegraphqlexample.graphql.input.AddPostInput
import io.github.susimsek.springnativegraphqlexample.graphql.input.AddUserInput
import io.github.susimsek.springnativegraphqlexample.graphql.input.LoginInput
import io.github.susimsek.springnativegraphqlexample.graphql.input.PostOrder
import io.github.susimsek.springnativegraphqlexample.graphql.input.UpdatePostInput
import io.github.susimsek.springnativegraphqlexample.graphql.input.UserFilter
import io.github.susimsek.springnativegraphqlexample.graphql.input.UserOrder
import io.github.susimsek.springnativegraphqlexample.graphql.scalar.GraphQlDateTimeProperties
import io.github.susimsek.springnativegraphqlexample.graphql.scalar.ScalarUtil
import io.github.susimsek.springnativegraphqlexample.graphql.type.PostPayload
import io.github.susimsek.springnativegraphqlexample.graphql.type.Token
import io.github.susimsek.springnativegraphqlexample.graphql.type.UserPayload
import io.github.susimsek.springnativegraphqlexample.repository.UserRepositoryOverride
import io.github.susimsek.springnativegraphqlexample.repository.UserRepositoryOverrideImpl
import io.github.susimsek.springnativegraphqlexample.security.cipher.CipherProperties
import io.github.susimsek.springnativegraphqlexample.security.cipher.CryptoUtils
import io.github.susimsek.springnativegraphqlexample.security.jwt.TokenProperties
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.data.repository.query.FluentQuery
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint

@TypeHint(
    types = [
        org.springframework.data.repository.PagingAndSortingRepository::class,
        org.springframework.data.repository.CrudRepository::class,
        org.springframework.data.repository.Repository::class,
        org.springframework.data.repository.query.QueryByExampleExecutor::class,
        java.util.Optional::class,
        java.time.OffsetDateTime::class,
        java.time.LocalDateTime::class,
        java.time.LocalDate::class,
        FluentQuery::class,
        FluentQuery.FetchableFluentQuery::class,
        FluentQuery.ReactiveFluentQuery::class],
    access = [TypeAccess.QUERY_PUBLIC_METHODS]
)

@TypeHint(
    typeNames = [
        "io.github.susimsek.springnativegraphqlexample.graphql.scalar.GraphQlDateTimeProperties\$ScalarDefinition"
    ], access = [TypeAccess.RESOURCE, TypeAccess.PUBLIC_CLASSES, TypeAccess.DECLARED_CLASSES,
        TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_CONSTRUCTORS, TypeAccess.DECLARED_METHODS,
        TypeAccess.PUBLIC_METHODS, TypeAccess.PUBLIC_FIELDS, TypeAccess.DECLARED_FIELDS]
)

@TypeHint(
    types = [
        ScalarUtil::class,
        CryptoUtils::class,
        CorsProperties::class,
        GraphQlDateTimeProperties::class,
        TokenProperties::class,
        CipherProperties::class,
        SecurityMatcherProperties::class,
        LoginInput::class,
        AddUserInput::class,
        UserPayload::class,
        UserFilter::class,
        UserOrder::class,
        PostOrder::class,
        OrderType::class,
        UserOrderField::class,
        PostOrderField::class,
        AddPostInput::class,
        UpdatePostInput::class,
        PostStatus::class,
        PostPayload::class,
        Token::class,
        User::class,
        Post::class,
        UserRepositoryOverride::class,
        UserRepositoryOverrideImpl::class], access = [
        TypeAccess.RESOURCE, TypeAccess.PUBLIC_CLASSES, TypeAccess.DECLARED_CLASSES,
        TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_CONSTRUCTORS, TypeAccess.DECLARED_METHODS,
        TypeAccess.PUBLIC_METHODS, TypeAccess.PUBLIC_FIELDS, TypeAccess.DECLARED_FIELDS]
)
@Lazy(false)
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(name = ["org.springframework.nativex.NativeListener"])
class AppNativeHints
