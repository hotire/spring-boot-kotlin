# Extensions

https://medium.com/til-kotlin-ko/kotlin%EC%9D%98-extension%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80-part-1-7badafa7524a

### Extensions은 정적으로 처리된다.

~~~kotlin
fun String.hello() : String {
    return "Hello, $this"
}
public final class ExtensionsKt {
   @NotNull
   public static final String hello(@NotNull String $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      return "Hello, " + $receiver;
   }
}
~~~
hello()을 변환한하면 다음과 같다. 

확장 대상(Receiver)인 String을 인자로 받는 static final로 메소드가 생성됩니다. 
이는 클래스 자체가 확장된 것이 아니라, 정적인 메소드 형태로 코드가 생성되었으므로 ,객체 멤버 접근에 제한이 존재할 수 있다는 뜻으로 해석할 수 있습니다. 
이 특성은 ”Extensions are resolved statically”에서 다음과 같이 설명하고 있습니다.

- Extension은 실제로 클래스를 상속/수정하지 않습니다. 클래스에 새 멤버를 삽입하지 않고 단순히 해당 타입의 변수에 dot(.)을 기반으로 호출 가능한 함수를 생성합니다.
- Extension이 리시버의 타입에 의한 가상 함수가 아니라 정적으로 처리된다는 점을 강조하고 싶습니다. 이는 호출되는 확장 함수는 표현식의 타입에 따라 결정된다는 것을 의미합니다.


### Extension보다 멤버가 우선이다.

이미 클래스에 동일한 메서드가 있더라도 확장함수를 정의할 수 있다. 

하지만 메서드가 호출된다.


### Extension 역시 범위(Scope)를 가진다.

