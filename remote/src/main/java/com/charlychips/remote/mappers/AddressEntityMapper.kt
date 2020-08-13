package com.charlychips.remote.mappers

import com.charlychips.core.Transform
import com.charlychips.core.value
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.GeoEntity
import com.charlychips.remote.models.AddressBean
import com.charlychips.remote.models.GeoBean

class AddressEntityMapper(
    private val geoMapper: Transform<GeoBean?, GeoEntity>
) : Transform<AddressBean?, AddressEntity>() {
    override fun transform(t: AddressBean?): AddressEntity {
        return AddressEntity(
            t?.street.value(),
            t?.suite.value(),
            t?.city.value(),
            t?.zipCode.value(),
            geoMapper.transform(t?.geo)
        )
    }

}