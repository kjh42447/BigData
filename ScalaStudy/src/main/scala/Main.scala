
// 빌드 및 실행 : ctrl + shift + r
// 주석 : command + /

object Main {
  def study_obj(): Unit = {
    /** 객체
     * Any - (AnyVal, AnyRef) - 대상 자료형 상속
     */
    val s1 = "Hello"
    val s2 = "HeLLo"
    val s3 = "Hello"

    case class Person(p1: String, p2: String)
    val p1 = Person("a", "b")
    val p2 = Person("a", "b")
    val p3 = Person("b", "c")

    println(1 == 1)
    println(1 == 'a')
    println('a' == 'a')
    println(s1 == s2)
    println(s1 == s3)
    println(p1 == p2)
    println(p1 == p3)
  }

  def study_type(): Unit = {
    /** 자료형
     *
     */
    // 암시적 선언
    var x = 10
    var y = "abc"
    var z =
      """a
        |b
        |c
        |""".stripMargin

    println(x)
    println(y)
    println(z)

    // 명시적 선언
    var b: Byte = 10
    var s: Short = 10
    var i: Int = 10
    var l: Long = 10
    var d: Double = 12.34
    var str1: String = "a\n" +
      "b" +
      "c"

    println(str1)

    println(s"${ str1 }")
    println(s"${ 1 + 1 }")
    println(f"$y%s is $d%2.2f meters tall")
    println(raw"a\nbc")
  }

  def study_var(): Unit = {
    /** 변수
     * var : 가변
     * val : 불변
     * 불변 값이면 불변 변수를 사용하는 것을 선호(동시성 이슈)
     */
  }

  def study_func(): Unit = {
    /** 함수
     * 함수의 인수는 val 이므로 변경 불가
     */
    def function1(x: Int, y: Int):Int = {
      return x+y
    }
    println(function1(1,2))

    def function2(x: Int, y: Int = 10) = {
      x+y
    }
    println(function2(1))

    def function3(x: Any, y: Any) = {
      println(x)
      println(y)
      x
    }
    println(function3(1,2))

    def function4(message: String): Unit = println(message.toLowerCase())
    function4("AnyString")

    def sum_params(num: Int*) = num.reduce(_ + _)
    println(sum_params(1, 2, 4, 5))

    val random1 = Math.random()
    var random2 = Math.random()
    def random3 = Math.random()
    println(random1)
    println(random1)
    println(random2)
    println(random2)
    println(random3)
    println(random3)

//    람다 함수
    def lambda_test(f: (Int, Int) => Int, x: Int, y: Int) = f(x, y)
    println(lambda_test((x: Int, y: Int) => x + y, 10, 11))
    println(lambda_test((x, y) => x + y, 10, 11))
//    묵시적 처리
    println(lambda_test(_ + _, 1, 2))

//    커링
    def modN(n: Int)(x: Int) = ((x % n) == 0)
    def mod2 = modN(2) _
    def mod3: Int => Boolean = modN(3)
    println(mod2(4))
    println(mod2(5))
    println(mod2(6))
    println(mod3(4))
    println(mod3(5))
    println(mod3(6))

    val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(nums.head)
    println(nums.tail)

//    클로저
//    내부에 참조되는 모든 인수에 대한 묵시적 바인딩을 지닌 함수
    def divide(n:Int) = (x:Int) => {
      x/n
    }

    def divideFive = divide(5)
    println(divideFive(10)) // 2

    var factor = 10
    def multiplier = (x:Int) => x * factor
    println(multiplier(4))  // 40

    factor = 100
    println(multiplier(4))  // 400
  }

  def study_class(): Unit = {
    /** 클래스
     * getter, setter 등은 변수에 맞춰 자동으로 생성 및 사용됨
     */
    class C1(val param1: String, var param2: Int, param3: Double = 2.5) {
      def classMethodTest(): Unit = println(param3)
    }
    class C2
    val c1 = new C1("Class1", 1, param3 = 3.7)
    println(c1)
    println(c1.param1)
    println(c1.param2)
//    println(c1.param3)  기본 멤버 변수 접근 불가
    c1.classMethodTest()

//    메소드 오버라이드
    class C1_1(param1: String, param2: Int, param3: Double, var param4: String) extends C1(param1, param2, param3) {
      override def classMethodTest(): Unit = println(param4)
    }
    val c1_1 = new C1_1("Class1", 1, 3.7, "override test")
    c1_1.classMethodTest()
    val c1_2 = new C1_1("Class1", 1, 3.7, "override test") {
      override def classMethodTest(): Unit = println(param1)
    }
    c1_2.classMethodTest()

//    생성자
//    별도로 존재하지 않음. 바디에 작업을 작성하면 됨.

//    추상클래스
    abstract class Person(name: String, age: Int) {
      def work
      def status(str: String): Unit
      def greeting(): Unit = println(s"${name}님은 ${age}살 입니다.")
    }

    class Player(name: String, age: Int) extends Person(name, age) {
      def work: Unit = println("일합니다.")
      def status(str: String): Unit = println(s"$str 상태 입니다.")
    }

    var p = new Player("칼", 30)
    p.work
    p.status("--")

//    케이스 클래스
//    기본적으로 불변 데이터
//    toString, hashCode, equals 자동 생성
    case class CaseClassTest(name:String, age:Int)
    var case_class_test = CaseClassTest("cct", 1)
    println(case_class_test.toString)
    println(case_class_test.hashCode())

//    패턴 매칭
    abstract class Notification

    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = {
      notification match {
        // body 는 반환값에 사용하지 않기 때문에 _로 처리 가능
        case Email(email, title, _) if email == "to@gmail.com" =>
          s"You got an special email from $email with title: $title"
        case Email(email, title, _) =>
          s"You got an email from $email with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"you received a Voice Recording from $name! Click the link to hear it: $link"
        case _ => null
      }
    }

    val email = Email("to@gmail.com", "Help Me", "I have a Question")
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(email))
    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))

    abstract class Device
    case class Phone(model: String) extends Device {
      def screenOff = "Turning screen off"
    }
    case class Computer(model: String) extends Device {
      def screenSaverOn = "Turning screen saver on..."
    }

    def goIdle(device: Device) = device match {
      case p: Phone    => p.screenOff
      case c: Computer => c.screenSaverOn
    }

    val phone = Phone("Galaxy")
    val computer = Computer("Macbook")

    println(goIdle(phone))
    println(goIdle(computer))
  }

  def study_trait(): Unit = {
    /** 트레잇
     * 자바 interface 와 유사. 추상클래스와 달리 멤버변수 사용불가.
     */
//    믹스인 컴포지션
    abstract class A {
      val message: String
    }
    class B extends A {
      val message = "I'm an instance of class B"
    }
    trait C extends A {
      def loudMessage: String = message.toUpperCase()
    }
    class D extends B with C
    val d = new D

    println(d.message)
    println(d.loudMessage)
  }

  def study_singleton(): Unit = {
    /** 싱글톤
     * object 로 선언. 전역에서 접근 및 참조 가능.
     */

    object Singleton1 {
      val s1: String = "default string"
      def func1(): Unit = println("default function")
    }

    Singleton1.func1()

//    컴패니언
//    싱글톤 객체와 클래스가 같은 이름을 사용하는 경우. 정적 메소드의 보관 장소 제공. 자바의 static 처럼 사용.
  }

  def study_collection(): Unit = {
    /** 콜렉션
     *
     */
//    배열
    val array1 = Array(1, 2, 3)
    println(array1(0))
    array1(1) = 7
    println((array1 ++ Array(2, 3, 5)).mkString("Array(", ", ", ")"))
    println((0 +: Array(2, 3, 5)).mkString("Array(", ", ", ")"))
    println((Array(2, 3, 5) :+ 1).mkString("Array(", ", ", ")"))

//    리스트
    val list1 = List(10, 20, 30, 40)
    val list2 = (1 to 10).toList
    val list3 = array1.toList
    println(list1)
    println(list2)
    println(list3)
    println(list1(1))
    println(list1.head)

//    집합
    val s1 = Set(1, 1, 2)
    println(s1)
    println(s1(0))
    println(s1(1))

//    튜플. match 에 주로 사용.
    val t1 = ("tuple test", 1, "element")
    println(t1._1)
    val t2 = ("tuple test", 2, "element")

    def tupleMatchTest(t: (String, Int, String)): Unit = t match {
      case (str1, 1, str2) => println("num is 1")
      case (str1, num1, str2) => println(s"($str1, $num1, $str2)")
    }

    tupleMatchTest(t1)
    tupleMatchTest(t2)

//    맵
    val map1 = Map(1 -> 2)
    val map2 = Map("foo" -> "bar")

    println(map1.get(1))    // Option 타입 반환
    println(map1.getOrElse(1, 0))    // value 반환, 없으면 기본값 반환
    println(map2.getOrElse("foo", "baz"))

    /** 반복문
     *
     */
    for (num <- 0 to 2)   println(num)    // 이상, 이하
    for (num <- 0 until 2)   println(num)   // 이상, 미만
    for ((value, index) <- (10 to 12).zipWithIndex)   print(value, index)
    for ((k, v) <- Map("k1" -> "v1", "k2" -> "v2", "k3" -> "v3", "k4" -> "v4", "k5" -> "v5"))   print(k, v)
    for (x <- 0 to 2; y <- 0 to 2)  println(x, y)   // 옆과 같이 세미콜론으로 중첩 for 처리 가능
    for (x <- 0 to 2; y <- 0 to 2; if x < 1; if y <= 1) println(x, y)   // 조건문도 추가 가능

    def fives(n: Int) = {
      for( x <- 0 to n; if x % 5 == 0)
        yield x   // 시퀀스 컴프리헨션 반환
    }

    for(num <- fives(100))  println(num)

    var i = 0
    do{
      println(i)
      i += 1
    } while( i < 3)
    while (i < 6) {
      i += 1
      println(i);
    }

    /** 정렬, 그룹핑, 필터링 등
     *
     */
    val list_map1 = 1 to 8
//    map. 각 항목에 대해 동일한 작업 수행
    list_map1.map(_ + 1)
    println(list_map1.mkString("List(", ", ", ")"))
    println(list_map1.getClass)

//    reduce, fold. 콜렉션 데이터 집계 시 사용.
    println(list_map1.reduce(_ - _))      // ((((1-2)-3)-4...)
    println(list_map1.reduceLeft(_ - _))
    println(list_map1.reduceRight(_ - _))   // (...4-(5-(6-(7-8))))
    println(list_map1.fold(10)(_ - _))        //  ((((10-1)-2)-3)-4...)
    println(list_map1.foldRight(10)(_ - _))   //  (...6-(7-(8-10)))

    var datas = List(("A", 1, 1), ("B", 2, 1), ("C", 6, 1), ("B", 2, 2), ("A", 8, 1), ("C", 2, 1))

//    groupBy. 데이터를 키 기준으로 병합할 때 사용. Map 형식으로 리턴.
    datas.groupBy(_._1).foreach({ case (k, v) => printf("key: %s, value: %s\n", k, v) })
    datas.groupBy(data => (data._1, data._2)).foreach({ case (k, v) => printf("key: %s, value: %s\n", k, v) })

//    filter, partition, find, takeWhile, dropWhile. 콜렉션 데이터 필터링 혹은 분류 시 사용.
    println(list_map1.filter(_ < 5))
    println(list_map1.partition(_ > 5))
    println(list_map1.find(_ > 5))
    println(list_map1.takeWhile(_ < 5))
    println(list_map1.dropWhile(_ < 5))

//    zip. 두 개의 콜렉션을 묶을 때 사용. 길이가 다르면 작은 값에 맞춰짐.
    for( item <- List(1,2,3).zip(List(1,2,3,4)))    println(item)

//    mapValues. Map 에서 value 만 map 처리하고 싶은 경우 사용.
    var maps = Map("A" -> List(1, 2, 3), "B" -> List(4, 5, 6), "C" -> List(7, 8, 9))
    maps.mapValues(_.sum).foreach({ case (k, v) => printf("key: %s, value: %s\n", k, v) })

//    sorted, sortWith, sortBy
    println(list_map1.sorted)
    println(list_map1.sorted(Ordering.Int.reverse))
    println(list_map1.sortBy(x => x%2))
    println(list_map1.sortWith(_ <= _))

    case class Person(index:Int, var correct:Int)

    val persons = Array(Person(1, 3),Person(2, 4), Person(3, 4))
    println(persons.sortWith((x:Person, y:Person) => {
      if(x.correct == y.correct)  x.index >= y.index
      x.correct > y.correct
    }).toList)

  }

  def main(args: Array[String]): Unit = {
//    study_obj()
//    study_type()
//    study_var()
//    study_func()
//    study_class()
//    study_trait()
//    study_singleton()
    study_collection()
  }
}