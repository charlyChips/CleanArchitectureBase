package com.charlychips.cache.mappers

import com.charlychips.cache.models.CompanyDb
import com.charlychips.core.Transform
import com.charlychips.data.models.CompanyEntity

class CompanyDbMapper : Transform<CompanyEntity, CompanyDb>() {
    override fun transform(t: CompanyEntity): CompanyDb {
        return CompanyDb(
            t.name,
            t.slogan,
            t.business
        )
    }

}