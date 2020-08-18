package com.charlychips.myapplication.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.charlychips.cache.UserDataCache
import com.charlychips.cache.db.AppRoomDatabase
import com.charlychips.cache.mappers.*
import com.charlychips.cache.models.AddressDb
import com.charlychips.cache.models.CompanyDb
import com.charlychips.cache.models.GeoDb
import com.charlychips.cache.models.UserDb
import com.charlychips.core.Transform
import com.charlychips.data.UsersDataRepository
import com.charlychips.data.mappers.AddressMapper
import com.charlychips.data.mappers.CompanyMapper
import com.charlychips.data.mappers.GeoMapper
import com.charlychips.data.mappers.UserMapper
import com.charlychips.data.models.AddressEntity
import com.charlychips.data.models.CompanyEntity
import com.charlychips.data.models.GeoEntity
import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore
import com.charlychips.data.repository.UserRemote
import com.charlychips.data.source.UserCacheDataStore
import com.charlychips.data.source.UserDataStoreFactory
import com.charlychips.data.source.UserRemoteDataStore
import com.charlychips.domain.models.Address
import com.charlychips.domain.models.Company
import com.charlychips.domain.models.Geo
import com.charlychips.domain.models.User
import com.charlychips.domain.repository.UsersRepository
import com.charlychips.remote.ApiFactory
import com.charlychips.remote.UserApi
import com.charlychips.remote.UserDataRemote
import com.charlychips.remote.models.AddressBean
import com.charlychips.remote.models.CompanyBean
import com.charlychips.remote.models.GeoBean
import com.charlychips.remote.models.UserBean
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mappersModule = module {

    factory<Transform<GeoDb, GeoEntity>>(named<GeoEntityMapper>()) { GeoEntityMapper() }
    factory<Transform<AddressDb, AddressEntity>>(named<AddressEntityMapper>()) {
        AddressEntityMapper(
            get(named<GeoEntityMapper>())
        )
    }
    factory<Transform<CompanyDb, CompanyEntity>>(named<CompanyEntityMapper>()) { CompanyEntityMapper() }
    factory<Transform<UserDb, UserEntity>>(named<UserEntityMapper>()) {
        UserEntityMapper(
            get(named<AddressEntityMapper>()),
            get(named<CompanyEntityMapper>())
        )
    }

    factory<Transform<GeoEntity, GeoDb>>(named<GeoDbMapper>()) { GeoDbMapper() }
    factory<Transform<AddressEntity, AddressDb>>(named<AddressDbMapper>()) {
        AddressDbMapper(
            get(named<GeoDbMapper>())
        )
    }
    factory<Transform<CompanyEntity, CompanyDb>>(named<CompanyDbMapper>()) { CompanyDbMapper() }
    factory<Transform<UserEntity, UserDb>>(named<UserDbMapper>()) {
        UserDbMapper(
            get(named<AddressDbMapper>()),
            get(named<CompanyDbMapper>())
        )
    }

    factory<Transform<GeoBean?, GeoEntity>>(named<com.charlychips.remote.mappers.GeoEntityMapper>()) {
        com.charlychips.remote.mappers.GeoEntityMapper()
    }
    factory<Transform<AddressBean?, AddressEntity>>(named<com.charlychips.remote.mappers.AddressEntityMapper>()) {
        com.charlychips.remote.mappers.AddressEntityMapper(
            get(named<com.charlychips.remote.mappers.GeoEntityMapper>())
        )
    }
    factory<Transform<CompanyBean?, CompanyEntity>>(named<com.charlychips.remote.mappers.CompanyEntityMapper>()) { com.charlychips.remote.mappers.CompanyEntityMapper() }
    factory<Transform<UserBean, UserEntity>>(named<com.charlychips.remote.mappers.UserEntityMapper>()) {
        com.charlychips.remote.mappers.UserEntityMapper(
            get(named<com.charlychips.remote.mappers.AddressEntityMapper>()),
            get(named<com.charlychips.remote.mappers.CompanyEntityMapper>())
        )
    }

    factory<Transform<CompanyEntity, Company>>(named<CompanyMapper>()) { CompanyMapper() }
    factory<Transform<GeoEntity, Geo>>(named<GeoMapper>()) { GeoMapper() }
    factory<Transform<AddressEntity, Address>>(named<AddressMapper>()) {
        AddressMapper(
            get(
                named<GeoMapper>()
            )
        )
    }
    factory<Transform<UserEntity, User>>(named<UserMapper>()) {
        UserMapper(
            get(named<AddressMapper>()),
            get(named<CompanyMapper>())
        )
    }

    factory<Transform<Company, CompanyEntity>>(named<com.charlychips.data.mappers.CompanyEntityMapper>()) {
        com.charlychips.data.mappers.CompanyEntityMapper()
    }
    factory<Transform<Geo, GeoEntity>>(named<com.charlychips.data.mappers.GeoEntityMapper>()) {
        com.charlychips.data.mappers.GeoEntityMapper()
    }
    factory<Transform<Address, AddressEntity>>(named<com.charlychips.data.mappers.AddressEntityMapper>()) {
        com.charlychips.data.mappers.AddressEntityMapper(
            get(named<com.charlychips.data.mappers.GeoEntityMapper>())
        )
    }
    factory<Transform<User, UserEntity>>(named<com.charlychips.data.mappers.UserEntityMapper>()) {
        com.charlychips.data.mappers.UserEntityMapper(
            get(named<com.charlychips.data.mappers.AddressEntityMapper>()),
            get(named<com.charlychips.data.mappers.CompanyEntityMapper>())
        )
    }

}

val cacheModule = module {
    single(createdAtStart = true) { AppRoomDatabase.getIntance(get()) }
    single(createdAtStart = true) { provideSharedPrefs(get()) }

    single<UserCache> {
        UserDataCache(get(), get(), get(named<UserDbMapper>()), get(named<UserEntityMapper>()))
    }
    single<UserDataStore>(named<UserCacheDataStore>()) { UserCacheDataStore(get()) }
}

val remoteModule = module {
    //USER API
    single {
        ApiFactory.provideRetrofitApi<UserApi>(
            "https://jsonplaceholder.typicode.com/",
            ApiFactory.provideOkHttpClient()
        )
    }
    single<UserRemote> {
        UserDataRemote(
            get(),
            get(named<com.charlychips.remote.mappers.UserEntityMapper>())
        )
    }
    single<UserDataStore>(named<UserRemoteDataStore>()) { UserRemoteDataStore(get(), get()) }
}


private fun provideSharedPrefs(application: Application): SharedPreferences {
    return application.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
}

val repositoryModule = module {
    single<UsersRepository> {
        UsersDataRepository(
            UserDataStoreFactory(
                get(),
                get(named<UserCacheDataStore>()),
                get(named<UserRemoteDataStore>())
            ), get(named<UserMapper>()),
            get(named<com.charlychips.data.mappers.UserEntityMapper>())
        )
    }
}