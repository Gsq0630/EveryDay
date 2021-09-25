package com.example.everyday

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class User() : Parcelable {

  var name : String = ""
  var age : Int = 0

  constructor(parcel: Parcel) : this() {
    name = parcel.readString().toString()
    age = parcel.readInt()
  }


  override fun describeContents(): Int {
    return 0
  }

  override fun toString(): String {
    return "[name = $name age =$age]"
  }

  override fun writeToParcel(dest: Parcel?, flags: Int) {
    dest ?: return
    dest.writeString(name)
    dest.writeInt(age)
  }

  companion object CREATOR : Creator<User> {
    override fun createFromParcel(parcel: Parcel): User {
      return User(parcel)
    }

    override fun newArray(size: Int): Array<User?> {
      return arrayOfNulls(size)
    }
  }
}