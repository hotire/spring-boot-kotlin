# spring-boot-kotlin

Kotlin !!

![Kotlin](/doc/img/Kotlin.png)

### Getting Started Kotlin 

Kotlin Koans 

- reference : https://play.kotlinlang.org/koans/overview

### Style Guide

https://blog.naver.com/gngh0101/222284257206

### Books

- Kotlin In Action 
https://www.manning.com/books/kotlin-in-action


### Kotlin's Philosophy

- 실용성

- 간결성 

- 안정성

- 상호운용성





# Basic Syntax

- reference : https://kotlinlang.org/docs/reference/basic-syntax.html?&_ga=2.30814975.1316054976.1576165289-2032132519.1576165289#defining-functions

### Program entry point

An entry point of a Kotlin application is the main function.

```
fun main() {
    println("Hello world!")
}
```

## Variables

변수 선언 시 사용하는 키워드는 다음과 같이 2가지가 있다.
- val : 변경 불가능한 변수 (킹자바의 final)
- var : 변경 가능한 변수

### String Template 
변수 앞에 $를 붙여 사용한다. 
다만 한글을 사용살 때 유니코드 변환 과정에서 unresolved reference 오류가 발생한다. 
${variable} 처럼 {} 감싸는 걸 습관화하자!

### Enum

킹자바와 달리 enum은 soft keyword이다. 

### Smart Cast
타입 검사와 타입 캐스르를 조합 

### Iterator 

- range : .. / in 를 사용한다. 
- half-closed range : until를 사용한다. 
- downTo : 역방향
- step : 증가 값 


### Try

코틀린에서는 try 키워드는 if, when과 마찬가지로 식이다. 

## Functions

Function having two Int parameters with Int return type:

```
fun sum(a: Int, b: Int): Int {
    return a + b
}
```

Function with an expression body and inferred return type:

```
fun sum(a: Int, b: Int) = a + b
```


Function returning no meaningful value : 'Unit', 'Unit' return type can be omitted

```
```

if a default parameter precedes a parameter with no default value, the default value can only be used by calling the function with 'named arguments'

```
fun foo(bar: Int = 0, baz: Int) { /*...*/}

foo(baz = 1) // The default value bar = 0 is used
```


### 확장 함수

확장할 클래스의 이름을 덧붙여 사용한다. 

클래스 이름을 수신 객체 타입, 대상을 수신 객체라고 부른다. 

- 확장 함수는 오버라이딩할 수 없다.


### 구조 분해 선언 

```
infix fun Any.to(other: Any) = Pair(this, other)
 val (number , name) = 1 to "one"
```

## Class / Interface 

코틀린의 클래스, 인터페이스는 자바와 조금 다르다.

인터페이스의 경우 프로퍼티 선언이 들어갈 수 있고, 기본적 선언이 public final 이다. 

게다가 중첩 클래스는 기본적으로 내부 클래스가 아니다. 즉 외부 클래스에 대한 참조가 없다.

extends / implements 가 아닌  ":" 을 붙이고 클래스 이름을 적는 것으로 처리한다.

@Override 를 사용하지 않고 override 변경자를 꼭 사용해야 한다. 

- 코틀린은 기본적으로 final클래스이기 때문에 상속을 허용하려면 Open을 붙인다.

- method에 final을 붙여 자바와 마찬가지로 오버라이딩을 금지할 수 있다. 

- final클래스의 경우 스마트 캐스트가 가능하다.


### Internal 

자바의 패키지와 비슷하게 internal를 통해 캡슐화를 제공한다. 

### Nested 

자바와 다르게 명시적으로 요청하지 않으면 바깥쪽 클래스 인스턴스에 대한 접근 권한이 없다.

코틀린의 중첩 클래스에 아무런 변경자가 붙지 않으면 자바 static 중첩 클래스와 같다.

코틀린의 inner 키워드는 자바의 내부 클래스를 의미한다. 

### Sealed 

sealed 변경자를 붙이면 하위 클래스 정의를 제한한다. 

예를 들면 when 식에서 정의를 제한하여 else가 필요 없다. 

또한 기본적으로 open이다. 반드시 상위 클래스의 중첩 클래스여야 한다. 


### Getter / Setter 

게터에서는 field 값을 읽을 수만 있고, 세터에서는 field 값을 읽거나 쓸 수도 있다.

### data

class 앞에 data를 붙이면 equals / toString / hashcode를 프로퍼티를 고려해서 만들어진다. 

### delegation 

by 키워드를 사용해 클래스를 위임할 수 있다. 

자바에서 장황하게 사용하던 데코레이터 패턴을 쉽게 사용하는 것이다. 

그래도 이상하게 장황한 자바가 좋네.

### Singleton

Singleton으로 객체를 생성하고 싶으면 object 키워드를 붙인다.


### Companion 

클래스 안에 정의된 객체 중 하나에 companion 키워드를 붙이면 클래스의 동반 객체로 만들 수 있다. 


### Anonymous object

무명 객체를 정의할 때 object 키워드를 사용한다. 클로저를 완벽 지원한다.(이부분이 사기네)

### 요약 

- 인터페이스에 프로퍼티 추가 가능하다. 

- 코틀린 선언은 기본적으로 final, public

- internal 같은 모듈안에서 사용

- 중첩 클래스는 내부 클래스가 아니다. 

- 데이터 클래스를 사용하면 @Data 효과

- 클래스 위임 사기다. 

- 싱글톤 사기다. 

- 동반 객체 사기다. 

- 무명 객체 사기다. 


## Lambda

자바의 람다보다 우아한 코틀린의 람다

- 코틀린에서 함수 호출 시 맨 뒤에 있는 인자가 람다식이면 그 람다를 괄호 밖으로 빼낼 수 있다. 

- 람다가 유일한 인자고, 괄호 뒤에 람다를 썻다면 호출시 빈 괄호를 없애도 된다. 


### Lazy 지연 계산, 콜렉션 연산 

map / filter 는 컬렉션을 즉시 생성한다. 

.map().filter() 사용하면 매 단계마다 리스트를 생성한다. 

이는 오버헤드이기 때문에, asSequence()를 사용하자.

-> asSequence는 자바의 Stream과 유사하다.


### with / apply 

with, apply를 사용해 수신 객체를 지정할 수 있다.

둘의 차이는 apply는 항상 자신에게 전달된 객체, 수신 객체를 반환한다. 

- apply는 빌더로 사용할 수 있다. 


## Type 

### 플랫폼 타입 

널 관련 정보를 알 수 없는 타입을 말한다.

### Unit 타입 

코틀린의 Void이다. 제네릭으로 사용하면 return을 명시할 필요가 없다..!! 

자바에서 Void를 사용하면 return null을 명시하던거와 다르다..!!

### Nothing 타입 

성공, 정상적으로 끝나지 않고 예외가 발생하는 케이스이다. 

## Operator & Convention 


## Function 

### inline 함수 

함수 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔치기 한다. 

- 람다를 다른 변수에 저장한다면 인라인 함수를 사용할 수 없다. 

- 인라인하면 안 되는 람다를 파라미터로 받는다면 noinline 변경자를 사용할 수 있다. 

- 논로컬 반환을 사용할 수 있다. 


## Generic 

- 자바와 마찬가지로 제네릭은 실행 시점에 타입 소거된다. 이는 한계점이다. 

- 코틀린 인라인의 경우 실행 시점에 타입 정보를 알 수 있다.


### Null

Null이 될 수 없는 타입은 널이 될 수 있는 타입의 하위 타입이다.
 

### invariant / covariant 

인스턴스 타입 사이의 하위 타입 관계가 성립하지 않으면 제네릭 타입을 무공변이라고 한다. (invariant)

반면에 하위 타입 관계가 성립하면 공변 관계이다. (covariant)

- 공변적임을 표시하기 위해선 타입 파라미터 앞에 out을 넣는다. 

~~~kotlin
interface Producer<out T> {
    fun produce() : T
}
~~~
: T 타입의 값을 생산할 수 있지만, T 타입의 값을 소비할 수 없다. 
 
 
- <in T> == <? super T>

- <out T> == <? exetends T>


### Star Projection

타입 정보가 없음을 표한함 

- <*> == <out Any?>
  
  
## Annotation 

자바와 거의 똑같다. 

- Target에서 get / set 개념이 있다.

## Reflection 
 
자바와 똑같다. 

다만 방법이 2가지이다. 

- java.lang.reflect 패키지 

- kotlin.reflect 패키지 

kotlin.reflect 패키지는 자바에 없는 프로퍼티, 널이 될 수 있는타입과 같은 코틀린 개념에 대한 리플렉션을 지원한다. 