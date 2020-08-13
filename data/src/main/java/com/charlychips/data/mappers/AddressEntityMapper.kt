package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.GeoEntity
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Geo

class AddressEntityMapper(private val geoMapper: Transform<Geo, GeoEntity>) :
    Transform<Address, AddressEntity>() {
    override fun transform(t: Address): AddressEntity {
        return AddressEntity(
            t.street,
            t.suite,
            t.city,
            t.zipCode,
            geoMapper.transform(t.geo)
        )
    }

}