package test02_class

class MyClass3 {
    // 주 생성자는 하나밖에 못 만드는데 보조 생성자는 여러개 오버로딩 가능함.
    constructor() {
        println("보조 생성자 no parameter")
    }

    constructor(name: String) {
        println("보조 생성자 호출됨 ${name}")
    }

    init {
        println("주 생성자 호출됨")
    }
}

fun main() {
    val obj1 = MyClass3()   // error 현재 작성된 생성자가(주생성자 안보이는데?) String 보조생성자 하나니까!
    val obj2 = MyClass3("건우")

}
