package com.charlychips.cache.mappers

import com.charlychips.cache.models.AddressDb
import com.charlychips.cache.models.CompanyDb
import com.charlychips.cache.models.UserDb
import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.UserEntity

class UserDbMapper(
    private val addressDbMapper: Transform<AddressEntity, AddressDb>,
    private val companyDbMapper: Transform<CompanyEntity, CompanyDb>
) : Transform<UserEntity, UserDb>() {
    override fun transform(t: UserEntity): UserDb {
        return UserDb(
            t.id,
            t.name,
            t.username,
            t.email,
            addressDbMapper.transform(t.address),
            t.phone,
            t.website,
            companyDbMapper.transform(t.company)
        )
    }
}