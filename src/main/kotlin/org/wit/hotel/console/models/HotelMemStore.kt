package org.wit.hotel.console.models

import mu.KotlinLogging

    private val logger = KotlinLogging.logger {}
    var finalID = 0L

    internal fun fetchId(): Long {
        return finalID++
    }

    class HotelMemStore : HotelStore {

        val hotels = ArrayList<hotelModel>()

        override fun findEverything(): List<hotelModel> {
            return hotels
        }

        override fun findSingle(id: Long) : hotelModel? {
            var hotelFound: hotelModel? = hotels.find { p -> p.id == id }
            return hotelFound
        }

        override fun make(hotel: hotelModel) {
            hotel.id = fetchId()
            hotels.add(hotel)
            logAll()
        }

        override fun updateing(hotel: hotelModel) {
            var hotelFound = findSingle(hotel.id!!)
            if (hotelFound != null) {
                hotelFound.name = hotel.name
                hotelFound.description = hotel.description
                hotelFound.roomType = hotel.roomType
                hotelFound.location = hotel.location
                hotelFound.phoneNo = hotel.phoneNo
            }
        }

        override fun delete(hotel: hotelModel) {
            hotels.remove(hotel)
        }


        internal fun logAll() {
            hotels.forEach { logger.info("${it}") }
        }
    }

