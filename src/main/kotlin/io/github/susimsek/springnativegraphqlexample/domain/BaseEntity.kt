package io.github.susimsek.springnativegraphqlexample.domain

import io.github.susimsek.springnativegraphqlexample.domain.audit.AbstractUserAuditingEntity
import org.springframework.data.annotation.Id

open class BaseEntity(
    @Id
    var id: String? = null
) : AbstractUserAuditingEntity()