
# 5주차 미션 자바로 배우는 IoC/DI
>Service가 Repository를 직접 생성하지 않도록 리팩토링하여, 의존성 주입(DI)과 제어의 역전(IoC)의 필요성을 구조적으로 이해합니다.

## 라팩토링
기존 Main에서 저장, 비즈니스로직을 둘 다 진행했지만 이걸 service, repository, main 세 개의 레이어로 분리를 진행했다.

## 용어
멋사 과제에 필요한 개념을 키워드별로 정리하는 곳
### IOC(Inversion Of Control):제어의 역전
제어의 역전이라는 뜻으로 기존 사용자 제어에서 **프로그램 제어**로 제어의 **역전**이라는 뜻

기존에는 code 영역에서 직접 제어(control) 했었다. 하지만 IoC를 통해 프로그램 영역에서 제어하는 개념이다.

> 우리가 code로 끼워주는게 아니라 그냥 변수? 형태로 프로그램이 골라서 끼울 수 있게.
> 동작시킨다는 뜻..?으로 알면 될 것 같다.

#### IoC 미적용
``` java
// 인터페이스가 있더라도 무의미한 경우
interface Repository { void save(); }

class DatabaseRepository implements Repository {
    public void save() { /* DB 저장 로직 */ }
}

// 상위 모듈 (제어권을 능동적으로 행사함)
class MemberService {
    private final Repository repository;

    public MemberService() {
        // [결정적 차이] 상위 모듈이 하위 모듈의 인스턴스를 직접 생성
        // 이 시점에 MemberService는 DatabaseRepository에 강하게 결합(Tight Coupling)됨
        this.repository = new DatabaseRepository();  // 여기가 code로 결합되어ㅣㅆ음
    }

    public void execute() {
        repository.save();
    }
}

// 호출부
public class Main {
    public static void main(String[] args) {
        // 클라이언트는 서비스의 내부 의존성 조립에 관여할 수 없음
        MemberService service = new MemberService(); 
        service.execute();
    }
}
```

#### IoC 적용
```java
// 인터페이스 정의
interface Repository { void save(); }

// 하위 모듈
class DatabaseRepository implements Repository {
    public void save() { /* 로직 */ }
}

// 상위 모듈 (제어권이 박탈됨)
class MemberService {
    private final Repository repository;

    // 생성자를 통해 외부에서 주입받음 (IoC 성립)
    public MemberService(Repository repository) {
        // 프로그램에서 객체를 주입하기 때문에 reposiroty가 달라질 수 있음
        // ex) realRepo, mockRepo 등등 repo를 자유롭게 수정 가능함.
        this.repository = repository; 
    }
}

// 조립기 (Assembler) 역할의 Main
public class Main {
    public static void main(String[] args) {
        Repository repo = new DatabaseRepository();
        MemberService service = new MemberService(repo); // 제어의 역전 발생
    }
}
```

### DI: 의존성 주입
DI는 IoC를 구현하기 위해 알아야 되는 개념이다. IoC를 구현하기 위해서는 특정 
객체가 다른 객체를 사용(의존)하는 경우, 이를 프로그램에서 직접적으로 주입하는 
것을 이야기합니다.

``` java
// 해당 service는 repository에 의존한다고 할 수 있습니다. 그리고 그 의존을 IoC 형태로 구현하기
// DI기법을 사용했다고 보시면 됩니다.
class MemberService {
    private final Repository repository;

    // 생성자를 통해 외부에서 주입받음 (IoC 성립)
    public MemberService(Repository repository) {
        // 프로그램에서 객체를 주입하기 때문에 reposiroty가 달라질 수 있음
        // ex) realRepo, mockRepo 등등 repo를 자유롭게 수정 가능함.
        this.repository = repository; 
    }
```
#### 의존성(Dependency)
클래스 $A$가 기능 수행을 위해 클래스 $B$의 메서드를 호출하거나 필드를 참조해야 할 때, "$A$는 $B$에 의존한다"고 정의합니다.

#### 주입(Injection)
객체 내부에서 의존 대상을 스스로 결정(Instantiate)하는 것이 아니라, 생성자나 메서드 등을 통해 외부 환경으로부터 해당 참조를 전달(Pass)받는 행위를 의미합니다.

## gemini 인사이트


# 회고
사실 node 공부하면서 저렇게 service, repo(?)별로 분기하는 법은 공부했어서 ㄱㅊ았음

하지만 자바에서 interface를 사용해 클래스선언이 가능한줄 몰랐음
그러면 mock,memory 교체를 타입제한이 걸린 상태에서도 가능한게 좀 신기함긴 함


참조: [인터페이스 vs 추상클램스 차이점 완벽 이해하기](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4-vs-%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%B0%A8%EC%9D%B4%EC%A0%90-%EC%99%84%EB%B2%BD-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)