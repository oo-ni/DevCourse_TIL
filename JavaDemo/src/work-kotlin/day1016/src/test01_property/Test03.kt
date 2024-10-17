package test01_property

// Top-Level 전역변수? 프로퍼티 OK
var myName: String = "Yoon"
    get() = field
    set(value) { field = value }

fun myFun(){
    // 함수 내에 선언된... 지역변수...? 프로퍼티 아님!! get/set이 뭔말?? 지역변수는 함수 실행할 때 잠깐 저장시키고 버리는 용도!
    var funName: String = "Hello"
//    get() = field
//    set(value) { field = value }
}

class User3 {
    // 클래스 멤버변수? 프로퍼티 OK
    var userName: String = "programmers"
        get() = field
        set(value) { field = value }
}
