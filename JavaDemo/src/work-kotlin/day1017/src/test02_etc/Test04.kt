package test02_etc

data class User4(val name: String, val age: Int) {

}

fun main() {
    val set = HashSet<User4>()
    set.add(User4("geonoo", 25))
    set.add(User4("geonoo", 25))
    set.add(User4("geonoo", 26))
    set.add(User4("geonoo2", 25))
    println(set)

}