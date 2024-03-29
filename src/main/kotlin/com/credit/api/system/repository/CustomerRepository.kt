package com.credit.api.system.repository

import com.credit.api.system.entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Custumer, Long> {
}