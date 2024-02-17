package com.credit.api.system.controler

import com.credit.api.system.dto.CreditDto
import com.credit.api.system.dto.CreditView
import com.credit.api.system.dto.CreditViewList
import com.credit.api.system.entity.Credit
import com.credit.api.system.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditControler(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return  ResponseEntity.status(HttpStatus.CREATED).body(
            "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
         val collect: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream().map {
             credit: Credit -> CreditViewList(credit)
         }.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(collect)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID): ResponseEntity<CreditView> {
        val credit: Credit =  this.creditService.findByCreditCode(creditCode, customerId)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }

}