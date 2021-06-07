package com.github.hotire.springbootkotlin.sam

class SamSample {
    private var onClick: SamJavaOnClick? = null
    fun setSamJavaOnClick(onClick: SamJavaOnClick): SamSample = this.apply {
        this.onClick = onClick
    }
    fun click() : SamSample = this.apply { onClick?.onClick() }
}

fun main() {
    val samJavaSample = SamJavaSample()
    val samSample = SamSample()
    samJavaSample.setSamJavaOnClick {}
    samSample.setSamJavaOnClick {
        println("click")
    }.click().click()


}
