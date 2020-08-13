package com.charlychips.cache.mappers

import com.charlychips.cache.models.AddressDb
import com.charlychips.cache.models.GeoDb
import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.GeoEntity

class AddressDbMapper(
    private val geoDbMapper: Transform<GeoEntity, GeoDb>
) : Transform<AddressEntity, AddressDb>() {
    override fun transform(t: AddressEntity): AddressDb {
        return AddressDb(
            t.street,
            t.suite,
            t.city,
            t.zipCode,
            geoDbMapper.transform(t.geo)
        )
    }

}