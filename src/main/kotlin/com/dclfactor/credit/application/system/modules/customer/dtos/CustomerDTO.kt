package com.dclfactor.credit.application.system.modules.customer.dtos

import com.dclfactor.credit.application.system.modules.customer.entities.Address
import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal


data class CustomerDTO(
    @field:NotEmpty(message = "The first name cannot be empty")
    val firstName: String,

    @field:NotEmpty(message = "The last name cannot be empty")
    val lastName: String,

    @field:Email(message = "Invalid email")
    val email: String,

    @field:NotNull(message = "Invalid income")
    val income: BigDecimal,

    @field:CPF(message = "Invalid CPF")
    val cpf: String,

    @field:NotEmpty(message = "The password cannot be empty")
    val password: String,

    @field:NotEmpty(message = "The zip code cannot be empty")
    val zipCode: String,

    @field:NotEmpty(message = "The street cannot be empty")
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