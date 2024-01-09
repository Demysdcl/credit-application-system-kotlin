package com.dclfactor.credit.application.system.modules.customer.dtos

import com.dclfactor.credit.application.system.modules.customer.entities.Address
import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal


data class CustomerUpdateDTO(
    @field:NotEmpty(message = "The first name cannot be empty")
    val firstName: String,

    @field:NotEmpty(message = "The last name cannot be empty")
    val lastName: String,

    @field:NotNull(message = "The income cannot be empty")
    val income: BigDecimal,

    @field:NotEmpty(message = "The zip code cannot be empty")
    val zipCode: String,

    @field:NotEmpty(message = "The street cannot be empty")
    val street: String,
) {
    fun toEntity(customer: Customer): Customer = customer.copy(
        firstName = this.firstName,
        lastName = this.lastName,
        income = this.income,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )

}