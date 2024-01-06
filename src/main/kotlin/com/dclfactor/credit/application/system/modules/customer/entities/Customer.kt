package com.dclfactor.credit.application.system.modules.customer.entities

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Customer(
    @Column(nullable = false)
    val firstName: String = "",

    @Column(nullable = false)
    val lastName: String = "",

    @Column(nullable = false, unique = true)
    val email: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String = "",

    @Column(nullable = false)
    val password: String = "",

    @Column(nullable = false)
    val income: BigDecimal = BigDecimal.ZERO,

    @Embedded
    @Column(nullable = false)
    val address: Address = Address(),

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer")
    val credits: List<Credit> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)