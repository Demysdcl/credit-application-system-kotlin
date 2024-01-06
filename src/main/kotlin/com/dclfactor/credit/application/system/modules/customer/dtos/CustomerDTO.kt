package com.dclfactor.credit.application.system.modules.customer.dtos

import com.dclfactor.credit.application.system.modules.customer.entities.Address
import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import java.math.BigDecimal


data class CustomerDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val income: BigDecimal,
    val cpf: String,
    val password: String,
    val zipCode: String,
    val street: String,
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        cpf = this.cpf,
        password = this.password,
        income = this.income,
        address = Address(zipCode = this.zipCode, street = this.street)
    )

}