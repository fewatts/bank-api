package com.api.credit.bank.exception

data class BusinessException(override val message: String?) : RuntimeException(message)