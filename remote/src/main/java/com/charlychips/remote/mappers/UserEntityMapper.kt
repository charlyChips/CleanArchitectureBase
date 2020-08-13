package com.charlychips.remote.mappers

import com.charlychips.core.Transform
import com.charlychips.core.value
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.UserEntity
import com.charlychips.remote.models.AddressBean
import com.charlychips.remote.models.CompanyBean
import com.charlychips.remote.models.UserBean

class UserEntityMapper(
    private val addressMapper: Transform<AddressBean?, AddressEntity>,
    private val companyMapper: Transform<CompanyBean?, CompanyEntity>
) : Transform<UserBean, UserEntity>() {
    override fun transform(t: UserBean): UserEntity {
        return UserEntity(
            t.id.value(),
            t.name.value(),
            t.username.value(),
            t.email.value(),
            addressMapper.transform(t.address),
            t.phone.value(),
            t.website.value(),
            companyMapper.transform(t.company)
        )
    }
}