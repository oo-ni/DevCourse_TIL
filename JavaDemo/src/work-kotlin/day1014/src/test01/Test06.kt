package test01

fun main() {
    var num = 100
    println("문자열 내부에 변수값 포함시킬 때"+num+" 자바는 이렇게 이어붙이기 했었쥬? 귀찮쥬?")
    println("코틀린은 ${num+100} 이렇게 끼워넣게 해줬습니다.")
    println("코틀린은 $num 이렇게 끼워넣게 해줬습니다. 값 조작없이 그대로 문자열에 끼워 넣는거면 중괄호도 생략가능.")
    
    var str = """
        동해물과
        
        백두산이
        
        
        
        마르고닳도록 이렇게 줄바꿈까지 다 적용되는 문자열이 있음
    """
    println(str)
}