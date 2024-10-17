package test01_property

// 객체 생성 시 초기값 넣을건데요! 커스텀 get/set도 하고싶어용
class User5(name: String) {
    var myName: String = name
        get() = field.uppercase()
        set(value) {
            field = "Hello" + value
        }
}

fun main() {
    val user = User5("yoon")
}