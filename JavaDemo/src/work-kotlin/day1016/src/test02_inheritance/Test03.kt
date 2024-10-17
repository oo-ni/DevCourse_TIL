package test02_inheritance

open class Super1 {
    open val name : String = "hong"
}

open class Sub1: Super1() {
    final override val name: String = "kim"
}