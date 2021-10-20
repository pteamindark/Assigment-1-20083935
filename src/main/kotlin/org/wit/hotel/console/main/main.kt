package org.wit.hotel.console.main

import mu.KotlinLogging
import org.wit.hotel.console.models.HotelMemStore
import org.wit.hotel.console.models.hotelModel
import org.wit.hotel.console.views.HotelView
import org.wit.hotel.console.controllers.HotelController
private val logger= KotlinLogging.logger {}



val hotelView = HotelView()
val controller = HotelController()

fun main(args: Array<String>){
    println("Hotel App")
    logger.info {"Starting Hotel Console"}

    var input: Int

    do {
        input = hotelView.menu()
        when(input) {
            1 -> controller.addHotel()
            2 -> controller.updateHotel()
            3 -> controller.listHotel()
            4 -> controller.searchHotel()
            -1 -> println("Quiting the App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Exiting Hotel Console" }
}



