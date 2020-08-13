package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.GeoEntity
import com.charlychips.domain.models.Geo

class GeoMapper : Transform<GeoEntity, Geo>() {
    override fun transform(t: GeoEntity): Geo {
        return Geo(t.lat, t.lng)
    }
}