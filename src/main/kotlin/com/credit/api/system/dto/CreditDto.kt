package com.credit.api.system.dto

import com.credit.api.system.entity.Credit
import com.credit.api.system.entity.Custumer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input creditValue")
    val creditValue: BigDecimal,

    @field:Future(message = "Invalid input dayFirstOfInstallment, need be in future time")
    val dayFirstOfInstallment: LocalDate,

    @field:NotNull(message = "Invalid input numberOfInstallment")
    @field:Min(1)
    @field:Max(5)
    val numberOfInstallment: Int,

    @field:NotNull(message = "Invalid input customerId")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Custumer(id = this.customerId)
    )
}
