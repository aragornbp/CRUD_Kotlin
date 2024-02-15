package com.credit.api.system

import com.credit.api.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID, customerId: Long): Credit
}