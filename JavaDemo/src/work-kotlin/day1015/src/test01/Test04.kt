package test01

fun main() {
    var list = listOf("aaa", "bbb", "tomato")

    for (str in list) {     // list에 들어있는 데이터 자체를 str에 순차적으로 꺼내서 반복함
        print(str)
    }
    println("\n-------------------------------")

    println(list.indices)   // 이렇게 리스트의 인덱스만 떼서 얻어올 수 있음. -> 0..2

    for (i in list.indices) {
        println("$i -- ${list[i]}")
    }

    // withIndex() -> 인덱스와 값 모두 가져올 수 있음.
    for ((idx, value) in list.withIndex()) {
        println("$idx is $value")
    }
}
