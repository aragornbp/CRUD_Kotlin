package com.credit.api.system.dto

import com.credit.api.system.entity.Address
import java.math.BigDecimal
import com.credit.api.system.entity.Custumer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF

data class CustomerDto(

    @field:NotEmpty(message = "Invalid input firstName")
    val firstName: String,

    @field:NotEmpty(message = "Invalid input lastName")
    val lastName: String,

    @field:NotEmpty(message = "Invalid input cpf")
    @field:CPF(message = "Invalid input cpf")
    val cpf: String,

    @field:NotNull(message = "Invalid input income")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid input email")
    @field:Email(message = "Invalid input email")
    val email: String,

    @field:NotEmpty(message = "Invalid input")
    val password: String,

    @NotEmpty(message = "Invalid input")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid input")
    val street: String
) {
    fun toEntity(): Custumer = Custumer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )

    )
}