package com.dclfactor.credit.application.system.modules.credit

import com.dclfactor.credit.application.system.modules.credit.dtos.CreditDTO
import com.dclfactor.credit.application.system.modules.credit.dtos.CreditView
import com.dclfactor.credit.application.system.modules.credit.dtos.CreditViewListDTO
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/credits")
class CreditResource(private val creditService: CreditService) {

    @PostMapping
    fun saveCredit(@RequestBody creditDTO: CreditDTO) = creditService
        .save(creditDTO.toEntity())
        .let { "Credit ${it.creditCode} - Customer ${it.customer?.firstName}  saved!" }

    @GetMapping
    fun findAllByCustomerId(@RequestParam("customerId") customerId: Long): List<CreditViewListDTO> = this.creditService
        .findAllByCustomer(customerId)
        .stream()
        .map { CreditViewListDTO(it) }
        .toList()

    @GetMapping("/{customerId}")
    fun findAllByCreditCode(
        @PathVariable("customerId") customerId: Long,
        @RequestParam("creditCode") creditCode: UUID
    ) = this.creditService
        .findByCreditCode(customerId, creditCode)
        .let { CreditView(it) }
}