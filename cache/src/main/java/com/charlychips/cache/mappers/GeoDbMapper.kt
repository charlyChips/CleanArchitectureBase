package com.charlychips.cache.mappers

import com.charlychips.cache.models.GeoDb
import com.charlychips.core.Transform
import com.charlychips.data.models.GeoEntity

class GeoDbMapper : Transform<GeoEntity, GeoDb>() {
    override fun transform(t: GeoEntity): GeoDb {
        return GeoDb(
            t.lat,
            t.lng
        )
    }

}