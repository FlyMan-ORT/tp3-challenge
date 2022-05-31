package com.example.basegrupo2.entities

import android.os.Parcel
import android.os.Parcelable

class User(name: String) : Parcelable {
    var dato: String

    init {
        this.dato = name
    }

    constructor(parcel: Parcel) : this(parcel.readString().toString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dato)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}