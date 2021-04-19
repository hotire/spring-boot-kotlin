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

### References

- https://gist.github.com/paulfranco/4453383cc6df064d03087ce7aa5a0c8c

- https://www.fullstack.cafe/blog/kotlin-interview-questions

- https://www.journaldev.com/20567/kotlin-interview-questions#what8217s-the-target-platform-of-kotlin-how-is-kotlin-java-interoperability-possible




