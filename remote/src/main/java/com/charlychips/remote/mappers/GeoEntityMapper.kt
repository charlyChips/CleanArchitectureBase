package com.charlychips.remote.mappers

import com.charlychips.core.Transform
import com.charlychips.core.value
import com.charlychips.data.models.GeoEntity
import com.charlychips.remote.models.GeoBean

class GeoEntityMapper : Transform<GeoBean?, GeoEntity>() {
    override fun transform(t: GeoBean?): GeoEntity {
        return GeoEntity(
            t?.lat?.toDoubleOrNull().value(),
            t?.lng?.toDoubleOrNull().value()
        )
    }

}