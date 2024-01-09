package com.dclfactor.credit.application.system.modules.customer

import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import com.dclfactor.credit.application.system.modules.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class CustomerService(private val repository: CustomerRepository) {

    fun save(customer: Customer) = this.repository.save(customer)

    fun findById(id: Long): Customer = this.repository
        .findById(id)
        .orElseThrow {
            throw BusinessException("Id $id not found")
        }

    fun delete(id: Long) = this.findById(id)
        .let { repository.delete(it) }

}