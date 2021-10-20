package org.wit.hotel.console.models

interface HotelStore {

    fun findAll(): List<hotelModel>
    fun findOne(id: Long): hotelModel?
    fun make(hotel: hotelModel)
    fun updateing(hotel: hotelModel)


}