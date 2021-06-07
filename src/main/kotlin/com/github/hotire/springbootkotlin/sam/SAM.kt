package com.github.hotire.springbootkotlin.sam

class SamSample {
    private var onClick: SamJavaOnClick? = null
    private var onClickKt: SamOnclick? = null
    fun setSamJavaOnClick(onClick: SamJavaOnClick): SamSample = this.apply {
        this.onClick = onClick
    }
    fun setSamOnclick(onClickKt: SamOnclick): SamSample = this.apply { this.onClickKt = onClickKt }

    fun click(): SamSample = this.apply { onClick?.onClick() }
}

interface SamOnclick {
    @JvmDefault
    fun onClick() = Unit
}

fun main() {
    val samJavaSample = SamJavaSample()
    val samSample = SamSample()
    samJavaSample.setSamJavaOnClick {}
    samSample.setSamJavaOnClick {
        println("click")
    }.click().click()

//    samSample.setSamOnclick {}  // error
}
