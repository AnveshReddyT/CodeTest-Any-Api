package com.anveshreddyt.fifththirdcodetest.retrofit

import com.anveshreddyt.fifththirdcodetest.model.ServicesSetterGetter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("current")
    fun getServices(@Query("access_key") access_key: String,@Query("query") uid: String) : Call<ResponseBody>
}