package com.credit.api.system.dto

import com.credit.api.system.entity.Credit
import com.credit.api.system.entity.Custumer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Custumer(id = this.customerId)
    )
}
