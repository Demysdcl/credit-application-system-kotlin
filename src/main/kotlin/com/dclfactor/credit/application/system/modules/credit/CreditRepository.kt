package com.dclfactor.credit.application.system.modules.credit

import com.dclfactor.credit.application.system.modules.credit.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface CreditRepository : JpaRepository<Credit, Long> {
    @Query("SELECT c FROM Credit c WHERE c.customer.id = :customerId")
    fun findAllByCustomerId(@Param("customerId") customerId: Long): List<Credit>

    @Query("SELECT c FROM Credit c WHERE c.customer.id = :customerId and c.creditCode = :creditCode")
    fun findByCreditCode(@Param("customerId") customerId: Long, @Param("creditCode") creditCode: UUID): Optional<Credit>
}