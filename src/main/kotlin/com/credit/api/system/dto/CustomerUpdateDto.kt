package com.credit.api.system.dto

import com.credit.api.system.entity.Address
import com.credit.api.system.entity.Custumer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid input firstName")
    val firstName: String,

    @field:NotEmpty(message = "Invalid input lastName")
    val lastName: String,

    @field:NotNull(message = "Invalid input income")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid input zipCode")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid input street")
    val street: String
) {
    fun toEntity(customer: Custumer): Custumer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }

}