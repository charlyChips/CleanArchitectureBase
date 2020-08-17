package com.charlychips.cache.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDb(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    @Embedded(prefix = "address_")
    var address: AddressDb,
    var phone: String,
    var website: String,
    @Embedded(prefix = "company_")
    var company: CompanyDb
)