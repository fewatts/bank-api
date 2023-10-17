package com.api.credit.bank.dto.response


import java.math.BigDecimal
import java.util.*
import com.api.credit.bank.enummeration.Status
import com.api.credit.bank.entity.Credit

data class CreditView(
  val creditCode: UUID,
  val creditValue: BigDecimal,
  val numberOfInstallment: Int,
  val status: Status,
  val emailCustomer: String?,
  val incomeCustomer: BigDecimal?
) {
  constructor(credit: Credit) : this(
    creditCode = credit.creditCode,
    creditValue = credit.creditValue,
    numberOfInstallment = credit.numberOfInstallments,
    status = credit.status,
    emailCustomer = credit.customer?.email,
    incomeCustomer = credit.customer?.income
  )
}