package com.charlychips.remote.mappers

import com.charlychips.core.Transform
import com.charlychips.core.value
import com.charlychips.data.models.CompanyEntity
import com.charlychips.remote.models.CompanyBean

class CompanyEntityMapper : Transform<CompanyBean?, CompanyEntity>() {
    override fun transform(t: CompanyBean?): CompanyEntity {
        return CompanyEntity(
            t?.name.value(),
            t?.slogan.value(),
            t?.business.value()
        )
    }
}