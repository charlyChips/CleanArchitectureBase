package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.GeoEntity
import com.charlychips.domain.models.Geo

class GeoEntityMapper : Transform<Geo, GeoEntity>() {
    override fun transform(t: Geo): GeoEntity {
        return GeoEntity(
            t.lat,
            t.lng
        )
    }
}