package test01_property

class User4(var name: String) {
    var nickname: String = name
        get() = field.uppercase()
}

fun main() {
    val user = User4("yoon")
    println(user.name)
    println(user.nickname)
}