package org.wit.hotel.console.controllers


import mu.KotlinLogging
import org.wit.hotel.console.models.HotelMemStore
import org.wit.hotel.console.models.hotelModel
import org.wit.hotel.console.views.HotelView

class HotelController {

    val hotels = HotelMemStore()
    val hotelView = HotelView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Starting Hotel App" }
        println("Hotel Kotlin app v1.0")
    }

    fun menu(): Int {
        return hotelView.menu()
    }

    fun add() {
        var hotel1 = hotelModel()

        if (hotelView.addHotelData(hotel1))
            hotels.make(hotel1)
        else
            logger.info("Placemark Not Added")
    }

    fun list() {
        hotelView.listHotels(hotels)
    }

    fun update() {

        hotelView.listHotels(hotels)
        var findId = hotelView.fetchId()
        val hotel1 = search(findId)

        if (hotel1 != null) {
            if (hotelView.updatingHotelData(hotel1)) {
                hotels.updateing(hotel1)
                hotelView.showHotel(hotel1)
                logger.info("Hotel is updated : [ $hotel1 ]")
            } else
                logger.info("Hotel is not updated")
        } else
            println("Hotel is not updated")
    }

    fun search() {
        val hotel1 = search(hotelView.fetchId())!!
        hotelView.showHotel(hotel1)
    }


    fun search(id: Long): hotelModel? {
        var foundHotel = hotels.findSingle(id)
        return foundHotel
    }
}
