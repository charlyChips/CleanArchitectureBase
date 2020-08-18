package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.stubs.StubFactory
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Company
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserEntityMapperTest {

    @Mock
    private lateinit var addressMapper: Transform<Address, AddressEntity>

    @Mock
    private lateinit var companyMapper: Transform<Company, CompanyEntity>

    private val userMapper by lazy {
        UserEntityMapper(
            addressMapper,
            companyMapper
        )
    }

    @Before
    fun before() {

        Mockito.`when`(addressMapper.transform(anyObject<Address>())).thenReturn(
            StubFactory.createAddressEntity()
        )

        Mockito.`when`(companyMapper.transform(anyObject<Company>())).thenReturn(
            StubFactory.createCompanyEntity()
        )
    }

    @Test
    fun mapUser() {

        val expectedValue = StubFactory.createUser()
        val actualValue = userMapper.transform(expectedValue)

        Assert.assertEquals(expectedValue.id, actualValue.id)
        Assert.assertEquals(expectedValue.name, actualValue.name)
        Assert.assertEquals(expectedValue.phone, actualValue.phone)
        Assert.assertEquals(expectedValue.email, actualValue.email)
        Assert.assertEquals(expectedValue.username, actualValue.username)
        Assert.assertEquals(expectedValue.website, actualValue.website)
        Assert.assertEquals(expectedValue.address.street, actualValue.address.street)
        Assert.assertEquals(expectedValue.address.zipCode, actualValue.address.zipCode)
        Assert.assertEquals(expectedValue.address.city, actualValue.address.city)
        Assert.assertEquals(expectedValue.address.suite, actualValue.address.suite)
        Assert.assertTrue(expectedValue.address.geo.lat == actualValue.address.geo.lat)
        Assert.assertTrue(expectedValue.address.geo.lng == actualValue.address.geo.lng)
        Assert.assertEquals(expectedValue.company.name, actualValue.company.name)
        Assert.assertEquals(expectedValue.company.business, actualValue.company.business)
        Assert.assertEquals(expectedValue.company.slogan, actualValue.company.slogan)
    }

    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }
}