package com.dclfactor.credit.application.system.modules.exception

data class BusinessException(override val message: String?) : RuntimeException(message)
