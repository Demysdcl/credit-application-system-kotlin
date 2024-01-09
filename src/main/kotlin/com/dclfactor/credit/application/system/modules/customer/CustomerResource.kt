package com.dclfactor.credit.application.system.modules.customer

import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerDTO
import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerUpdateDTO
import com.dclfactor.credit.application.system.modules.customer.dtos.CustomerView
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerService: CustomerService) {
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDTO) = customerService
        .save(customerDTO.toEntity())
        .let {
            ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Customer ${it.email} saved")
        }


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = customerService
        .findById(id)
        .let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomerView(it))
        }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam("customerId") id: Long,
        @RequestBody @Valid customerUpdateDTO: CustomerUpdateDTO
    ) = customerService.findById(id)
        .let { this.customerService.save(customerUpdateDTO.toEntity(it)) }
        .let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomerView(it))
        }

}