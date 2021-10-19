package org.wit.hotel.console.main

import mu.KotlinLogging
import org.wit.hotel.console.models.hotelModel

private val logger= KotlinLogging.logger {}


val hotels= ArrayList<hotelModel>()


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
            4 -> hotelSearch()
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
    println(" 4. Search for the hotel")
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
    var hotel= hotelModel()

    println("Add Hotel")
    println()
    print(" Enter name of the Hotel:")
   hotel.name= readLine()!!
    print(" Please type description for the hotel:")
    hotel.description= readLine()!!
    print(" What types of room hotel has?:")
    hotel.roomType= readLine()!!
    print(" What is location of the hotel:")
    hotel.location= readLine()!!
    print(" Contact number for the hotel:")
    hotel.phoneNo= readLine()!!
   println("You have enter ["+ hotel.name +"] for a name of the hotel and ["+ hotel.description +"] for a description. Hotel has ["+ hotel.roomType +"] room types and location and phone number for the hotel are ["+ hotel.location +"], ["+ hotel.phoneNo +"]")

    if (hotel.name.isNotEmpty() && hotel.description.isNotEmpty() && hotel.roomType.isNotEmpty() && hotel.location.isNotEmpty()&& hotel.phoneNo.isNotEmpty()) {
        hotel.id=hotels.size.toLong()
        hotels.add(hotel.copy())
        logger.info("You added Hotel : [ $hotel ]")
    }
    else
        logger.info("Hotel is not added")

}

fun updateHotel(){
    println("Update Hotel details")
    println()
    listHotels()
    var Id= fetchId()
    val hotel=search(Id)

    if(hotel !=null) {
        print("Please put new name of the hotel [" + hotel.name + "]:")
        hotel.name = readLine()!!
        print("Please put new description of the hotel [" + hotel.description + "]:")
        hotel.description = readLine()!!
        print("Please put new room type of the hotel [" + hotel.roomType + "]:")
        hotel.roomType = readLine()!!
        print("Please put new location of the hotel [" + hotel.location + "]:")
        hotel.location = readLine()!!
        print("Please put new phone number of the hotel [" + hotel.phoneNo + "]:")
        hotel.phoneNo = readLine()!!
        println(
            "New changes are updated" + "Hotel name is [" + hotel.name
                    + "]" +
                    "Hotel description is [" + hotel.description + "] with new room types [" + hotel.roomType + "]" +
                    "New location and phone number are [" + hotel.location + "],[" + hotel.phoneNo + "]"
        )
    }
    else
        println("Hotel is not updated!!!")

}

fun listHotels(){
    println("Selected List All Hotels")
    println()
    hotels.forEach { logger.info("${it}") }
}

fun hotelSearch() {

    var lookForId = fetchId()
    val hotel1 = search(lookForId)

    if(hotel1 != null)
        println("Hotel Details [ $hotel1 ]")
    else
        println("We didnt find hotel")
}

fun fetchId() : Long {
    var stringID : String? // String to hold user input
    var catchID : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    stringID = readLine()!!
    catchID = if (stringID.toLongOrNull() != null && !stringID.isEmpty())
        stringID.toLong()
    else
        -9
    return catchID
}

fun search(id: Long) : hotelModel? {
    var hotelFind: hotelModel? = hotels.find { p -> p.id == id }
    return hotelFind
}

