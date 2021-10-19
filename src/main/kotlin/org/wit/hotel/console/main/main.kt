package org.wit.hotel.console.main

import mu.KotlinLogging

private val logger= KotlinLogging.logger {}

fun main(args: Array<String>){
    println("Hotel App")
    logger.info {"Starting Hotel Console"}

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addHotel()
            2 -> updateHotel()
            3 -> listHotels()
            -1 -> println("Quiting the App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Exiting Hotel Console" }
}

fun menu() : Int {

    var menuoption : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Hotel")
    println(" 1. Update Hotel info")
    println(" 1. List All Hotels")
    println("-1. Exit")
    println()
    print("Enter Menu Number : ")
    input = readLine()!!
    menuoption = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return menuoption
}

fun addHotel(){
    println("Selected Add Hotel")
}

fun updateHotel(){
    println("Selected Update Hotel")
}

fun listHotels(){
    println("Selected List All Hotels")
}