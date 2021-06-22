# Scope Function

## With vs Also

### 범위 지정 함수 호출 시에 수신 객체가 어떻게 전달 되는가?
- with 에서는 수신 객체가 매개 변수 T 로 제공됩니다. 이를 명시적으로 제공된 수신 객체 라고 합니다.
- also 에서는 T 의 확장함수로 수신 객체가 암시적으로 제공됩니다.

###  범위 지정 함수 에 전달된 수신객체가 다시 수신 객체 람다에 어떠한 형식으로 전달할것인가?
- with 는 수신 객체 지정 람다 가 T 의 확장함수 형태로 코드 블록 내에 수신 객체가 암시적으로 전달 됩니다. (확장함수형태...!!)
- also 는 수신 객체 지정 람다 에 매개변수 T 로 코드 블록 내에 명시적으로 전달 됩니다.


### 범위 지정 함수 의 최종적인 반환 값이 무엇인가?

- with 는 람다를 실행한 결과를 반환 합니다.
- also 는 코드 블록 내에 전달된 수신객체를 그대로 다시 반환 합니다.


### References

https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5

https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29