package com.credit.api.system.entity

import java.math.BigDecimal
import java.time.LocalDate
import com.credit.api.system.enummeration.Status
import jakarta.persistence.*
import java.util.UUID

@Entity
data class Credit(
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false) val dayFirstInstallment: LocalDate,

    @Column(nullable = false) val numberOfInstallment: Int = 0,

    @Enumerated val status: Status = Status.IN_PROGRESS,

    @ManyToOne var customer: Custumer? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
    )


