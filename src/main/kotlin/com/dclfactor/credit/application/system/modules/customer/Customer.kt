package com.dclfactor.credit.application.system.modules.customer

import com.dclfactor.credit.application.system.modules.credit.Credit
import jakarta.persistence.*

@Entity
data class Customer(
    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false)
    val password: String,

    @Embedded
    @Column(nullable = false)
    val address: Address,

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer")
    val credits: List<Credit> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)