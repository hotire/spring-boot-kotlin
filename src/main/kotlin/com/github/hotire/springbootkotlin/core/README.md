# Core

https://medium.com/hongbeomi-dev/tagged/kotlin

## Collection
https://medium.com/hongbeomi-dev/kotlin-collection-%ED%95%A8%EC%88%98-7a4b1290bce4

### Creation
컬렉션을 생성하는 함수 
~~~kotlin
  listOf("a", "b")
~~~

- Compose : 새로운 컬렉션 인스턴스화
- Copy : 컬렉션 복사
- Catch :  try-catch와 유사하게 다른 무언가를 생성 (ifEmpty, orEmpty, requireNoNulls, listOfNotNull)


### Convert
다른 유형으로 캐스팅하는 함수
~~~kotlin
   listOf("a", "b")
            .map { it + 1}
~~~

### Choose
항목 중 하나에 접근하는 함수
~~~kotlin
    listOf("a", "b")
            .get(1)
~~~

### Conclude
항목에서 무언가를 생성하는 함수(ex: sum)
~~~kotlin
list.reduce{ result, item -> result * item }
~~~

### Change
내용을 변환하는 함수 (ex: map)
~~~kotlin
list.chunked(3)
~~~


## Coroutine

https://medium.com/hongbeomi-dev/coroutines-basic-e32053f18fdf

코루틴은 동시성 프로그래밍을 가능하도록 만든 개념입니다. 나온지 꽤 오래된 기술이지만 스레드에 대한 이슈가 많아지면서 최근 다시 조명을 받게 되었습니다. 
코루틴은 Context Switching 오버헤드가 적은 Non-blocking 일종의 경량 스레드라고 할 수 있습니다. 
코루틴은 프로그램이 실행 중일 때 특정 시점에 코루틴으로 이동하여 그 전에 실행하던 루틴을 정지하도록 하게 할 수 있습니다. 
