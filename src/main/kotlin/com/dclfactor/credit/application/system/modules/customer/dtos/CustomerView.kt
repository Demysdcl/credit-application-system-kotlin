package com.dclfactor.credit.application.system.modules.customer.dtos

import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import java.math.BigDecimal


data class CustomerView(
    val firstName: String,
    val lastName: String,
    val email: String,
    val income: BigDecimal,
    val cpf: String,
    val zipCode: String,
    val street: String,
) {
    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        email = customer.email,
        cpf = customer.cpf,
        income = customer.income,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )

}