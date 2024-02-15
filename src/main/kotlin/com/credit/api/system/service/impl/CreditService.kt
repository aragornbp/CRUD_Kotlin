package com.credit.api.system.service.impl

import com.credit.api.system.ICreditService
import com.credit.api.system.entity.Credit
import com.credit.api.system.repository.CreditRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCreditCode(creditCode: UUID, customerId: Long): Credit {
        val credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found"))

        return if(credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}