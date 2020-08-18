package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.GeoEntity
import com.charlychips.data.stubs.StubFactory
import com.charlychips.domain.models.Geo
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddressEntityMapperTest {

    @Mock
    private lateinit var geoMapper: Transform<Geo, GeoEntity>

    private val mapper by lazy {
        AddressEntityMapper(geoMapper)
    }

    @Before
    fun before() {
        Mockito.`when`(geoMapper.transform(t = anyObject())).thenReturn(
            StubFactory.createGeoEntity()
        )
    }

    @Test
    fun mapAddressEntity() {
        val expectedValue = StubFactory.createAddress()
        val actualValue = mapper.transform(expectedValue)

        Assert.assertEquals(expectedValue.street, actualValue.street)
        Assert.assertEquals(expectedValue.city, actualValue.city)
        Assert.assertEquals(expectedValue.suite, actualValue.suite)
        Assert.assertEquals(expectedValue.zipCode, actualValue.zipCode)
        Assert.assertTrue(expectedValue.geo.lat == actualValue.geo.lat)
        Assert.assertTrue(expectedValue.geo.lng == actualValue.geo.lng)

    }

    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }
}