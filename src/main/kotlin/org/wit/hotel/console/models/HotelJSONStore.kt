package org.wit.hotel.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.hotel.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "hotels.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<hotelModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class HotelJSONStore : HotelStore {

    var hotels = mutableListOf<hotelModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findEverything(): MutableList<hotelModel> {
        return hotels
    }

    override fun findSingle(id: Long) : hotelModel? {
        var foundHotel: hotelModel? = hotels.find { p -> p.id == id }
        return foundHotel
    }

    override fun make(hotel: hotelModel) {
        hotel.id = generateRandomId()
        hotels.add(hotel)
        serialize()
    }

    override fun updateing(hotel: hotelModel) {
        var foundHotel = findSingle(hotel.id!!)
        if (foundHotel != null) {
            foundHotel.name = hotel.name
            foundHotel.description = hotel.description
            foundHotel.roomType = hotel.roomType
            foundHotel.location = hotel.location
            foundHotel.phoneNo = hotel.phoneNo
        }
        serialize()
    }

    override fun delete(hotel: hotelModel) {
        hotels.remove(hotel)
        serialize()
    }


    internal fun logAll() {
        hotels.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(hotels, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        hotels = Gson().fromJson(jsonString, listType)
    }
}