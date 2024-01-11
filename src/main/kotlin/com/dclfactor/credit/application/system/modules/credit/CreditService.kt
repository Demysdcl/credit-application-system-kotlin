package com.dclfactor.credit.application.system.modules.credit

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import com.dclfactor.credit.application.system.modules.customer.CustomerService
import com.dclfactor.credit.application.system.modules.exception.BusinessException
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) {
    fun save(credit: Credit): Credit = credit
        .also { validDayFirstInstallment(it.dayFirstInstallment) }
        .copy(customer = this.customerService.findById(credit.customer?.id!!))
        .let { this.creditRepository.save(it) }

    private fun validDayFirstInstallment(dayFirstInstallment: LocalDate) = with(dayFirstInstallment) {
        if (!isBefore(LocalDate.now().plusMonths(3)))
            throw BusinessException("Invalid Date")

    }

    fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit = this.creditRepository
        .findByCreditCode(customerId, creditCode)
        .orElseThrow {
            throw BusinessException("Credit code $creditCode not found to customer ID: $customerId")
        }


}