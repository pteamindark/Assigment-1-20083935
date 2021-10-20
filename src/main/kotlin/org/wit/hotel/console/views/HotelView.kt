package org.wit.hotel.console.views

import org.wit.hotel.console.main.hotelView
import org.wit.hotel.console.main.hotels
import org.wit.hotel.console.models.HotelMemStore
import org.wit.hotel.console.models.hotelModel

class HotelView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add a hotel")
        println(" 2. Update existing hotel")
        println(" 3. List hotels")
        println(" 4. Search for a hotel")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listHotels(placemarks : HotelMemStore) {
        println("List hotels")
        println()
        placemarks.logAll()
        println()
    }

    fun showHotel(hotel : hotelModel) {
        if(hotel != null)
            println("Hotel details are: [ $hotel ]")
        else
            println("Hotel is not found.")
    }

    fun addHotelData(hotel : hotelModel) : Boolean {

        println()
        print("Please Enter name of the hotel : ")
        hotel.name = readLine()!!
        print("Enter the description for the hotel : ")
        hotel.description = readLine()!!

        return hotel.name.isNotEmpty() && hotel.description.isNotEmpty() && hotel.roomType.isNotEmpty() && hotel.location.isNotEmpty() && hotel.phoneNo.isNotEmpty()
    }

    fun updatingHotelData(hotel : hotelModel) : Boolean {

        var tempName: String?
        var tempDescription: String?
        var tempRoomtype: String?
        var tempLocation: String?
        var tempPhoneNo: String?


        if (hotel != null) {
            print("Enter a new Title for [ " + hotel.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Description for [ " + hotel.description + " ] : ")
            tempDescription = readLine()!!
            print("What type of room is in hotel: [ " + hotel.roomType + " ] : ")
            tempRoomtype = readLine()!!
            print("What is location [ " + hotel.location + " ] : ")
            tempLocation = readLine()!!
            print("Phone number for hotel is?:  [ " + hotel.phoneNo + " ] : ")
            tempPhoneNo = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempDescription.isNullOrEmpty() && !tempRoomtype.isNullOrEmpty() && !tempLocation.isNullOrEmpty() && !tempPhoneNo.isNullOrEmpty()) {
                hotel.name = tempName
                hotel.description = tempDescription
                hotel.roomType = tempRoomtype
                hotel.location = tempLocation
                hotel.phoneNo = tempPhoneNo
                return true
            }
        }
        return false
    }

    fun fetchId() : Long {
        var stringID : String? // String to hold user input
        var catchID  : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        stringID = readLine()!!
        catchID  = if (stringID.toLongOrNull() != null && !stringID.isEmpty())
            stringID.toLong()
        else
            -9
        return catchID
    }
}