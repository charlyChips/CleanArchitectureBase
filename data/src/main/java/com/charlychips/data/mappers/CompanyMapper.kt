package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.CompanyEntity
import com.charlychips.domain.models.Company

class CompanyMapper : Transform<CompanyEntity, Company>() {
    override fun transform(t: CompanyEntity): Company {
        return Company(
            t.name,
            t.slogan,
            t.business
        )
    }
}