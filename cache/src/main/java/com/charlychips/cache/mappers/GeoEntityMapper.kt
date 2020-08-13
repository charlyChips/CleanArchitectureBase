package com.charlychips.cache.mappers

import com.charlychips.cache.models.GeoDb
import com.charlychips.core.Transform
import com.charlychips.data.models.GeoEntity

class GeoEntityMapper : Transform<GeoDb, GeoEntity>() {
    override fun transform(t: GeoDb): GeoEntity {
        return GeoEntity(
            t.lat,
            t.lng
        )
    }

}