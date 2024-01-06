package com.dclfactor.credit.application.system.modules.customer

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(nullable = false) val zipcode: String,
    @Column(nullable = false) val street: String
)
