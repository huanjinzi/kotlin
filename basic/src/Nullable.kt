package nullable

// ...

// Using nullable values and checking for #null

// A reference must be explicitly marked as nullable when #null value is possible, such as #Int?
// Return #null if #str dose not hold an integer:
fun parseInt(str: String): Int? {
    // ...
    return null
}

// Using a function returning nullable values:
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using #x*y yields error because they may hold nulls
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
        return
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }

    // ... or

    if (null == x) {
        println("Wrong number format in arg1:'$arg1'")
        return
    }

    if (null == y) {
        println("Wrong number format in arg2:'$arg2'")
        return
    }

    println(x * y)
}

