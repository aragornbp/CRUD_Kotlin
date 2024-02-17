package com.credit.api.system.service.impl

import com.credit.api.system.ICustomerService
import com.credit.api.system.entity.Custumer
import com.credit.api.system.exception.BusinessException
import com.credit.api.system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository)
    : ICustomerService {
    override fun save(customer: Custumer): Custumer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Custumer {
        return this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }

}