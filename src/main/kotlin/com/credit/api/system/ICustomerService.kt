package com.credit.api.system

import com.credit.api.system.entity.Custumer

interface ICustomerService {
    fun save(customer: Custumer): Custumer

    fun findById(id: Long): Custumer

    fun delete(id: Long)
}