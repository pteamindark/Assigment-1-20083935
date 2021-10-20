package org.wit.hotel.console.models

interface HotelStore {

    fun findEverything(): List<hotelModel>
    fun findSingle(id: Long): hotelModel?
    fun make(hotel: hotelModel)
    fun updateing(hotel: hotelModel)


}