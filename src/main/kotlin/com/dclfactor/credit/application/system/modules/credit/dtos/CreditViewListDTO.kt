package com.dclfactor.credit.application.system.modules.credit.dtos

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewListDTO(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int
) {
    constructor(credit: Credit) : this(
        creditValue = credit.creditValue,
        creditCode = credit.creditCode,
        numberOfInstallments = credit.numberOfInstallments
    )
}
