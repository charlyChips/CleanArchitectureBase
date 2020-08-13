package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.CompanyEntity
import com.charlychips.domain.models.Company

class CompanyEntityMapper : Transform<Company, CompanyEntity>() {
    override fun transform(t: Company): CompanyEntity {
        return CompanyEntity(
            t.name,
            t.slogan,
            t.business
        )
    }
}