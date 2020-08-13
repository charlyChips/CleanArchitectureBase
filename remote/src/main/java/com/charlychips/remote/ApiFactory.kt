package com.charlychips.remote

import com.charlychips.remote.constants.ApiConstants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    fun provideOkHttpClient(): OkHttpClient {
        val interceptorLogger = HttpLoggingInterceptor()
        interceptorLogger.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(ApiConstants.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(ApiConstants.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(ApiConstants.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptorLogger)
            .build()
    }


    inline fun <reified T> provideRetrofitApi(
        urlBase: String,
        okHttpClient: OkHttpClient
    ): T {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .serializeNulls()
                        .create()
                )
            )
            .client(okHttpClient)
            .baseUrl(urlBase)
            .build()
            .create(T::class.java)
    }
}