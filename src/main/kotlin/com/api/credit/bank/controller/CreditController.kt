package com.api.credit.bank.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

import com.api.credit.bank.dto.request.CreditDto
import com.api.credit.bank.dto.response.CreditView
import com.api.credit.bank.entity.Credit
import com.api.credit.bank.service.impl.CreditService
import CreditViewList

@RestController
@RequestMapping("/api/credits")
class CreditController(
  private val creditService: CreditService
) {

  @PostMapping
  fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
    val credit: Credit = this.creditService.save(creditDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED)
      .body("Credit ${credit.creditCode} - Customer ${credit.customer?.email} saved!")
  }

  @GetMapping
  fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long):
      ResponseEntity<List<CreditViewList>> {
    val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId)
      .stream()
      .map { credit: Credit -> CreditViewList(credit) }
      .collect(Collectors.toList())
    return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
  }

  @GetMapping("/{creditCode}")
  fun findByCreditCode(
    @RequestParam(value = "customerId") customerId: Long,
    @PathVariable creditCode: UUID
  ): ResponseEntity<CreditView> {
    val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
    return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
  }
}