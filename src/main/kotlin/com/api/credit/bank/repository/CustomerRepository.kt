package com.api.credit.bank.repository


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.api.credit.bank.entity.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>