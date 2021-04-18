# Interview

## inline

## statement vs expression

## let, apply, run, with

## const and val

## 확장 함수

## kotlin SAM(Single Abstract Method)

## coroutine

## suspending vs blocking

https://medium.com/mobile-app-development-publication/understanding-suspend-function-of-coroutines-de26b070c5ed

## Kotlin의 프로퍼티 위임과 초기화 지연은 어떻게 동작하는가
https://medium.com/til-kotlin-ko/kotlin-delegated-property-by-lazy%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80-74912d3e9c56

- Non-null & read-only 프로퍼티의 딜레마

val은 선언과 동시에 값을 가져야 하므로, 초기화를 수행하는 위치를 정의할 수 없다.

~~~kotlin
class Delegate {
    operator fun getValue(
            thisRef: Any?,
            property: KProperty<*>
    ): String {
        // return value
    }
    operator fun setValue(
            thisRef: Any?,
            property: KProperty<*>, value: String
    ) {
        // assign
    }
}
~~~

- by lazy는 어떻게 동작하는가?


### References

- https://gist.github.com/paulfranco/4453383cc6df064d03087ce7aa5a0c8c

- https://www.fullstack.cafe/blog/kotlin-interview-questions

- https://www.journaldev.com/20567/kotlin-interview-questions#what8217s-the-target-platform-of-kotlin-how-is-kotlin-java-interoperability-possible




