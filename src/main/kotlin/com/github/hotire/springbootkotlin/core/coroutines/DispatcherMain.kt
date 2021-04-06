package com.github.hotire.springbootkotlin.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

/**
 *  Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-androi
 */
suspend fun main() {

    CoroutineScope(Dispatchers.Main).async {
        println("Dispatchers.Main")
    }.await()
}
