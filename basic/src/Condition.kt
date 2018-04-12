package condition

// ...

// Using conditional expressions
fun maxOf(a:Int,b:Int):Int{

    if (a > b) {
        return a
    } else {
        return b
    }
}

// Using if as an expression
fun maxOfExpression(a: Int, b: Int) = if (a > b) a else b

