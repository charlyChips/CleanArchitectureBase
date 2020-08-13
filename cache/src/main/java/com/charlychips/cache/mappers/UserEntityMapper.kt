package com.charlychips.cache.mappers

import com.charlychips.cache.models.AddressDb
import com.charlychips.cache.models.CompanyDb
import com.charlychips.cache.models.UserDb
import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.UserEntity

class UserEntityMapper(
    private val addressEntityMapper: Transform<AddressDb, AddressEntity>,
    private val companyEntityMapper: Transform<CompanyDb, CompanyEntity>
) : Transform<UserDb, UserEntity>() {
    override fun transform(t: UserDb): UserEntity {
        return UserEntity(
            t.id,
            t.name,
            t.username,
            t.email,
            addressEntityMapper.transform(t.address),
            t.phone,
            t.website,
            companyEntityMapper.transform(t.company)
        )
    }

}