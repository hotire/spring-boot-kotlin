# SAM (Single Abstract Method)

https://kotlinlang.org/docs/java-interop.html#sam-conversions
코틀린의 함수 리터럴을 자동으로 자바의 함수형 인터페이스로 교체해 준다.
SAM을 사용하기 위해서는 Java에서 만든 Interface와 1개의 Abstract Method 구현체만 있어야 한다.

즉, SAM Conversion은 자바로 작성한 Functioncal Interface에서만 동작하여 코틀린으로 작성시에는 사용하지 못한다.

### 함수 리터럴 

함수는 단지 데이터일 뿐이다.
함수 이름이 변수 이름과 같아지면, 함수 몸체가 바로 값 자체라는 의미.
http://www.silverwolf.co.kr/javascript/6021

## High-order functions and lambdas

https://kotlinlang.org/docs/lambdas.html

