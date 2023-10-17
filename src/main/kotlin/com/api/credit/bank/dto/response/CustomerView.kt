package com.api.credit.bank.dto.response


import java.math.BigDecimal
import com.api.credit.bank.entity.Customer

data class CustomerView(
  val firstName: String,
  val lastName: String,
  val cpf: String,
  val income: BigDecimal,
  val email: String,
  val zipCode: String,
  val street: String,
  val id: Long?
) {
  constructor(customer: Customer): this (
    firstName = customer.firstName,
    lastName = customer.lastName,
    cpf = customer.cpf,
    income = customer.income,
    email = customer.email,
    zipCode = customer.address.zipCode,
    street = customer.address.street,
    id = customer.id
  )
}