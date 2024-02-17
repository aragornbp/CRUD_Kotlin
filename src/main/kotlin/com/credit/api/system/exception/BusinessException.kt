package com.credit.api.system.exception

data class BusinessException(override val message: String?) : RuntimeException(message){
}