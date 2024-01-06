package com.dclfactor.credit.application.system.modules.customer

import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerDTO
import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerUpdateDTO
import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerView
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerService: CustomerService) {
    @PostMapping
    fun saveCustomer(customerDTO: CustomerDTO) = customerService
        .save(customerDTO.toEntity())
        .let { "Customer ${it.email} saved" }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = customerService
        .findById(id)
        .let { CustomerView(it) }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam("customerId") id: Long,
        @RequestBody customerUpdateDTO: CustomerUpdateDTO
    ) = this.customerService
        .findById(id)
        .let {
            this.customerService
                .save(customerUpdateDTO.toEntity(it))
                .let { customer -> CustomerView(customer) }
        }

}