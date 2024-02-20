package com.credit.api.system.service

import com.credit.api.system.entity.Address
import com.credit.api.system.repository.CustomerRepository
import com.credit.api.system.service.impl.CustomerService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal
import com.credit.api.system.entity.Custumer
import io.mockk.verify

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `_should create customer`(){
        //given
        val fakeCustomer: Custumer = buildCustomer()
        every { customerRepository.save(any()) } returns fakeCustomer

        //when
        val actual: Custumer = customerService.save(fakeCustomer)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isSameAs(fakeCustomer)

    }

    private fun buildCustomer(
        firstName: String = "Bruno",
        lastName: String = "Paulin",
        cpf: String = "05124666960",
        income: BigDecimal = BigDecimal.valueOf(10000.0),
        email: String = "bruno.p-@hotmail.com",
        zipCode: String = "123456",
        street: String = "R. A. Lucca",
        id: Long = 1L
    ) = Custumer(
        firstName = firstName,
        lastName= lastName,
        cpf = cpf,
        income= income,
        email = email,
        address = Address(
            zipCode  = zipCode,
            street  = street,
        ),
        id = id
    )
}
