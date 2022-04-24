package io.github.susimsek.springnativegraphqlexample.graphql.type

import java.time.OffsetDateTime

data class UserPayload(
    var id: String? = null,

    var username: String? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var email: String? = null,

    var createdDate: OffsetDateTime
)
