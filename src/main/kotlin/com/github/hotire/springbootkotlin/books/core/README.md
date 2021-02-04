# Core

https://medium.com/hongbeomi-dev/tagged/kotlin

## Collection
https://medium.com/hongbeomi-dev/kotlin-collection-%ED%95%A8%EC%88%98-7a4b1290bce4

- Creation — 컬렉션을 생성하는 함수 (ex : listOf)
- Convert — 다른 유형으로 캐스팅하는 함수 (ex: asMap)
- Choose — 항목 중 하나에 접근하는 함수(ex : get)

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