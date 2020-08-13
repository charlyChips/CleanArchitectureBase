package com.charlychips.cache.mappers

import com.charlychips.cache.models.AddressDb
import com.charlychips.cache.models.GeoDb
import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.GeoEntity

class AddressEntityMapper(
    private val geoEntityMapper: Transform<GeoDb, GeoEntity>
) : Transform<AddressDb, AddressEntity>() {
    override fun transform(t: AddressDb): AddressEntity {
        return AddressEntity(
            t.street,
            t.suite,
            t.city,
            t.zipCode,
            geoEntityMapper.transform(t.geo)
        )
    }

}