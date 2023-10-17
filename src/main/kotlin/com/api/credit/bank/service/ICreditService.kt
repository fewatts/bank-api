package com.api.credit.bank.service

import java.util.UUID
import com.api.credit.bank.entity.Credit

interface ICreditService {
  fun save(credit: Credit): Credit
  fun findAllByCustomer(customerId: Long): List<Credit>
  fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}