package com.charlychips.data.mappers

import com.charlychips.data.stubs.StubFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompanyMapperEntityTest {

    private val mapper by lazy {
        CompanyEntityMapper()
    }

    @Test
    fun mapCompany() {
        val expectedValue = StubFactory.createCompany()

        val actualValue = mapper.transform(expectedValue)

        Assert.assertEquals(expectedValue.name, actualValue.name)
        Assert.assertEquals(expectedValue.business, actualValue.business)
        Assert.assertEquals(expectedValue.slogan, actualValue.slogan)
    }
}