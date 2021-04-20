package com.github.hotire.springbootkotlin.extensions

open class Animal {
    open fun name(): String = "anonymous"
}

class Dog : Animal() {
    override fun name() = "doggy"
}

fun Animal.howl() = "Animal"
fun Dog.howl() = "Dog"

fun action(animal: Animal, action: (Animal) -> Unit) {
    action(animal)
}

fun main() {
    val animal = Animal()
    val dog = Dog()

    action(animal) { println(it.name()) }
    action(dog) { println(it.name()) }

    action(animal) { println(it.howl()) }
    action(dog) { println(it.howl()) }
}
