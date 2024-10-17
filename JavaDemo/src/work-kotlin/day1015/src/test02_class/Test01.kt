package test02_class

// 보통 클래스 개발할 때 생성자는
// 1. 안만들거나
//class MyClass

// 2. 하나만 만들어서 기본값 싹 셋팅하거나
// 생성자를 만들거야? 그럼 걍 클래스 선언부에 바로 넣어!
class MyClass(name: String, age: Int = 0) {
    init {
        // 여기가 주 생성자의 초기화 블럭 부분입니다. 사실상 주 생성자 몸통이 이렇게 떨어져 나온...
        println("주 생성자 호출됨!")
    }
    var phone: String = "01012345678"
    fun myFunc() {
        println("class 멤버 함수 : $phone")
    }
}

// 3. 되게 여러 개 만들어서 여러 종류로 초기 셋팅되게 하더라...
fun main() {
//    val myObj = MyClass()     // 주 생성자 아예 안만들면 기본 생성자로 있었을건데, 주 생성자를 만드네? 그럼 기본 생성자 자동제공 안되지!
    val myObj = MyClass("건우", 20)
    val myObj2 = MyClass("주원")
}
