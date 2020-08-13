package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.GeoEntity
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Geo

class AddressMapper(
    private val geoMapper: Transform<GeoEntity, Geo>
) : Transform<AddressEntity, Address>() {
    override fun transform(t: AddressEntity): Address {
        return Address(
            t.street,
            t.suite,
            t.city,
            t.zipCode,
            geoMapper.transform(t.geo)
        )
    }
}