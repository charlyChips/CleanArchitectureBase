package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.UserEntity
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Company
import com.charlychips.domain.models.User

class UserMapper(
    private val addressMapper: Transform<AddressEntity, Address>,
    private val companyMapper: Transform<CompanyEntity, Company>
) : Transform<UserEntity, User>() {
    override fun transform(t: UserEntity): User {
        return User(
            t.id,
            t.name,
            t.username,
            t.email,
            addressMapper.transform(t.address),
            t.phone,
            t.website,
            companyMapper.transform(t.company)
        )
    }

}