package io.github.susimsek.springnativegraphqlexample.exception

data class FieldError(
    var property: String? = null,
    var message: String? = null
)
