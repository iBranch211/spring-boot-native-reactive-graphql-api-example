package io.github.susimsek.tournamentbackend.exception

import java.lang.RuntimeException

class ResourceAlreadyExistsException(message: String?) : RuntimeException(message)