package test01

fun main() {
    var sum: Int = 0

    // 이렇게 변수의 값이 특정 구간에 속하는지 체크할 때 in 사용 가능하고, 해당 구간 동안에 계속 증강하면서 반복해라 에도 쓸 수 있음.
    println(sum in 0..10)
    println(sum in 0 until 10)  // size가 10인 배열 순회

    for (i in 1..10) {
        sum += i
    }
    println("sum = $sum")

    for (i in 1 until 10 step 2) {
        println("odd num : $i")
    }

    for (i in 20 downTo 1 step 3) {
        println("down To $i")
    }

}
