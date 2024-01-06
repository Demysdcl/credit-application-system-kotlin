package com.dclfactor.credit.application.system.modules.credit.dtos

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import com.dclfactor.credit.application.system.modules.credit.entities.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val customerEmail: String,
    val customerIncome: BigDecimal
) {
    constructor(credit: Credit) : this(
        creditValue = credit.creditValue,
        creditCode = credit.creditCode,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        customerEmail = credit.customer?.email ?: "",
        customerIncome = credit.customer?.income ?: BigDecimal.ZERO
    )
}