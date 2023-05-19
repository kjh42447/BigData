# 스트림
배열, 컬렉션의 요소를 하나씩 람다식으로 처리해주는 반복자로써 내부 반복자(컬랙션 내부에서 요소들을 반복)를 사용하므로 병렬처리가 쉽다. 따라서 파이프라이닝도 가능하다.

# 스트림 활용
스트림 활용은 기본적으로 생성, 중간 연산, 최종 연산으로 구분하여 사용한다.  

- 스트림 생성
    ```java
    //기본 스트림 생성 및 활용
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> listStream = list.stream();
    listStream.forEach(System.out::prinln);

    //배열로 스트림 생성하는 방법 종류
    Stream<String> stream = Stream.of("a", "b", "c");
    Stream<String> stream = Stream.of(new String[] {"a", "b", "c"});
    Stream<String> stream = Arrays.stream(new String[] {"a", "b", "c"});
    Stream<String> stream = Arrays.stream(new String[] {"a", "b", "c"}, 0, 3);
    ```  
- 중간 연산
연산 결과를 스트림으로 반환하는 연산을 의미한다. 대표적으로 flilter, map, sorted, peek 등이 있다.  
- 최종 연산
연산 결과를 스트림 이외로 반환하는 연산을 의미한다. 대표적으로 forEach, match, sum, count, max, reduce, collect 등이 있다.