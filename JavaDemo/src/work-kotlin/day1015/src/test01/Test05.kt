package test01

fun main() {
    // 배열 <-> 리스트로 왔다갔다 바꾸는 경우 생기는 상황들
    val arr1 = arrayOf(10, 20, 30)      // 얘는 배열 -> 리스트로 바꾸고 싶을 때 선택지 (불변리스트 or 가변리스트)
    val list1 = arr1.toList()           // 불변리스트
    val list2 = arr1.toMutableList()    // 가변리스트
    list2.add(500)
    list2.add(600)
    val arr2 = list2.toTypedArray()     // 리스트 -> 배열로 만들기

    val list3 = listOf(1, 2, arr1[0], arr1[1], arr1[2], 500, 600)   // 배열에 있는 데이터 포함하면서 좀 더 추가해서 리스트 만들기.
    val list4 = listOf(1, 2, *arr1, 500, 600)   // 전개 연산자로 위 배열에 있는 요소를 *arr1 하나로 쭉 펴바름

    val arr3 = arrayOf("abc", "tomato", "banana")
    myPrint(*arr3)      // arr3[0], arr3[1], arr3[2] 이렇게 하나하나 펼쳐 넣는 것과 동일한 행동
}

fun myPrint(vararg params: Any) {
    for (item in params) {
        println(item)
    }
}