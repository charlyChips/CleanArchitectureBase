package com.charlychips.data.mappers

import com.charlychips.data.stubs.StubFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(value = MockitoJUnitRunner::class)
class CompanyMapperTest {

    private val mapper by lazy {
        CompanyMapper()
    }

    @Test
    fun mapCompanyEntity() {
        val expectedValue = StubFactory.createCompanyEntity()

        val actualValue = mapper.transform(expectedValue)

        Assert.assertEquals(expectedValue.name, actualValue.name)
        Assert.assertEquals(expectedValue.slogan, actualValue.slogan)
        Assert.assertEquals(expectedValue.business, actualValue.business)
    }
}