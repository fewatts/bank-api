package com.api.credit.bank.dto.request

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import com.api.credit.bank.entity.Credit
import com.api.credit.bank.entity.Customer

data class CreditDto(
  @field:NotNull(message = "Invalid input") val creditValue: BigDecimal,
  @field:Future val dayFirstOfInstallment: LocalDate,
  @field:Min(value = 1) @field:Max(value = 48) val numberOfInstallments: Int,
  @field:NotNull(message = "Invalid input") val customerId: Long
) {

  fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstInstallment = this.dayFirstOfInstallment,
    numberOfInstallments = this.numberOfInstallments,
    customer = Customer(id = this.customerId)
  )
}