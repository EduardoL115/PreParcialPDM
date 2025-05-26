package com.PreParcial.C00367123.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pet(
    val id: Int,
    val name: String,
    val type: String,
    val age: Int,
    val description: String,
    val imageUrl: String
) : Parcelable
