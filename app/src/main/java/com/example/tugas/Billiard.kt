package com.example.tugas

import com.google.firebase.database.Exclude

data class Billiard(
    var name:String? = null,
    var imageUrl:String? = null,
    var description:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null
)