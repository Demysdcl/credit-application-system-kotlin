package com.dclfactor.credit.application.system.modules.customer

import com.dclfactor.credit.application.system.modules.customer.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>