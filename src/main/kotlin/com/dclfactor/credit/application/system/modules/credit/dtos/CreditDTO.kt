package com.dclfactor.credit.application.system.modules.credit.dtos

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull(message = "The value cannot be empty")
    val creditValue: BigDecimal,

    @field:Future(message = "The date cannot be past")
    val dayFirstInstallment: LocalDate,

    @field:Min(value = 1)
    @field:Max(value = 24)
    val numberOfInstallments: Int,

    @field:NotNull(message = "The customer id cannot be empty")
    val customerId: Long
) {
    fun toEntity() = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
