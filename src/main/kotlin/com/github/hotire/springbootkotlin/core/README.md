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