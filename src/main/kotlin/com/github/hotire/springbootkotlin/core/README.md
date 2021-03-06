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


## Coroutines
https://tourspace.tistory.com/150?category=797357
https://medium.com/hongbeomi-dev/coroutines-basic-e32053f18fdf

코루틴이란 일시정지, 재개가 가능한 함수라고 할 수 있다. 

공식 문서에서도 "Coroutines(코루틴)은 스레드를 block하지 않고, suspend할 수 있다." 라고 적혀있다.

코루틴은 동시성 프로그래밍을 가능하도록 만든 개념입니다. 나온지 꽤 오래된 기술이지만 스레드에 대한 이슈가 많아지면서 최근 다시 조명을 받게 되었습니다. 
코루틴은 Context Switching 오버헤드가 적은 Non-blocking 일종의 경량 스레드라고 할 수 있습니다. 
코루틴은 프로그램이 실행 중일 때 특정 시점에 코루틴으로 이동하여 그 전에 실행하던 루틴을 정지하도록 하게 할 수 있습니다. 

### DroidKnights  Kotlin 코루틴은 어떻게 동작하는가?
https://www.youtube.com/watch?v=usaD7HyN598

### Basic
https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4%EC%9D%98-%EA%B8%B0%EC%B4%88-cac60d4d621b

### CoroutineContext
CoroutineContext 는 코루틴을 어떻게 처리 할것인지 에 대한 여러가지 정보의 집합

### CoroutineScope
CoroutineScope 는 코루틴의 범위, 코루틴 블록을 묶음으로 제어할수 있는 단위

### Dispatcher
Dispatcher 는 CoroutineContext 의 주요 요소 입니다.
CoroutineContext 을 상속받아 어떤 스레드를 이용해서 어떻게 동작할것인지를 미리 정의해 두었습니다.

- Dispatchers.Default : CPU 사용량이 많은 작업에 사용합니다. 주 스레드에서 작업하기에는 너무 긴 작업 들에게 알맞습니다.
- Dispatchers.IO : 네트워크, 디스크 사용 할때 사용합니다. 파일 읽고, 쓰고, 소켓을 읽고, 쓰고 작업을 멈추는것에 최적화되어 있습니다.
- Dispatchers.Main : 안드로이드의 경우 UI 스레드를 사용합니다.

공식문서에 의하면 IO Dispatcher가 사용하는 스레드 풀의 최대 스레드 갯수는 64개를 넘지 않는다.

IO Dispatcher는 Default Dispatcher와 스레드 풀을 공유한다.
즉, 기존의 CPU 코어 만큼의 스레드(Default)에 64개의 스레드(IO)가 추가되므로 내 경우 최대 76개의 스레드가 생성되는 것이다


다만 동시에 돌릴 수 있는 최대 스레드는 64개로 유지된다.

https://github.com/Kotlin/kotlinx.coroutines/issues/2272

### Scope builder

다른 builder가 제공하는 코루틴 스코프 외에도 coroutineScope builder를 사용하여 자신만의 스코프를 선언할 수 있습니다. 
이것은 코루틴의 범위를 만들고 모든 하위 launch들이 완료될 때까지 완료되지 않습니다.

runBlocking 과 coroutineScope 는 둘 다 자신 블록 내부의 동작이 완료되기를 기다리기 때문에 비슷하게 보일 수 있습니다. 
이 둘의 주된 차이점은 runBlocking 은 메서드가 대기 중인 현재 스레드를 차단하는 반면 coroutineScope 는 중단되는 동안 다른 사용을 위해 기본 스레드를 해제한다는 것입니다. 
이런 차이점 때문에 runBlocking 은 정규 함수이고 coroutineScope 는 일시 중단 함수입니다.


- runBlocking.launch vs GlobalScope.launch
https://stackoverflow.com/questions/54842169/kotlin-coroutines-globalscope-launch-vs-runblocking/54855870


## Suspend

코틀린 컴파일러는 suspend 함수를 가져와서 유한한 상태 머신을 사용하여 최적화된 버전의 콜백으로 변환합니다.

~~~kotlin
interface Continuation<in T> {
  public val context: CoroutineContext
  public fun resumeWith(value: Result<T>)
}
~~~

### Hunting to know BLOCKING vs SUSPENDING
https://medium.com/mobile-app-development-publication/understanding-suspend-function-of-coroutines-de26b070c5ed

A process is blocked when there is some external reason that it can not be restarted, e.g., an I/O device is unavailable, or a semaphore file is locked.
A process is suspended means that the OS has stopped executing it, but that could just be for time-slicing (multitasking). There is no implication that the process can not be resumed immediately.



BLOCKING: Function A has to be completed before Function B continues. The thread is locked for Function A to complete its execution.
- 함수 B가 실행되기 위해선, 함수 A가 완료되어야 합니다. 스레드는 A가 끝날떄까지 lock이 걸려있다.(함수 A에 의해 Lock이 걸렸다라고 말할 수 있다.)

SUSPENDING: Function A, while has started, could be suspended, and let Function B execute, then only resume later. The thread is not locked by Function A.
- 함수 A가 시작된 동안 일시 중지되었다가, 함수 B를 실행한 뒤 다시 A를 실행할 수 있다. 즉 스레드는 lock이 걸리지 않았다.


### Threads vs Coroutines
https://www.baeldung.com/kotlin/threads-coroutines
- Differentiating Thread and Coroutine (launch & runBlocking) in Kotlin
https://medium.com/mobile-app-development-publication/differentiating-thread-and-coroutine-launch-runblocking-in-kotlin-28219506c002