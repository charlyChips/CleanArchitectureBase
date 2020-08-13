package com.charlychips.cache.mappers

import com.charlychips.cache.models.CompanyDb
import com.charlychips.core.Transform
import com.charlychips.data.models.CompanyEntity

class CompanyEntityMapper : Transform<CompanyDb, CompanyEntity>() {
    override fun transform(t: CompanyDb): CompanyEntity {
        return CompanyEntity(
            t.name,
            t.slogan,
            t.business
        )
    }

}