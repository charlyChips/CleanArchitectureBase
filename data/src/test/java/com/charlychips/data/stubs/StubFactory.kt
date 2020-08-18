package com.charlychips.data.stubs

import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.GeoEntity
import com.charlychips.data.models.UserEntity
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Company
import com.charlychips.domain.models.Geo
import com.charlychips.domain.models.User

object StubFactory {

    fun createUser(): User {
        return User(
            1,
            "Name",
            "UserName",
            "Email",
            createAddress(),
            "5512345678",
            "WEBSITE",
            createCompany()
        )
    }

    fun createAddress(): Address {
        return Address(
            "Street",
            "Suite",
            "City",
            "ZipCode",
            createGeo()
        )

    }

    fun createGeo(): Geo {
        return Geo(
            1.234567,
            1.234556
        )
    }

    fun createCompany(): Company {
        return Company(
            "CompanyName",
            "CompanySlogan",
            "CompanyBusiness"
        )
    }


    fun createUserEntity(): UserEntity {
        return UserEntity(
            1,
            "Name",
            "UserName",
            "Email",
            createAddressEntity(),
            "5512345678",
            "WEBSITE",
            createCompanyEntity()
        )
    }

    fun createAddressEntity(): AddressEntity {
        return AddressEntity(
            "Street",
            "Suite",
            "City",
            "ZipCode",
            createGeoEntity()
        )

    }

    fun createGeoEntity(): GeoEntity {
        return GeoEntity(
            1.234567,
            1.234556
        )
    }

    fun createCompanyEntity(): CompanyEntity {
        return CompanyEntity(
            "CompanyName",
            "CompanySlogan",
            "CompanyBusiness"
        )
    }

    fun createUserEntityList(): List<UserEntity> {
        return listOf(
            UserEntity(
                1,
                "User1",
                "UserName1",
                "Email1",
                createAddressEntity(),
                "Phone1",
                "Website1",
                createCompanyEntity()
            ),

            UserEntity(
                2,
                "User2",
                "UserName2",
                "Email2",
                createAddressEntity(),
                "Phone2",
                "Website2",
                createCompanyEntity()
            )

        )
    }

}