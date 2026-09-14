package com.example.myapplication

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Halo Regina Cahyani Puteri\nNIM: 124140063\nPlatform: ${platform.name}"
    }
}