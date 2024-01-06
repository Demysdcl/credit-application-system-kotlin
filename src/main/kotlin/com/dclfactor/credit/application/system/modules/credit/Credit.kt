package com.dclfactor.credit.application.system.modules.credit

import com.dclfactor.credit.application.system.modules.credit.enumeration.Status
import com.dclfactor.credit.application.system.modules.customer.Customer
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
data class Credit(
    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    val dayFirstInstallment: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Column(nullable = false)
    @Enumerated
    val status: Status = Status.IN_PROCESS,

    @ManyToOne
    val customer: Customer? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
