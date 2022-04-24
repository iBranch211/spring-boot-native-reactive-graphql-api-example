package io.github.susimsek.tournamentbackend.exception

import java.lang.RuntimeException

class ResourceNotFoundException(message: String?) : RuntimeException(message)