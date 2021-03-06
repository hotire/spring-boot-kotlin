# Interview

## inline

## statement vs expression

## let, apply, run, with

https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5

https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29

### scoping functions 범위 지정 함수는 무엇을 하는가?

- 수신 객체
- 수신 객체 지정 람다 (lambda with receiver)

### With

~~~kotlin
inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}
~~~

as-is

~~~kotlin
val person: Person = getPerson()
print(person.name)
print(person.age)
~~~

to-be

~~~kotlin
val person: Person = getPerson()
with(person) {
    print(name)
    print(age)
}
~~~



## const and val

## 확장 함수

확장 함수 동작 원리

## kotlin SAM(Single Abstract Method)

코틀린의 함수 리터럴을 자동으로 자바의 함수형 인터페이스로 교체해 준다.
SAM을 사용하기 위해서는 Java에서 만든 Interface와 1개의 Abstract Method 구현체만 있어야 한다.

즉, SAM Conversion은 자바로 작성한 Functioncal Interface에서만 동작하여 코틀린으로 작성시에는 사용하지 못한다.

## coroutine

코루틴 동작원리 

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

~~~kotlin
class Demo {
    val myName : String by lazy { "John" }
}
~~~

to 

~~~kotlin
public final class Demo {
    @NotNull
    private final Lazy myName$delegate;
    
    // $FF: synthetic field
    static final KProperty[] $$delegatedProperties = ...
    @NotNull
    public final String getMyName() {
        Lazy var1 = this.myName$delegate;
        KProperty var3 = $$delegatedProperties[0];
        return (String)var1.getValue();
    }
    public Demo() {
        this.myName$delegate =
            LazyKt.lazy((Function0)null.INSTANCE);
    }
}
~~~

1. myName에 $delegate를 붙인 필드(myName$delegate)를 생성합니다.
2. myName$delegate의 타입이 String이 아닌 Lazy라는 점에 주의합니다.
3. 생성자에서 myName$delegate에 대해 LazyKt.lazy()를 할당합니다.
4. LazyKt.lazy()는 주어진 초기화 블록을 실행하는 역할을 합니다.

- Lazy 구현체의 종류

~~~kotlin
@kotlin.jvm.JvmVersion
public fun <T> lazy(
    mode: LazyThreadSafetyMode,
    initializer: () -> T
): Lazy<T> =
    when (mode) {
        LazyThreadSafetyMode.SYNCHRONIZED ->
            SynchronizedLazyImpl(initializer)
        LazyThreadSafetyMode.PUBLICATION ->
            SafePublicationLazyImpl(initializer)
        LazyThreadSafetyMode.NONE ->
            UnsafeLazyImpl(initializer)
    }
~~~

1. SYNCHRONIZED → SynchronizedLazyImpl 
기본 값으로 초기화가 최초 호출되는 단 하나의 스레드에서만 처리됩니다.
다른 스레드는 이후 그 값을 그대로 참조합니다.


2. PUBLICATION → SafePublicationLazyImpl
여러 스레드에서 동시에 호출될 수 있으며, 초기화도 모든 혹은 일부의 스레드들에서 동시에 실행이 가능합니다.
다만, 다른 스레드에서 이미 초기화된 값이 할당되었다면 별도의 초기화를 수행하지 않고, 그 값을 반환합니다.

3. NONE → UnsafeLazyImpl
초기화가 되지 않은 경우 무조건 초기화를 실행하여 값을 기록합니다.
멀티스레딩에서는 NPE 발생 가능성이 있어 안전하지 않습니다.


## Hey Kotlin! How it works

https://medium.com/til-kotlin-ko/hey-kotlin-how-it-works-f77ac72e56c5

### inline에서 recursive call은 어떻게 처리되나요?

- 지원하지 않는다.


### References

- https://gist.github.com/paulfranco/4453383cc6df064d03087ce7aa5a0c8c

- https://www.fullstack.cafe/blog/kotlin-interview-questions

- https://www.journaldev.com/20567/kotlin-interview-questions#what8217s-the-target-platform-of-kotlin-how-is-kotlin-java-interoperability-possible




