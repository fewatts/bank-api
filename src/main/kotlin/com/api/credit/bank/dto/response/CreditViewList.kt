

import java.math.BigDecimal
import java.util.*
import com.api.credit.bank.entity.Credit

data class CreditViewList(
  val creditCode: UUID,
  val creditValue: BigDecimal,
  val numberOfInstallments: Int
) {
  constructor(credit: Credit) : this(
    creditCode = credit.creditCode,
    creditValue = credit.creditValue,
    numberOfInstallments = credit.numberOfInstallments
  )
}