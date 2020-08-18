package com.charlychips.data.mappers

import com.charlychips.data.stubs.StubFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GeoMapperTest {

    private val mapper by lazy {
        GeoMapper()
    }

    @Test
    fun mapGeo() {
        val expectedValue = StubFactory.createGeoEntity()
        val actualValue = mapper.transform(expectedValue)

        Assert.assertTrue(expectedValue.lat == actualValue.lat)
        Assert.assertTrue(expectedValue.lng == actualValue.lng)

    }
}