package test01

// when: java의 switch와 유사
fun main() {
    val a1 = 1
    when(a1) {
        1 -> println("a1: 1")
        2 -> println("a2: 2")
        else -> println("a1은 다른 값을 가짐")
    }

    val data = 15
    when(data) {
        !in 1..100 -> println("no!")
        in 1..10 -> println("in 1..10")
        in 11..20 -> println("in 11..20")
        else -> println("yes:)")
    }

    val score = readln().toInt()
    println("input score : ${score/10}")     // 90~100 : grade A, 80~90 : grade B ...

//    val grade = when(score/10) {
//        !in 60..100 -> 'F'
//        in 90..100 -> 'A'
//        in 80..89 -> 'B'
//        in 70..79 -> 'C'
//        in 60..69 -> 'D'
//        else -> "WTF"
//    }
    val grade = when(score/10) {
        9, 10 -> 'A'
        8 -> 'B'
        7 -> 'C'
        6 -> 'D'
        else -> 'F'
    }
    println("your grade : $grade")
}
