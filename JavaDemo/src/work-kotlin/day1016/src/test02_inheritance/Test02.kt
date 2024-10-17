package test02_inheritance

open class Shape2 {
    var x = 0
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    var y = 0
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    lateinit var name: String
    open fun print() {
        println("$name : location $x, $y")
    }
}

class Rect: Shape2() {
    var width: Int = 0
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    var height: Int = 0
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    override fun print() {
        super.print()
        println("width: $width, height: $height")
    }
}

class Circle2: Shape2() {
    var r: Int = 0
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    override fun print() {
        super.print()
        println("radius: $r")
    }
}