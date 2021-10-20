package org.wit.hotel.console.main

import mu.KotlinLogging
import org.wit.hotel.console.models.HotelMemStore
import org.wit.hotel.console.models.hotelModel
import org.wit.hotel.console.views.HotelView

private val logger= KotlinLogging.logger {}


val hotels= HotelMemStore()
val hotelView = HotelView()


fun main(args: Array<String>){
    println("Hotel App")
    logger.info {"Starting Hotel Console"}

    var input: Int

    do {
        input = hotelView.menu()
        when(input) {
            1 -> addHotel()
            2 -> updateHotel()
            3 -> hotelView.listHotels(hotels)
            4 -> hotelSearch()
            -1 -> println("Quiting the App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Exiting Hotel Console" }
}



fun addHotel(){
    var hotel1= hotelModel()

    if (hotelView.addHotelData(hotel1))
        hotels.make(hotel1)
    else
        logger.info("Hotel is not added ")
}

fun updateHotel() {

    hotelView.listHotels(hotels)
    var catchID  = hotelView.fetchId()
    val hotel1 = search(catchID)

    if(hotel1 != null) {
        if(hotelView.updatingHotelData(hotel1)) {
            hotels.updateing(hotel1)
            hotelView.showHotel(hotel1)
            logger.info("Hotel is updated : [ $hotel1 ]")
        }
        else
            logger.info("Hotel is not updated")
    }
    else
        println("Hotel is not updated")

    }


fun hotelSearch() {


    val hotel1 = search(hotelView.fetchId())!!
    hotelView.showHotel(hotel1)

}

fun search(id: Long) : hotelModel? {
    var hotelFind = hotels.findSingle(id)
    return hotelFind
}

