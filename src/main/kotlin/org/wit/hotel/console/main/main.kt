package org.wit.hotel.console.main

import mu.KotlinLogging
import org.wit.hotel.console.models.HotelMemStore
import org.wit.hotel.console.models.hotelModel
import org.wit.hotel.console.views.HotelView
import org.wit.hotel.console.controllers.HotelController
private val logger= KotlinLogging.logger {}


val hotels = HotelMemStore()
val hotelView = HotelView()
val controller = HotelController()

fun main(args: Array<String>) {
HotelController().start()
}



