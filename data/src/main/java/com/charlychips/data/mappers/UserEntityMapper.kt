package com.charlychips.data.mappers

import com.charlychips.core.Transform
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.UserEntity
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Company
import com.charlychips.domain.models.User

class UserEntityMapper(
    private val addressMapper: Transform<Address, AddressEntity>,
    private val companyMapper: Transform<Company, CompanyEntity>
) : Transform<User, UserEntity>() {
    override fun transform(t: User): UserEntity {
        return UserEntity(
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