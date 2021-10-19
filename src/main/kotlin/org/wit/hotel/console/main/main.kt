package org.wit.hotel.console.main

import mu.KotlinLogging

private val logger= KotlinLogging.logger {}

var name=""
var description=""
var roomType=""
var location=""
var phoneNo=""

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
    println(" 2. Update Hotel info")
    println(" 3. List All Hotels")
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

    println("Add Hotel")
    println()
    print(" Enter name of the Hotel:")
    name= readLine()!!
    print(" Please type description for the hotel:")
    description= readLine()!!
    print(" What types of room hotel has?:")
    roomType= readLine()!!
    print(" What is location of the hotel:")
    location= readLine()!!
    print(" Contact number for the hotel:")
    phoneNo= readLine()!!
   println("You have enter [$name] fora a name of the hotel and [$description] for a description. Hotel has [$roomType] room types and location and phone number for the hotel are [$location], [$phoneNo]")
}

fun updateHotel(){
    println("Update Hotel details")
    println()
    print("Please put new name of the hotel [$name]:")
    name= readLine()!!
    print("Please put new description of the hotel [$description]:")
    description= readLine()!!
    print("Please put new room type of the hotel [$roomType]:")
    roomType= readLine()!!
    print("Please put new location of the hotel [$location]:")
    location= readLine()!!
    print("Please put new phone number of the hotel [$phoneNo]:")
    phoneNo= readLine()!!
    println("New changes are updated"+"Hotel name is [$name]"+
            "Hotel description is [$description] with new room types [$roomType]"+
            "New location and phone number are [$location],[$phoneNo]")

}

fun listHotels(){
    println("Selected List All Hotels")
}