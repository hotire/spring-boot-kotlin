package com.github.hotire.springbootkotlin.lateinit

interface Activity {
    fun onCreate()
}

class MainActivity : Activity {
    private lateinit var name: String
    override fun onCreate() {
        name = "main"
    }
}
