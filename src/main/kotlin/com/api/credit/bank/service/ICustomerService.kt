package com.api.credit.bank.service

import com.api.credit.bank.entity.Customer


interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
  }