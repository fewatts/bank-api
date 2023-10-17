package com.api.credit.bank.service.impl

import org.springframework.stereotype.Service
import com.api.credit.bank.repository.CustomerRepository
import com.api.credit.bank.entity.Customer
import com.api.credit.bank.service.ICustomerService
import com.api.credit.bank.exception.BusinessException

@Service
class CustomerService(
  private val customerRepository: CustomerRepository
): ICustomerService {
  override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

  override fun findById(id: Long): Customer = this.customerRepository.findById(id)
    .orElseThrow{throw BusinessException("Id $id not found") }

  override fun delete(id: Long) {
    val customer: Customer = this.findById(id)
    this.customerRepository.delete(customer)
  }
}