package com.anveshreddyt.fifththirdcodetest.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anveshreddyt.fifththirdcodetest.model.ServicesSetterGetter
import com.anveshreddyt.fifththirdcodetest.model.WeatherDAO
import com.anveshreddyt.fifththirdcodetest.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(tag: Any): MutableLiveData<ServicesSetterGetter> {

        val accessKey = "28c5b6f293fcb0d847f41760e6a1a5b2"
        val call = RetrofitClient.apiInterface.getServices(
            accessKey,
            tag as String
        )

        call.enqueue(object: Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                var weatherDao= response.body()?.let { WeatherDAO(it.string()) }
                if (weatherDao != null) {
                   serviceSetterGetter.value = ServicesSetterGetter(weatherDao.currentWeather)
                }
            }
        })

        return serviceSetterGetter
    }
}