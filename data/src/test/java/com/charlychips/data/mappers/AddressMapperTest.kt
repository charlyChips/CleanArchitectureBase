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
class AddressMapperTest {

    @Mock
    private lateinit var geoMapper: Transform<GeoEntity, Geo>

    private val mapper by lazy {
        AddressMapper(
            geoMapper
        )
    }

    @Before
    fun before(){
        Mockito.`when`(geoMapper.transform(t = anyObject<GeoEntity>())).thenReturn(
            StubFactory.createGeo()
        )
    }

    @Test
    fun mapAddress() {
        val expectedValue = StubFactory.createAddressEntity()
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