package com.github.hotire.springbootkotlin.extensions

open class Animal {
    open fun name(): String = "anonymous"
}

class Dog : Animal() {
    override fun name(): String = "doggy"
}

fun Animal.howl(): String = "Animal"
fun Dog.howl(): String = "Dog"

fun Animal.className(): String = this.javaClass.name
fun Dog.className(): String = this.javaClass.name

fun printlnHowl(animal: Animal) {
    println(animal.howl())
}

fun printlnName(animal: Animal) {
    println(animal.name())
}

fun printlnClassName(animal: Animal) {
    println(animal.className())
}

fun main() {
    val animal = Animal()
    val dog = Dog()

    printlnHowl(animal)
    printlnHowl(dog)

    printlnName(animal)
    printlnName(dog)

    printlnClassName(animal)
    printlnClassName(dog)
}
