package com.anveshreddyt.fifththirdcodetest.model

import com.google.gson.JsonObject
import com.google.gson.JsonParser

class WeatherDAO (json: String) {
    var parser: JsonParser = JsonParser()
    private var jsonObject = parser.parse(json) as JsonObject
    var currentWeather = jsonObject.getAsJsonObject("current").getAsJsonPrimitive("temperature").toString()

}