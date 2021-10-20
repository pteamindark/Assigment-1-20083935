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

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> addHotel()
                2 -> updateHotel()
                3 -> listHotel()
                4 -> searchHotel()
                -1 -> println("Quiting the App")
                else -> println("Not recognized")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu(): Int {
        return hotelView.menu()
    }

    fun addHotel() {
        var hotel1 = hotelModel()

        if (hotelView.addHotelData(hotel1))
            hotels.make(hotel1)
        else
            logger.info("Placemark Not Added")
    }

    fun listHotel() {
        hotelView.listHotels(hotels)
    }

    fun updateHotel() {

        hotelView.listHotels(hotels)
        var findId = hotelView.fetchId()
        val hotel1 = searchId(findId)

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

    fun searchHotel() {
        val hotel1 = searchId(hotelView.fetchId())!!
        hotelView.showHotel(hotel1)
    }


    fun searchId(id: Long): hotelModel? {
        var foundHotel = hotels.findSingle(id)
        return foundHotel
    }
}
