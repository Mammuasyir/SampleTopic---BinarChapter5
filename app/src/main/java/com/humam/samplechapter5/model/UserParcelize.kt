package com.humam.samplechapter5.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class UserParcelize(
    var name: String,
    var gender : String,
): Parcelable